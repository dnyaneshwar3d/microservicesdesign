package com.dnyanesh.userservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnyanesh.userservice.model.User;
import com.dnyanesh.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	public UserRepository userRepository;

	@Override
	public User login() {
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Integer userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public User createUser(User userDetails) {
		userDetails.setCreatedOn(new Date());
		userDetails.setUpdatedOn(null);
		return userRepository.save(userDetails);
	}

	@Override
	public User updateUser(User userDetails) {
		userDetails.setUpdatedOn(new Date());
		return userRepository.save(userDetails);
	}

	@Override
	public String deleteUser(int userId) {
		Optional<User> userDetails = userRepository.findById(userId);
		userRepository.delete(userDetails.get());
		return "true";
	}

	@Override
	public String forgetPassword(User userDetails) {
		// TODO Auto-generated method stub
		return "success";
	}

}
