package com.delta.ecom.universalcartweb.action;

import java.lang.reflect.Type;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;
import com.delta.commons.util.ObjectUtil;
import com.delta.commons.util.StringUtils;
import com.delta.ecom.universalcartweb.constant.UniversalCartConstants;
import com.delta.ecom.universalcartweb.dataobject.CartDO;
import com.delta.ecom.universalcartweb.dataobject.ErrorDO;
import com.delta.ecom.universalcartweb.dataobject.PassengerDO;
import com.delta.ecom.universalcartweb.exception.ManageCartDelegateException;
import com.delta.ecom.universalcartweb.workflow.ManageCartWorkflow;
import com.google.gson.reflect.TypeToken;

public class ManageCartJSONAction extends BaseAction {

	private static final long serialVersionUID = 1491514741624543372L;
	private final static DeltaLogger LOGGER = new DeltaLogger(
			ManageCartJSONAction.class.getName());
	private static final boolean loggerEnabled = LOGGER
			.isEnabledFor(Level.DEBUG);

	private PassengerDO passenger;
	private String passengerData;
	private CartDO cart;

	public String getAllItems() {
		if (loggerEnabled) {
			LOGGER.debug("ManageCartJSONAction called");
		}

		// Validate Passenger's email
		if (null != passengerData && StringUtils.isNotEmpty(passengerData)) {

			try {

				// Convert String to Data Object
				Type collectionType = new TypeToken<PassengerDO>() {
				}.getType();
				passenger = (PassengerDO) ObjectUtil.deSerializeObjFromJSON(
						getPassengerData(), collectionType);

				if (null != passenger && null != passenger.emailId
						&& StringUtils.isNotEmpty(passenger.emailId)) {
					// Get Cart Items
					setCart(ManageCartWorkflow.getAllProducts(passenger));

				} else {
					LOGGER.error("Unable to cast json string to object");
				}

			} catch (ManageCartDelegateException e) {
				LOGGER.error(e.getMessage());
				error = new ErrorDO(UniversalCartConstants.ERROR_DATABASE_ERROR);
			}

		} else {
			error = new ErrorDO(UniversalCartConstants.ERROR_INVALID_REQUEST);
			LOGGER.error("Invalid Request");
		}
		if (loggerEnabled) {
			LOGGER.debug("ManageCartJSONAction completed");
		}
		return SUCCESS;
	}

	public void setCart(CartDO cart) {
		this.cart = cart;
	}

	public CartDO getCart() {
		return cart;
	}

	public void setPassenger(PassengerDO passenger) {
		this.passenger = passenger;
	}

	public PassengerDO getPassenger() {
		return passenger;
	}

	public void setPassengerData(String passengerData) {
		this.passengerData = passengerData;
	}

	public String getPassengerData() {
		return passengerData;
	}
}
