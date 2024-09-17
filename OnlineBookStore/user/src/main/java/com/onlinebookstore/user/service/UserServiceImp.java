package com.onlinebookstore.user.service;

import com.onlinebookstore.user.model.UserModel;

public interface UserServiceImp {

	UserModel registerUser(UserModel userDto);

	String loginUser(UserModel userDto);

	UserModel getUserProfile(Long userId);
}
