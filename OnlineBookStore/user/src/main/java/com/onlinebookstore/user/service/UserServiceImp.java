package com.onlinebookstore.user.service;

import java.util.Optional;

import com.onlinebookstore.user.model.UserEntity;

public interface UserServiceImp {

	UserEntity registerUser(UserEntity userDto);

	String loginUser(UserEntity userDto);

	Optional<UserEntity> getUserProfile(Long userId);
}
