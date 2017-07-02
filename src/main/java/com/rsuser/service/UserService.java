package com.rsuser.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rsuser.utils.Constant;
import com.rsuser.domain.LocalAuth;
import com.rsuser.domain.User;
import com.rsuser.domain.UserRegDto;
import com.rsuser.domain.UserRepository;




@Service("userService")
public class UserService {
	@Resource
	private UserRepository userRepository;
	@Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	public LocalAuth findUserByAccount(String account) {
		return userRepository.findUserByAccount(account);
	}
	
	public void saveUser(UserRegDto Ruser) {
		User user = new User(Ruser.getEmail(), Constant.UN_AUTH_STATUS);
		userRepository.SaveUser(user);
		LocalAuth localAuth = new LocalAuth(Ruser.getAccountid(), Ruser.getEmail(), bCryptPasswordEncoder.encode(Ruser.getSetpw()), user);
		userRepository.SaveLocalAuth(localAuth);
	}
	
	public void updateUser(User user){
		userRepository.UpdateUser(user);
	}
}
