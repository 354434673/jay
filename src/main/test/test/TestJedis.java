package test;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 *@author: BruceWayne
 *@date： 日期：2017-1-11 时间：下午6:04:03
 *@version 1.0
 */
public class TestJedis {
	private JedisPool jedis;

	@Before
	public void before(){
        JedisPoolConfig config = new JedisPoolConfig();
        jedis = new JedisPool(config, "192.168.139.2", 6379, 1, "123");
	}
	@Test
	public void test(){
		Jedis resource = jedis.getResource();
		System.out.println(resource);
	}
}
