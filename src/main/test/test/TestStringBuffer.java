/**
 * author:Young
 * 2016-12-19下午4:50:56
 */
package test;

import org.junit.Test;

/**
 *类描述：
 *@author: BruceWayne
 *@date： 日期：2016-12-19 时间：下午4:50:56
 *@version 1.0
 */
public class TestStringBuffer {
	@Test
	public void test(){
		long startTime;  
		long endTime;  
		/**
		 * 测试StringBuffer
		 */
		StringBuffer buffer = new StringBuffer(512);  
		startTime = System.currentTimeMillis();  
		for(int i = 0; i < 100; i++){  
			    buffer.append(i);  
		}  
		endTime = System.currentTimeMillis();  
		System.out.println(endTime -startTime);//结果13  
		/**
		 * 测试StringBuilder
		 */
		StringBuilder builder = new StringBuilder(512);  
			startTime = System.currentTimeMillis();  
		for(int i = 0; i < 100; i++){  
		    builder.append(i);  
			}  
		endTime = System.currentTimeMillis();  
		System.out.println(endTime -startTime);//结果3  
		/**
		 * 测试String
		 */
		String str="512";
		startTime = System.currentTimeMillis();  
		for(int i = 0; i < 100; i++){  
			str+=i; 
		}  
		endTime = System.currentTimeMillis();  
		System.out.println(endTime -startTime);//19209

	}
}
