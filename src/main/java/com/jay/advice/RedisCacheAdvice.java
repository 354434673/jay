package com.jay.advice;

import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * 将业务层查询数据纳入redis缓存中
 */
public class RedisCacheAdvice implements MethodInterceptor {

	@Resource
	private  JedisPool jedisPool;
	
	public Object invoke(MethodInvocation mi) throws Throwable {
		//获取jedis
		Object proceed = null;
		Jedis jedis  = null;
		try {
			jedis= jedisPool.getResource();
			String json = jedis.hget(mi.getThis().getClass().getName(),getKey(mi));
			//使用spring框架提供工具类 isEmpty 字符串为空 |字符串为空串返回 true
			if(StringUtils.isEmpty(json)){
				proceed = mi.proceed();
				//放入redis缓存中
				jedis.hset(mi.getThis().getClass().getName(), getKey(mi), JSON.toJSONString(proceed));
			}else{
				//获取当前方法的类型
				Type genericReturnType = mi.getMethod().getGenericReturnType();
				proceed = JSON.parseObject(json, genericReturnType);
			}
		} catch (Exception e) {
			System.out.println("reids服务宕机....");
			proceed = mi.proceed();
		}finally{
			if(jedis!=null){
				jedis.flushDB();
			}
		}
		return proceed;
	}
	
	
	/**
	 * 生成key
	 * key= MD5(类的全限定名)+Md5(方法的签名+方法的参数列表)
	 */
	public String getKey(MethodInvocation mi){
		//类的全限定名
		String className  = mi.getThis().getClass().getName();
		//通过spring工具类给类名生成md5
		String classNameMd5DigestAsHex = DigestUtils.md5DigestAsHex(className.getBytes());
		//方法的签名
		StringBuilder sb = new StringBuilder();
		String methodName = mi.getMethod().toString();
		sb.append(methodName);
		//方法的参数列表
		Object[] arguments = mi.getArguments();
		for (Object arg : arguments) {
			sb.append(arg);
		}
		//通过spring工具类给方法的参数和方法声明生成md5
		String methodNameMd5DigestAsHex = DigestUtils.md5DigestAsHex(sb.toString().getBytes());
		return classNameMd5DigestAsHex+"-"+methodNameMd5DigestAsHex;
	}

}
