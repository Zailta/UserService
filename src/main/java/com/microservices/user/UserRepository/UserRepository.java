package com.microservices.user.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.user.UserEntity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	
}
