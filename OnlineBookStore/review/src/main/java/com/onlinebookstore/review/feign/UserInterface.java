package com.onlinebookstore.review.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinebookstore.review.pojo.UserDto;



@FeignClient("ONLINE-BOOK-STORE-USER")
public interface UserInterface {
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserProfile(@PathVariable Long userId);
}
