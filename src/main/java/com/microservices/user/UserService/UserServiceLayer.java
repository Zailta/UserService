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
	@Autowired
	ModelMapper mapper;

	@Override
	public UserEntity createUser(UserEntity bean) {
		UserEntity savedUser = repository.save(mapper.map(bean, UserEntity.class));
		return savedUser;
	}

	@Override
	public UserEntity getSingleUser(String userid) {
		UserEntity userEntity = repository.findById(userid).orElseThrow(()->new EXNResourceNotFoundException("User", "ID", userid));
		return userEntity;
	}

	@Override
	public List<UserEntity> getAllIUsers() {
		List<UserEntity> findAll = repository.findAll();
		List<UserEntity> allUsers = findAll.stream().map(user ->user).collect(Collectors.toList());
		return allUsers;
	}


	
}
