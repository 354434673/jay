package com.jay.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jay.entity.User;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-29 时间：下午5:31:21
 *@version 1.0
 */
public interface UserService {
	/**
	 * 用于验证该用户是否存在
	 *@param userName
	 *@return
	 */
	Map<String,Boolean> valiDataUserName(String userName);
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
	/**
	 * 判断用户是否激活
	 *@param userName
	 *@return
	 */
	boolean valiUserActivate(@Param("user_username")String userName);
}
