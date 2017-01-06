package com.jay.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

import com.jay.dao.UserDao;
import com.jay.entity.User;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-28 时间：下午4:10:07
 *@version 1.0
 */
public class CustmerMd5 extends AuthenticatingRealm{
	@Resource
	private UserDao userDao;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取token中主身份信息
		String userName = (String) token.getPrincipal();
		
		User loginUser = userDao.loginUser(userName);
		//根据主身份查询数据库
		if(userName.equals(loginUser.getUserName())){
			return new SimpleAuthenticationInfo(loginUser.getUserName(), loginUser.getUserPassword(),ByteSource.Util.bytes(loginUser.getUserSalt()) ,this.getName());
		}
		return null;
	}
}
