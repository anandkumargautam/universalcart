package com.delta.ecom.universalcartweb.dataobject;

import com.delta.ecom.universalcartweb.util.PropertiesUtil;

public class ErrorDO {
	private String code;
	private String message;

	public ErrorDO(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public ErrorDO(String code) {
		this.code = code;
		this.message = PropertiesUtil.getError(code);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "[" + getCode() + "] " + getMessage();
	}

}
