package com.microservices.user.UserService.UserServiceInterface;


import com.microservices.user.UserEntity.UserEntity;

import java.util.List;

public interface UserService {

	UserEntity createUser(UserEntity bean);
	UserEntity getSingleUser(String userid);
	List<UserEntity> getAllIUsers();

}
