package com.jay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *@author: BruceWayne
 *@date： 日期：2016-12-30 时间：下午2:16:37
 *@version 1.0
 */
@Controller
@RequestMapping("test")
public class test {
	@RequestMapping("email")
	public void email(String email){
		StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
		sb.append("<a href=\"http://localhost:8989/jay/user/register?action=activate&email=");
        sb.append(email); 
        sb.append("&validateCode="); 
        sb.append("123124123213");
        sb.append("\">http://localhost:8989/jay/user/register?action=activate&email="); 
        sb.append(email);
        sb.append("&validateCode=");
        sb.append("123124123213");
        sb.append("</a>");

        //发送邮件
	}
}
