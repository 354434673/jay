package com.jay.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-29 时间：下午6:09:37
 *@version 1.0
 */
public class Md5Util {
	
	public static String getMd5(String password, String salt){
		
		Md5Hash md5Hash = new Md5Hash(password, salt, 1024);
		
		return md5Hash.toString();
	}
}
