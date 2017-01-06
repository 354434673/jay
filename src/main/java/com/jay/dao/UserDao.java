package com.jay.dao;

import org.apache.ibatis.annotations.Param;

import com.jay.entity.User;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-29 时间：上午11:40:25
 *@version 1.0
 */
public interface UserDao {
	/**
	 * 根据用户名认证该用户,获取密码
	 *@param userName
	 *@return
	 */
	User loginUser(@Param("user_username")String userName);
	/**
	 * 注册用户
	 *@param user
	 *@return
	 */
	void registUser(User user);
	/**
	 * 激活后更改用户状态
	 *@param userName
	 *@param email
	 */
	void updateState(@Param("user_username")String userName, @Param("user_email")String email);
}
