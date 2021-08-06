package com.example.exception;

import org.springframework.stereotype.Component;

@Component
public class FormatException extends RuntimeException {
	String errCode;
	String errMesg;

	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMesg() {
		return errMesg;
	}
	public void setErrMesg(String errMesg) {
		this.errMesg = errMesg;
	}
	public FormatException(String errorCode, String errorMsg) {
		super();
		this.errCode = errorCode;
		this.errMesg = errorMsg;
	}
	
	public FormatException() {
		
	}
	
	
	
}
