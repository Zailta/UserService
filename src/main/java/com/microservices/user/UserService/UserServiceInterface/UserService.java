package com.microservices.user.UserService.UserServiceInterface;

import com.microservices.user.UserBean.UserBean;

import java.util.List;

public interface UserService {

	UserBean createUser(UserBean bean);
	UserBean getSingleUser(String userid);
	List<UserBean> getAllIUsers();

}
