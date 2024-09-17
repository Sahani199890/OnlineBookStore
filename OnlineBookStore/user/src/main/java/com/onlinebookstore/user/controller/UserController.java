package com.onlinebookstore.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebookstore.user.model.UserModel;
import com.onlinebookstore.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserModel> registerUser(@RequestBody UserModel userDto) {
		UserModel registeredUser = userService.registerUser(userDto);
		return ResponseEntity.ok(registeredUser);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserModel userDto) {
		String token = userService.loginUser(userDto);
		return ResponseEntity.ok(token);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserModel> getUserProfile(@PathVariable Long userId) {
		UserModel userProfile = userService.getUserProfile(userId);
		return ResponseEntity.ok(userProfile);
	}
}