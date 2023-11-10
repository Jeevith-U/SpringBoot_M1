package com.SpringBoot_1.SpringBoot_1.exception;

public class CarNotFoundException extends RuntimeException {
	
	public String getMessage() {
		return "Unable to find the car...!" ;
	}

}
