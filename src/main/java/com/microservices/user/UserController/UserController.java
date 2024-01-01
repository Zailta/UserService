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

import com.microservices.user.UserBean.UserBean;
import com.microservices.user.UserService.UserServiceInterface.UserService;

@RestController
@RequestMapping(value = "/microservice/user")
public class UserController {

	@Autowired
	UserService service;
	//create user
	
	@PostMapping(value = "/create")
	public ResponseEntity<UserBean> createUser( @RequestBody UserBean bean){
		UserBean creatdUser = service.createUser(bean);
		return ResponseEntity.ok(creatdUser);
	}
	//findSingle User
	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserBean> findUser( @PathVariable String userId){
		UserBean singleUser = service.getSingleUser(userId);
		return ResponseEntity.ok(singleUser);
	}
	
	//FindAllusers
	@GetMapping(value = "/")
	public ResponseEntity<List<UserBean>> findAll(){
		List<UserBean> allIUsers = service.getAllIUsers();
		return ResponseEntity.ok(allIUsers);
	}
}

