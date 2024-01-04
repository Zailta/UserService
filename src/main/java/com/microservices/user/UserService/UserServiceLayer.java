package com.microservices.user.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.user.Exception.CustomExceptions.EXNResourceNotFoundException;
import com.microservices.user.UserEntity.UserEntity;
import com.microservices.user.UserRepository.UserRepository;
import com.microservices.user.UserService.UserServiceInterface.UserService;
import com.microservices.user.Userutility.UserHotel;
import com.microservices.user.Userutility.UserRatings;


@Service
public class UserServiceLayer implements UserService{
	@Autowired
	UserRepository repository;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public UserEntity createUser(UserEntity bean) {
		UserEntity savedUser = repository.save(bean);
		return savedUser;
	}

	@Override
	public UserEntity getSingleUser(String userid) {
		UserEntity userEntity = repository.findById(userid).orElseThrow(()->new EXNResourceNotFoundException("User", "ID", userid));
		UserRatings[] userratings = restTemplate.getForObject("http://RATING-SERVICE/ratingService/microservice/rating/fromuser/"+userid, UserRatings[].class);
		List<UserRatings> userRatinglist = Arrays.stream(userratings).toList();
		List<UserRatings> ratingsObject = userRatinglist.stream().map(rating->{
			UserHotel userHotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotelService/microservice/hotel/"+rating.getHotelId(), UserHotel.class);
			rating.setHotel(userHotel);
			return rating;
		}).collect(Collectors.toList());
		
		userEntity.setRatings(ratingsObject);
		return userEntity;
	}

	@Override
	public List<UserEntity> getAllIUsers() {
		
		List<UserEntity> allUsers = repository.findAll();
		return allUsers;
	}


	
}
