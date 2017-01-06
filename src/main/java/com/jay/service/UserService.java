package com.jay.service;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.jay.dao.UserDao;
import com.jay.entity.User;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-29 时间：下午5:31:21
 *@version 1.0
 */
public interface UserService {
	/**
	 * 用户注册service
	 *@param user
	 */
	void registUser(User user);
	/**
	 * 更改
	 *@param userName
	 *@param email
	 */
	void updateState(String userName, String email);
}
