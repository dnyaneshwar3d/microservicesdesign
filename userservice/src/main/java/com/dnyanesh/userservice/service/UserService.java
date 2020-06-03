package com.dnyanesh.userservice.service;

import java.util.List;

import com.dnyanesh.userservice.model.UserDetails;

public interface UserService {
	
	UserDetails login();
	
	UserDetails getUser(Integer userId);
	
	List<UserDetails> getAllUser();
	
	UserDetails createUser(UserDetails userDetails);
	
	UserDetails updateUser(UserDetails userDetails);
	
	String deleteUser(int userId);
	
	String forgetPassword(UserDetails userDetails);

}
