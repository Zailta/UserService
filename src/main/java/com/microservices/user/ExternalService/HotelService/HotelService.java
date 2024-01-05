package com.microservices.user.ExternalService.HotelService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.user.Userutility.UserHotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping(value = "/hotelService/microservice/hotel/{hotelId}")
	UserHotel getUserHotel(@PathVariable String hotelId);
}
