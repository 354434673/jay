package com.jay.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;

public class baseController {
		protected HttpServletResponse response;
		protected HttpServletRequest request;
		protected HttpSession session;
		@	ModelAttribute
		public void setAuttibute(HttpServletRequest request,HttpServletResponse response){
			this.request= request;
			this.response=response;
			this.session = request.getSession();
		}
		
}
