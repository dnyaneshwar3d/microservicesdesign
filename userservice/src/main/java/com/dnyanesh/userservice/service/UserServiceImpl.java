package com.dnyanesh.userservice.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dnyanesh.userservice.beans.UserAddress;
import com.dnyanesh.userservice.beans.UserDetails;
import com.dnyanesh.userservice.model.Address;
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
	public UserDetails getUser(Integer userId) {
		User user = userRepository.findById(userId).get();
		UserAddress userAddress = UserAddress.builder()
				.id(user.getAddress().getId())
				.line1(user.getAddress().getLine1())
				.line2(user.getAddress().getLine2())
				.city(user.getAddress().getCity())
				.build();
				
		UserDetails userDetails = UserDetails.builder()
				.userId(user.getUserId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.userName(user.getUserName())
				.address(userAddress)
				.build();
		
		return userDetails;
	}

	@Override
	public UserDetails createUser(UserDetails userDetails) {
		Address address = Address.builder()
				.id(userDetails.getAddress().getId())
				.line1(userDetails.getAddress().getLine1())
				.line2(userDetails.getAddress().getLine2())
				.city(userDetails.getAddress().getCity())
				.build();
		User user = User.builder()
				.userId(userDetails.getUserId())
				.firstName(userDetails.getFirstName())
				.lastName(userDetails.getLastName())
				.userName(userDetails.getUserName())
				.createdOn(new Date())
				.updatedOn(null)
				.address(address)
				.build();
		
		
		User createUser = userRepository.save(user);
		
		UserAddress userAddress = UserAddress.builder()
				.id(createUser.getAddress().getId())
				.line1(createUser.getAddress().getLine1())
				.line2(createUser.getAddress().getLine2())
				.city(createUser.getAddress().getCity())
				.build();
				
		UserDetails createdUserDetails = UserDetails.builder()
				.userId(createUser.getUserId())
				.firstName(createUser.getFirstName())
				.lastName(createUser.getLastName())
				.userName(createUser.getUserName())
				.address(userAddress)
				.build();
		
		return createdUserDetails;
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
