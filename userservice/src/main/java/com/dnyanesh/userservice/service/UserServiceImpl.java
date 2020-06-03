package com.dnyanesh.userservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnyanesh.userservice.model.UserDetails;
import com.dnyanesh.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDetails login() {
		return null;
	}

	@Override
	public UserDetails getUser(Integer userId) {
		// return userRepository.findById(userId).get();
		return new UserDetails();
	}

	@Override
	public List<UserDetails> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails createUser(UserDetails userDetails) {
		userDetails.setCreatedOn(new Date());
		userDetails.setUpdatedOn(null);
		return userRepository.save(userDetails);
	}

	@Override
	public UserDetails updateUser(UserDetails userDetails) {
		userDetails.setUpdatedOn(new Date());
		return userRepository.save(userDetails);
	}

	@Override
	public String deleteUser(int userId) {
		Optional<UserDetails> userDetails = userRepository.findById(userId);
		userRepository.delete(userDetails.get());
		return "true";
	}

	@Override
	public String forgetPassword(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return "success";
	}

}
