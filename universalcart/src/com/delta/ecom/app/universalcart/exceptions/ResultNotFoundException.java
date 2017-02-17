package com.delta.ecom.app.universalcart.exceptions;

public class ResultNotFoundException extends DBException {

	private static final long serialVersionUID = -2337901898605364742L;

	private String message;

	public ResultNotFoundException(String message, Throwable cause) {
		super(message, cause);
		this.setMessage(message);
	}

	public ResultNotFoundException(String message) {
		super(message);
		this.setMessage(message);
	}

	public ResultNotFoundException(Throwable cause) {
		super(cause);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
