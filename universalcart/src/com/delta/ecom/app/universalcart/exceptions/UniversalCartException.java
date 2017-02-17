package com.delta.ecom.app.universalcart.exceptions;

public class UniversalCartException extends Exception  {

	private static final long serialVersionUID = 4009764588981951233L;
	private String message;

	public UniversalCartException(String message, Throwable cause) {
		super(message, cause);
		this.setMessage(message);
	}

	public UniversalCartException(String message) {
		super(message);
		this.setMessage(message);
	}

	public UniversalCartException(Throwable cause) {
		super(cause);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
