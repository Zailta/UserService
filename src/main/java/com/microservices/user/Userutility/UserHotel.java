package com.microservices.user.Userutility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserHotel {

	private String hotelId;
	private String hotelName;
	private String location;
	private String about;

}
