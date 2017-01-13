package com.jay.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.jay.entity.User;
import com.jay.service.UserService;
import com.jay.util.FinalData;
import com.jay.util.SendEmail;
import com.jay.util.saltUtil;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-28 时间：下午5:13:04
 *@version 1.0
 */
@Controller
@RequestMapping("user")
public class UserController{
	@Resource
	private UserService userService;
	@Resource
	private JedisPool jedisPool;
	
	/**
	 * 用户登录认证
	 *@param userName
	 *@param password
	 *@return
	 */
	@RequestMapping("login")
	public String Login(String userName, String password){
		
		Subject subject = SecurityUtils.getSubject();
		
		subject.login(new UsernamePasswordToken(userName, password));
		
		return "redirect:/page/main.jsp";
	}
	@RequestMapping("regist")
	public String registUser(String userName, String realName, String password, String email, 
							String idCard, Long telphone, String birthday, char sex){
		String validateCode = saltUtil.getSalt(20);//生成20位激活码
		
		jedisPool.getResource().setex("validateCode", 600, validateCode);
		//刚注册时为未激活
		userService.registUser(new User(UUID.randomUUID().toString(), realName, userName, 
								password, null, telphone, sex, email, new Date(), idCard, 
								new Date(), FinalData.NONACTIVATED, null, FinalData.STATE_NORMAL, new Date()));
		
		SendEmail.sendTxtMail(email, FinalData.getValidate(userName, email, validateCode));
		
		return "redirect:/page/validata.jsp";
	}
	/**
	 * 注册成功修改激活状态 session不同
	 *@return
	 */
	@RequestMapping("updateUserActivate")
	public String updateUserActivate(String userName,String email,String validateCode){
		
		String validate = jedisPool.getResource().get("validateCode");
		System.out.println(validate);
		if(validateCode.equalsIgnoreCase(validate)){//从redis中取出
			//修改用户为激活状态
			userService.updateState(userName, email);
			
			jedisPool.getResource().del("validateCode");//激活成功后清除redis数据
		}
		return "redirect:/page/login.jsp";
	}
}
