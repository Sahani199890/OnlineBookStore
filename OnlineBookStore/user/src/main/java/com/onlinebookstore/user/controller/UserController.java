package com.onlinebookstore.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.user.model.UserEntity;
import com.onlinebookstore.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity userDto) {
		UserEntity registeredUser = userService.registerUser(userDto);
	
	
		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserEntity userDto) {
		String token = userService.loginUser(userDto);
		return ResponseEntity.ok(token);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Optional<UserEntity>> getUserProfile(@PathVariable Long userId) {
		Optional<UserEntity> userProfile = userService.getUserProfile(userId);
		return ResponseEntity.ok(userProfile);
	}
	
	@GetMapping("/users")
	public List<UserEntity> getAllUsers() {
		return userService.getAllUsers();
	}
	

}