package com.delta.ecom.universalcartweb.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {

	private static final long serialVersionUID = 2889787053961043069L;

	// Action properties
	private String message;

	@Override
	public String execute() {
		if (null == message || message.equalsIgnoreCase("error")) {

			return ERROR;
		} else
			return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
