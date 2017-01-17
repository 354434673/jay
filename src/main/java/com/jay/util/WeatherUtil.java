package com.jay.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *@author: BruceWayne
 *@date： 日期：2017-1-3 时间：下午3:16:22
 *@version 1.0
 */
public class WeatherUtil {
	
	public static String getWeatherInform(String cityName) {
		// 百度天气API
		String baiduUrl = null;
		try {
			baiduUrl = "http://api.map.baidu.com/telematics/v3/weather?location="
					+ URLEncoder.encode(cityName, "utf-8")
					+ "&output=json&ak=g5mrE9SYg9Zwwt5NzgT31dmmGQZ3j1Dm";
			//g5mrE9SYg9Zwwt5NzgT31dmmGQZ3j1Dm 需要自己去百度申请一个ApiKey
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		StringBuffer strBuf;

		strBuf = new StringBuffer();
		try {
			URL url = new URL(baiduUrl);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));// 转码。
			String line = null;
			while ((line = reader.readLine()) != null)
				strBuf.append(line + " ");
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}
		return strBuf.toString();
	}
}
