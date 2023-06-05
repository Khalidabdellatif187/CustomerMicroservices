package com.luv2code.CustomerMicroservice.CustomExceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resourcenotfoundexception {
	
	private String resourceName;
    private String fieldName;
    private long fieldValue;
    
	public Resourcenotfoundexception(String resourceName, String fieldName, long fieldValue) {
		super();
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	
	public long getFieldValue() {
		return fieldValue;
	}
	public Resourcenotfoundexception(String resourceName, String fieldName) {
		super();
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}

}
