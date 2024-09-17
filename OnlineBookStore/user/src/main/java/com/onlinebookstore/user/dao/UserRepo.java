package com.onlinebookstore.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebookstore.user.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long>{

	Optional<UserModel> findByEmail(String email);
}