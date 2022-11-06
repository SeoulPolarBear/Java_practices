package com.polarbear.oct071.error;

import java.util.List;

//Error 하나하나를 List의 형태로 내보내기 위해서!
public class Errors {

	private List<Error> errors;
	
	public Errors() {
		// TODO Auto-generated constructor stub
	}

	public Errors(List<Error> errors) {
		super();
		this.errors = errors;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
