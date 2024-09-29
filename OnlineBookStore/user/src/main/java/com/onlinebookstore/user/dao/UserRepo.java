package com.onlinebookstore.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebookstore.user.model.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByEmail(String email);
}