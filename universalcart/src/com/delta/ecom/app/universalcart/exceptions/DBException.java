package com.delta.ecom.app.universalcart.exceptions;

import org.hibernate.HibernateException;

public class DBException extends HibernateException {

	private static final long serialVersionUID = 9069953727001483408L;
	private String message;

	public DBException(String message, Throwable cause) {
		super(message, cause);
		this.setMessage(message);
	}

	public DBException(String message) {
		super(message);
		this.setMessage(message);
	}

	public DBException(Throwable cause) {
		super(cause);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
