package com.onlinebookstore.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.onlinebookstore.user.dao.UserRepo;
import com.onlinebookstore.user.helper.JWTService;
import com.onlinebookstore.user.helper.ManualException;
import com.onlinebookstore.user.model.BookModel;
import com.onlinebookstore.user.model.UserModel;

@Service
public class UserService implements UserServiceImp {
	private final UserRepo repo;
	private final JWTService jwtService;

	public UserService(UserRepo repo, JWTService jwtService) {
		super();
		this.repo = repo;
		this.jwtService = jwtService;
	}

	public UserModel registerUser(UserModel model) {
		Optional<UserModel> modelOpt = repo.findByEmail(model.getEmail());
		if (modelOpt.isEmpty()) {
			return repo.save(model);
		}
		throw new ManualException("User already exist please login");
	}

	public String loginUser(UserModel model) {
		UserModel data = repo.findByEmail(model.getEmail())
				.orElseThrow(() -> new ManualException("User doesn't exist please register"));
		if (data.getPassword().equals(model.getPassword())) {
			return jwtService.generateToken(data.getName(), data.getEmail());
		}
		return null;
	}

	public UserModel getUserProfile(Long userId) {
		UserModel model=repo.findById(userId).orElseThrow(() -> new ManualException("User does not exist"));
		List<BookModel> list=new ArrayList<>();
		list.add(getBooks(userId));
		model.setBooks(list);
		return model;
	}

	public BookModel getBooks(Long userId) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8082/books/user/" + userId;
		ResponseEntity<BookModel> responseEntity = restTemplate.getForEntity(url, BookModel.class);
		return responseEntity.getBody();
	}

}
