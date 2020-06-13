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

import com.dnyanesh.userservice.beans.UserDetails;
import com.dnyanesh.userservice.model.User;
import com.dnyanesh.userservice.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1")
@Api(value = "UserController", description = "This API is for the user related operations")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getUsers() {
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
	public User updateUser(@RequestBody User userDetails) {
		userService.updateUser(userDetails);
		return userDetails;
	}

	@DeleteMapping("/user/{userid}")
	public String deleteUser(@PathVariable Integer userid) {
		return userService.deleteUser(userid);
	}

}
