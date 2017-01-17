package test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;

import com.jay.dao.UserDao;
import com.jay.entity.User;



/**
 *@author: BruceWayne
 *@date： 日期：2016-12-28 时间：下午4:36:44
 *@version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")  
public class SpringTest{
	@Resource
	private UserDao userDao;
	
	@Test
	public void test4(){
		User loginUser = userDao.loginUser("BruceWayne");
	}
}
