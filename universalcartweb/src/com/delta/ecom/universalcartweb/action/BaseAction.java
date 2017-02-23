package com.delta.ecom.universalcartweb.action;

import com.delta.ecom.universalcartweb.dataobject.ErrorDO;
import com.delta.ecom.universalcartweb.dataobject.MessageDO;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = -4043777854730661147L;

	protected ErrorDO error;
	protected MessageDO message;
	
}
