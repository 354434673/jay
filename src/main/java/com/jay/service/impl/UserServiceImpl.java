package com.jay.service.impl;

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
	/* (non-Javadoc)
	 * @see com.jay.service.UserService#updateState(java.lang.String, java.lang.String)
	 */
	@Override
	public void updateState(String userName, String email) {
		
		userDao.updateState(userName, email);
	}
	
}
