package test;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jay.dao.UserDao;
import com.jay.entity.User;

/**
 *@author: BruceWayne
 *@date： 日期：2016-12-28 时间：下午4:36:44
 *@version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
	@Resource
	private UserDao userDao;
	@Test
	public void test(){
		User loginUser = userDao.loginUser("BruceWayne");
		System.out.println(loginUser);
		
	}
	@Test
	public void test2(){
		userDao.registUser(new User("1", "aa", "aew", "123213", "13214", 12321044L, '1', "ning", new Date(), "123123", new Date(), '1', "213214", '2',new Date()));
	}
	@Test
	public void Test3(){
		for (TestEnum e : TestEnum.values()) {
			System.out.println(e.toString());
		}
		System.out.println(TestEnum.FRI);
	}
}
