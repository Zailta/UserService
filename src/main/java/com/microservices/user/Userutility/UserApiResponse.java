package com.microservices.user.Userutility;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserApiResponse {

	private String message;
	private Boolean responseFlag;
	private HttpStatus status;
	public UserApiResponse(String message, Boolean responseFlag, HttpStatus status) {
		super();
		this.message = message;
		this.responseFlag = responseFlag;
		this.status = status;
	}
	
	
}
