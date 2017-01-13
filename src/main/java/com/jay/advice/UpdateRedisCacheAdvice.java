package com.jay.advice;

import java.util.Set;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.DigestUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 业务层增删改时更新当前业务层缓存数据
 */
public class UpdateRedisCacheAdvice implements MethodInterceptor {

	@Resource
	private  JedisPool jedisPool;
	
	
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object proceed = null;
		Jedis jedis = null;
		try {
			jedis= jedisPool.getResource();
			//执行业务方法
			proceed= mi.proceed();
			//清除当前业务缓存
			String className = mi.getThis().getClass().getName();
			jedis.del(className);
			/*String className = mi.getThis().getClass().getName();
			String classNameMd5DigestAsHexPrefix = DigestUtils.md5DigestAsHex(className.getBytes());
			//获取当前业务层缓存所有key
			Set<String> hkeys = jedis.hkeys(className);
			for (String key : hkeys) {
				if(key.startsWith(classNameMd5DigestAsHexPrefix)){
					jedis.hdel(className, key);
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(jedis!=null){
//				jedis.close();
			}
		}
		
		return proceed;
	}

}
