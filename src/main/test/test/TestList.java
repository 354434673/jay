package test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.junit.Test;

import redis.clients.jedis.JedisPool;

import com.jay.util.FinalData;
import com.jay.util.SendEmail;
import com.jay.util.WeatherUtil;
/**
 * 
*类描述：
*@author: BruceWayne
*@date： 日期：2016-12-9 时间：上午10:43:56
*@version 1.0
 */
public class TestList {
	 /**
	  * 
	  *方法描述：放入set中,此时是无序的
	  */
	@Test
	public void test(){
		List<String> list=new ArrayList<String>();
		
		list.add("JAVA");
		list.add("C+");
		list.add("PHP");
		list.add("JS");
		list.add("JAVA");
		list.add("MAVEN");
		list.add("PHP");
		System.out.print("未去重前的List:");
		System.out.println(list);
		System.out.print("去重后的List:");
		
		HashSet<String> set=new HashSet<String>(list);
		List<String> listAfter=new ArrayList<String>(set);
		
		System.out.println(listAfter);
	}
	/**
	 * 
	 *方法描述： 使去重后的集合按插入顺序排列
	 */
	@Test
	public void test2(){
		List<String> list=new ArrayList<String>();
		
		list.add("JAVA");
		list.add("C+");
		list.add("PHP");
		list.add("JS");
		list.add("JAVA");
		list.add("MAVEN");
		list.add("PHP");
		System.out.print("未去重前的List:");
		System.out.println(list);
		System.out.print("去重后的List:");
		LinkedHashSet<String> set=new LinkedHashSet<String>(list);
		
		List<String> listAfter=new ArrayList<String>(set);
		
		System.out.println(listAfter);
	}
	@Test
	public void test3(){
		String weatherInform = WeatherUtil.getWeatherInform("北京");
		System.out.println(weatherInform);
	}
	@Test
	public void test5() throws UnsupportedEncodingException, MessagingException{
/*        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
        MailSender mailSenderService = (MailSender) ac.getBean("mailSender");  
        MailBean mailBean = new MailBean();  
        mailBean.setFrom("ynshlove@163.com");  
        mailBean.setFromName("XXX");  
        mailBean.setSubject("你好");  
        mailBean.setToEmails(new String[]{"354434673@qq.com"});  
        mailBean.setContext("<a href='www.baidu.com'><font color='red'>fdsfdsf</font></a>");  
        mailSenderService.sendMail(mailBean);  */
	}
	@Resource
	private JedisPool jedisPool;
	@Test
	public void test4(){
//		SendEmail.sendTxtMail("354434673@qq.com", FinalData.getValidate("aaa", "354434673@qq.com", "12312321"));
		
		jedisPool.getResource().set("354434673@qq.com", "a");
	}
}
