package com.jay.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jay.service.UserService;

/**用于验证各种各种的控制层
 *@author: BruceWayne
 *@date： 日期：2017-1-12 时间：下午6:06:17
 *@version 1.0
 */
@Controller
@RequestMapping("validata")
public class ValidateController {
	@Resource
	private UserService userService;
	
	@RequestMapping("userName")
	public @ResponseBody Map<String, Boolean> validataUserName(String userName){
		
		Map<String, Boolean> valiDataUserName = userService.valiDataUserName(userName);
		
		return valiDataUserName;
	}
}
