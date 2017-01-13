package com.jay.util;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-30 时间：上午10:21:06
 *@version 1.0
 */
public class FinalData {
	
	public static final char ACTIVATE = '1';//激活
	
	public static final char NONACTIVATED = '0';//未激活
	
	public static final char STATE_NORMAL = '1';//正常
	
	public static final char STATE_FREEZE = '0';//冻结
	
	public static String getValidate(String userName, String email,String validateCode){
		
		StringBuffer sb=new StringBuffer("点击下面链接激活账号，10分钟内有效，请尽快激活！</br>");
			sb.append("<a href=\"http://localhost:8989/jay/user/updateUserActivate?email=");
	        sb.append(email); 
	        sb.append("&validateCode="); 
	        sb.append(validateCode);
	        sb.append("&userName=");
	        sb.append(userName);
	        sb.append("\">http://localhost:8989/jay/user/updateUserActivate?email="); 
	        sb.append(email);
	        sb.append("&validateCode=");
	        sb.append(validateCode);
	        sb.append("&userName=");
	        sb.append(userName);
	        sb.append("</a>");
	        sb.append("</br>(如果不能点击该链接地址，请复制并粘贴到浏览器的地址输入框)");
	        sb.append("<P>此邮件为系统所发，请勿直接回复。&nbsp; &nbsp; ");
	        sb.append("<BR><A class=font_blue12 href=\"http://www.51cto.com target=_blank>www.51cto.com</A>技术成就梦想");
	        sb.append("<BR>社区邮箱：<A href=\"http://354434673@qq.com target=_blank>354434673@qq.<WBR>com</A></P>");
	        
	   return sb.toString();
	}
}

