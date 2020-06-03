package com.dnyanesh.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dnyanesh.userservice.exceptions.ResourceNotFoundException;
import com.dnyanesh.userservice.model.UserDetails;
import com.dnyanesh.userservice.repository.UserRepository;
import com.dnyanesh.userservice.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	public RestTemplate restTemplate;

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<UserDetails> getUsers() {
		return userService.getAllUser();
	}

	@GetMapping("/user/{userid}")
	public ResponseEntity<UserDetails> getUser(@PathVariable Integer userid) {
		return ResponseEntity.ok().body(userService.getUser(userid));
	}

	@PostMapping("/user")
	public UserDetails createUser(@RequestBody UserDetails userDetails) {
		return userService.createUser(userDetails);
	}

	@PutMapping("/user")
	public UserDetails updateUser(@RequestBody UserDetails userDetails) {
		userService.updateUser(userDetails);
		return userDetails;
	}

	@DeleteMapping("/user/{userid}")
	public String deleteUser(@PathVariable Integer userid) {
		return userService.deleteUser(userid);
	}

}
