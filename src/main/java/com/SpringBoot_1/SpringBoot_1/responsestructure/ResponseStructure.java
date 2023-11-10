package com.SpringBoot_1.SpringBoot_1.responsestructure;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseStructure <T> {
	
	int statusCode ;
	
	String message ;
	
	T data ;

}
