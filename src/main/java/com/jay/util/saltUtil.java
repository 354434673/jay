package com.jay.util;

import java.util.Random;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-29 时间：下午5:46:46
 *@version 1.0
 */
public class saltUtil {
	public static String getSalt(int n){
		char[] randChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(randChar[new Random().nextInt(randChar.length)]);
		}
		return sb.toString();
	}
}
