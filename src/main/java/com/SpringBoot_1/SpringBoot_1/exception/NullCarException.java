package com.SpringBoot_1.SpringBoot_1.exception;

public class NullCarException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "Unable to Save Car Because it consist of Null Attribute" ;
	}

}
