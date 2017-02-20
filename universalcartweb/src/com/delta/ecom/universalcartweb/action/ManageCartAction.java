package com.delta.ecom.universalcartweb.action;

import org.apache.log4j.Level;
import org.hibernate.Session;

import com.delta.commons.util.DeltaLogger;
import com.delta.commons.util.StringUtils;
import com.delta.ecom.app.universalcart.hibernate.HibernateUtil;
import com.delta.ecom.app.universalcart.model.ProductsModel;
import com.delta.ecom.universalcartweb.constant.UniversalCartConstants;
import com.delta.ecom.universalcartweb.dataobject.ErrorDO;
import com.delta.ecom.universalcartweb.dataobject.PassengerDO;

public class ManageCartAction extends BaseAction {

	private static final long serialVersionUID = -1824795751927205714L;
	private final static DeltaLogger LOGGER = new DeltaLogger(
			ManageCartAction.class.getName());
	private static final boolean loggerEnabled = LOGGER
			.isEnabledFor(Level.DEBUG);

	private PassengerDO passenger;

	public String execute() {
		String returnVal;
		if (loggerEnabled) {
			LOGGER.debug("ManageCartAction called");
		}
		// Validate Passenger's email
		if (null != passenger && null != passenger.emailId
				&& StringUtils.isNotEmpty(passenger.emailId)) {
			returnVal = SUCCESS;
		} else {
			error = new ErrorDO(UniversalCartConstants.ERROR_INVALID_REQUEST);
			LOGGER.error("Invalid Request");
			returnVal = ERROR;
		}
		if (loggerEnabled) {
			LOGGER.debug("ManageCartAction completed with return value : "
					+ returnVal);
		}
		return returnVal;
	}

	public void setPassenger(PassengerDO passenger) {
		this.passenger = passenger;
	}

	public PassengerDO getPassenger() {
		return passenger;
	}
}
