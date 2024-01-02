package com.microservices.user.Userutility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRatings {

	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
}
