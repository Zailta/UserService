package com.microservices.user.Userutility;

public class UserApiResponse {

	public String message;
	public Boolean responseFlag;
	
	public UserApiResponse(String message, Boolean responseFlag) {
		super();
		this.message = message;
		this.responseFlag = responseFlag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getResponseFlag() {
		return responseFlag;
	}

	public void setResponseFlag(Boolean responseFlag) {
		this.responseFlag = responseFlag;
	}
}
