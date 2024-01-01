package com.microservices.user.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.user.UserEntity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

	
}
