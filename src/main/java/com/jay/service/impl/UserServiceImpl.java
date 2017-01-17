package com.jay.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.jay.controller.baseController;
import com.jay.dao.UserDao;
import com.jay.entity.User;
import com.jay.service.UserService;
import com.jay.util.FinalData;
import com.jay.util.Md5Util;
import com.jay.util.saltUtil;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-29 时间：下午5:31:54
 *@version 1.0
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public void registUser(User user){
		
		String salt = saltUtil.getSalt(4);
		
		String password = new Md5Hash(user.getUserPassword(), salt, 1024).toString();
		
		user.setUserPassword(password);
		
		user.setUserSalt(salt);
		
		userDao.registUser(user);
	}
	@Override
	public void updateState(String userName, String email) {
		
		userDao.updateState(userName, email);
	}
	@Override
	public Map<String,Boolean> valiDataUserName(String userName) {
		
		User loginUser = userDao.loginUser(userName);
		
		Map<String,Boolean> map = new HashMap<String, Boolean>();
		
		if(loginUser==null){
			/**
			 * remote验证所需要的json数据
			 */
			map.put("valid", true);//true表示合法,验证通过
		}else{
			map.put("valid", false);//fasle表示不合法,验证不通过
		}
		return map;
	}
	@Override
	public boolean valiUserActivate(String userName) {
		
		User loginUser = userDao.loginUser(userName);
		
		char userActivate = loginUser.getUserActivate();
		
		if(userActivate == '0'){//未激活
			return false;
		}else{//激活
			return true;
		}
	}
}
