package test;

import java.io.Serializable;

import javax.annotation.Resource;

import org.apache.tomcat.jni.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;



/**
 *@author: BruceWayne
 *@date： 日期：2016-12-28 时间：下午4:36:44
 *@version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")  
public class SpringTest{
	@Resource
	private	JedisPool jedisPool;
	
	@Test
	public void test4(){
		Jedis resource = jedisPool.getResource();
//		resource.setex("123", 100, "123");
		System.out.println(resource.get("abc"));
	}
}
