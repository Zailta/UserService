package com.microservices.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.user.Exception.CustomExceptions.EXNResourceNotFoundException;
import com.microservices.user.UserEntity.UserEntity;
import com.microservices.user.UserRepository.UserRepository;
import com.microservices.user.UserService.UserServiceInterface.UserService;


@Service
public class UserServiceLayer implements UserService{
	@Autowired
	UserRepository repository;

	@Override
	public UserEntity createUser(UserEntity bean) {
		UserEntity savedUser = repository.save(bean);
		return savedUser;
	}

	@Override
	public UserEntity getSingleUser(String userid) {
		UserEntity userEntity = repository.findById(userid).orElseThrow(()->new EXNResourceNotFoundException("User", "ID", userid));
		return userEntity;
	}

	@Override
	public List<UserEntity> getAllIUsers() {
		
		List<UserEntity> allUsers = repository.findAll();
		return allUsers;
	}


	
}
