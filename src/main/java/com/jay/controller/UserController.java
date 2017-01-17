package com.jay.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.JedisPool;

import com.jay.dao.UserDao;
import com.jay.entity.User;
import com.jay.service.UserService;
import com.jay.util.FinalData;
import com.jay.util.SendEmail;
import com.jay.util.saltUtil;

/**
 * @author: BruceWayne
 * @date： 日期：2016-12-28 时间：下午5:13:04
 * @version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController extends baseController {
	@Resource
	private UserDao userDao;
	@Resource
	private UserService userService;
	@Resource
	private JedisPool jedisPool;

	/**
	 * 用户登录认证
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("login")
	public String Login(String userName, String password) {
		try {
			Subject subject = SecurityUtils.getSubject();

			subject.login(new UsernamePasswordToken(userName, password));

			boolean valiUserActivate = userService.valiUserActivate(userName);

			if (valiUserActivate) {// 若激活,则进入主页面

				return "redirect:/page/main.jsp";
			} else {// 若未激活,则跳入激活页面
				/**
				 * 获取用户信息,获取用户邮箱,存入request中.一次请求有效
				 */
				User loginUser = userDao.loginUser(userName);
				
				request.setAttribute("userName", userName);
				
				request.setAttribute("email", loginUser.getUserEmali());
				
				return "/page/login/userValidata";
			}
		} catch (IncorrectCredentialsException e) {// 密码错误异常
			return "redirect:/page/login/errorPage/loginError.jsp";
		} catch (AuthenticationException e) {// 用户不存在
			return "redirect:/page/login/errorPage/userNotSaveError.jsp";
		}
	}

	@RequestMapping("regist")
	public String registUser(String userName, String realName, String password,
			String email, String idCard, Long telphone, String birthday,
			char sex) {
		try {
			String validateCode = saltUtil.getSalt(20);// 生成20位激活码

			jedisPool.getResource().setex(userName + email, 600, validateCode);// 10分钟自动失效,键为当前用户和用户email

			// 刚注册时为未激活
			userService.registUser(new User(UUID.randomUUID().toString(), realName,
					userName, password, null, telphone, sex, email, new Date(),
					idCard, new Date(), FinalData.NONACTIVATED, null,
					FinalData.STATE_NORMAL, new Date()));

			SendEmail.sendTxtMail(email,FinalData.getValidate(userName, email, validateCode));
			
			request.setAttribute("userName", userName);
			
			request.setAttribute("email", email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "page/login/validata";
	}

	/**
	 * 注册成功修改激活状态 
	 * 
	 * @return
	 */
	@RequestMapping("updateUserActivate")
	public String updateUserActivate(String userName, String email,
			String validateCode) {
		try {
			String validate = jedisPool.getResource().get(userName + email);
			if (validateCode.equalsIgnoreCase(validate)) {// 从redis中取出
				// 修改用户为激活状态
				userService.updateState(userName, email);

				jedisPool.getResource().del(userName + email);// 激活成功后清除redis数据
			}else{//如果验证码则让用户重新发送邮件激活
				request.setAttribute("userName", userName);
				
				request.setAttribute("email", email);
				
				return "/page/login/userValidata";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/page/login/login.jsp";
	}
	/**
	 * 未激活用户登陆发送邮件
	 *@param userName
	 *@param email
	 *@param validateCode
	 *@return
	 */
	@RequestMapping("noActivateSendEmail")
	public String loginSendEmail(String userName, String email) {
		try {
			String validateCode = saltUtil.getSalt(20);// 生成20位激活码

			jedisPool.getResource().setex(userName + email, 600, validateCode);// 10分钟自动失效,键为当前用户和用户email
			
			SendEmail.sendTxtMail(email,FinalData.getValidate(userName, email, validateCode));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/page/login/validata.jsp";
	}
}
