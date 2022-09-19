package com.crewmeister.cmcodingchallenge.currency.dto;

public class ErrorWsDTO {

	private String errorCode;
	private String reason;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
