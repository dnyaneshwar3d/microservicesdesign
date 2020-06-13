package com.dnyanesh.userservice.service;

import java.util.List;

import com.dnyanesh.userservice.beans.UserDetails;
import com.dnyanesh.userservice.model.User;

public interface UserService {
	
	User login();
	
	UserDetails	getUser(Integer userId);
	
	List<User> getAllUser();
	
	User createUser(User userDetails);
	
	User updateUser(User userDetails);
	
	String deleteUser(int userId);
	
	String forgetPassword(User userDetails);

}
