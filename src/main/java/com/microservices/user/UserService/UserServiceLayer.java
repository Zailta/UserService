package com.microservices.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.user.Exception.CustomExceptions.EXNResourceNotFoundException;
import com.microservices.user.UserBean.UserBean;
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
	public UserBean createUser(UserBean bean) {
		UserEntity savedUser = repository.save(mapper.map(bean, UserEntity.class));
		return mapper.map(savedUser, UserBean.class);
	}

	@Override
	public UserBean getSingleUser(String userid) {
		UserEntity userEntity = repository.findById(userid).orElseThrow(()->new EXNResourceNotFoundException("User", "ID", userid));
		return mapper.map(userEntity, UserBean.class);
	}

	@Override
	public List<UserBean> getAllIUsers() {
		List<UserEntity> findAll = repository.findAll();
		List<UserBean> allUsers = findAll.stream().map(user ->mapper.map(user, UserBean.class)).collect(Collectors.toList());
		return allUsers;
	}


	
}
