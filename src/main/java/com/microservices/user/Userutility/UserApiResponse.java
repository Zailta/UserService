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
}
