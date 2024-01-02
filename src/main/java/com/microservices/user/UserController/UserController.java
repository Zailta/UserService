package com.microservices.user.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.UserEntity.*;
import com.microservices.user.UserService.UserServiceInterface.UserService;

@RestController
@RequestMapping(value = "/microservice/user")
public class UserController {

	@Autowired
	UserService service;
	//create user
	
	@PostMapping(value = "/create")
	public ResponseEntity<UserEntity> createUser( @RequestBody UserEntity bean){
		UserEntity creatdUser = service.createUser(bean);
		return ResponseEntity.ok(creatdUser);
	}
	//findSingle User
	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserEntity> findUser( @PathVariable String userId){
		UserEntity singleUser = service.getSingleUser(userId);
		return ResponseEntity.ok(singleUser);
	}
	
	//FindAllusers
	@GetMapping(value = "/")
	public ResponseEntity<List<UserEntity>> findAll(){
		List<UserEntity> allIUsers = service.getAllIUsers();
		return ResponseEntity.ok(allIUsers);
	}
}

