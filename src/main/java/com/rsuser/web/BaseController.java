package com.rsuser.web;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;

import com.rsuser.domain.User;
import com.rsuser.service.UserService;

public abstract class BaseController {

	@Resource
	private UserService userService;
	
	public String getCurrentUsername() {
	      return SecurityContextHolder.getContext().getAuthentication().getName();
	   }
	
	//当前的user
	public User getCurrentUser(){
		boolean userNotExists = (userService.findUserByAccount(getCurrentUsername()) == null);
		if(userNotExists){
			return null;
		}
		return userService.findUserByAccount(getCurrentUsername()).getUser();
	}

}
