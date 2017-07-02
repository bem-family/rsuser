package com.rsuser.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsuser.domain.LocalAuth;
import com.rsuser.domain.UserRegDto;
import com.rsuser.service.UserService;



@Controller
public class LoginController{
	@Resource
	private UserService userService;
	@Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@PostMapping("/registration")
	public @ResponseBody Map<String, Object> createNewUser(@Valid UserRegDto user) {
		Map<String, Object> map = new HashMap<String, Object>();
		LocalAuth localAuth = userService.findUserByAccount(user.getAccountid());
		if (localAuth != null) {
			map.put("data", "userExists");
			return map;
		}
		userService.saveUser(user);
		map.put("data", "success");
		return map;
	}
	
	/**
	 * test login success
	 * @return
	 */
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
	/**
	 * test CSRF
	 * @return
	 */
	@PostMapping("/testCSRF")
	public @ResponseBody String CSRF(){
		return "sssss";
	}
}
