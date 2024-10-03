package com.onlinebookstore.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.onlinebookstore.user.dao.UserRepo;
import com.onlinebookstore.user.dto.UserDto;
import com.onlinebookstore.user.helper.JWTService;
import com.onlinebookstore.user.helper.ManualException;
import com.onlinebookstore.user.model.BookModel;
import com.onlinebookstore.user.model.UserEntity;

@Service
public class UserService implements UserServiceImp {

	@Autowired
	private UserRepo repo;
	@Autowired
	private JWTService jwtService;

	public UserEntity registerUser(UserEntity model) {
		Optional<UserEntity> modelOpt = repo.findByEmail(model.getEmail());
		if (modelOpt.isEmpty()) {
			return repo.save(model);
		}
		throw new ManualException("User already exist please login");
	}

	public String loginUser(UserEntity model) {
		UserEntity data = repo.findByEmail(model.getEmail())
				.orElseThrow(() -> new ManualException("User doesn't exist please register"));
		if (data.getPassword().equals(model.getPassword())) {
			return jwtService.generateToken(data.getName(), data.getEmail());
		}
		return null;
	}

//	public UserEntity getUserProfile(Long userId) {
//		UserEntity model=repo.findById(userId).orElseThrow(() -> new ManualException("User does not exist"));
//		List<BookModel> list=new ArrayList<>();
//		list.add(getBooks(userId));
//		model.setBooks(list);
//		return model;
//	}

	public BookModel getBooks(Long userId) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8082/books/user/" + userId;
		ResponseEntity<BookModel> responseEntity = restTemplate.getForEntity(url, BookModel.class);
		return responseEntity.getBody();
	}

	@Override
	public UserDto getUserProfile(Long userId) {

		UserDto userDto = new UserDto();

		// TODO Auto-generated method stub
		UserEntity data = repo.findById(userId).get();
		userDto.setEmail(data.getEmail());
		userDto.setName(data.getName());
		return userDto;
	}

	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
