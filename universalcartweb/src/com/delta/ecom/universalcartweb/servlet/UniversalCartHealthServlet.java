package com.delta.ecom.universalcartweb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;

public class UniversalCartHealthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final DeltaLogger LOGGER = new DeltaLogger(
			UniversalCartHealthServlet.class.getName());
	private static final boolean loggerEnabled = LOGGER
			.isEnabledFor(Level.DEBUG);

	public UniversalCartHealthServlet() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		if (loggerEnabled) {
			LOGGER.debug("UniversalCartHealthServlet called");
		}
		// boolean universalCartServerStatus = false;
		// try{
		// universalCartServerStatus = ServiceClient.checkServerStatus();
		// }catch(IOException ioe){
		// LOGGER.error("Exception while checking for Server status");
		// }
	}

	public void destroy() {

	}
}
