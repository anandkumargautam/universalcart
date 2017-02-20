package com.delta.ecom.universalcartweb.exception;

public class ManageCartDelegateException extends Exception {

	private static final long serialVersionUID = -7214720779641478476L;
	private String message;

	public ManageCartDelegateException(String message, Throwable cause) {
		super(message, cause);
		this.setMessage(message);
	}

	public ManageCartDelegateException(String message) {
		super(message);
		this.setMessage(message);
	}

	public ManageCartDelegateException(Throwable cause) {
		super(cause);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
