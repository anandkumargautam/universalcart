package com.delta.ecom.universalcartweb.action;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;
import com.delta.commons.util.StringUtils;
import com.delta.ecom.universalcartweb.constant.UniversalCartConstants;
import com.delta.ecom.universalcartweb.dataobject.ErrorDO;
import com.delta.ecom.universalcartweb.dataobject.MessageDO;
import com.delta.ecom.universalcartweb.dataobject.PassengerDO;
import com.delta.ecom.universalcartweb.dataobject.ProductDO;
import com.delta.ecom.universalcartweb.service.ServiceClient;

public class ManageCartAction extends BaseAction {

	private static final long serialVersionUID = -1824795751927205714L;
	private final static DeltaLogger LOGGER = new DeltaLogger(
			ManageCartAction.class.getName());
	private static final boolean loggerEnabled = LOGGER
			.isEnabledFor(Level.DEBUG);

	private PassengerDO passenger;
	private ProductDO product;

	public String addToCart() {
		String returnVal;
		if (loggerEnabled) {
			LOGGER.debug("ManageCartAction.addToCart called");
		}
		// Validate Passenger's email
		if (null != passenger && null != passenger.emailId
				&& StringUtils.isNotEmpty(passenger.emailId) && null != product) {

			// Add product to cart using service call
			try {
				ServiceClient.addProduct(passenger, product);
				message = new MessageDO("Product Added Successfully.");
			} catch (IOException e) {
				message = new MessageDO("Product not added due to some error!");
				LOGGER.error("Product failed to add due to " + e.getMessage());
			} catch (JAXBException e) {
				message = new MessageDO("Product not added due to some error!");
				LOGGER.error("Product failed to add due to " + e.getMessage());
			}

			returnVal = SUCCESS;
		} else {
			error = new ErrorDO(UniversalCartConstants.ERROR_INVALID_REQUEST);
			LOGGER.error("Invalid Request");
			returnVal = ERROR;
		}
		if (loggerEnabled) {
			LOGGER
					.debug("ManageCartAction.addToCart completed with return value : "
							+ returnVal);
		}
		return returnVal;
	}

	public String manageCart() {
		if (loggerEnabled) {
			LOGGER.debug("ManageCartAction.manageCart called");
		}

		return SUCCESS;
	}

	public void setPassenger(PassengerDO passenger) {
		this.passenger = passenger;
	}

	public PassengerDO getPassenger() {
		return passenger;
	}

	public void setProduct(ProductDO product) {
		this.product = product;
	}

	public ProductDO getProduct() {
		return product;
	}

	public MessageDO getMessage() {
		return message;
	}

	public void setMessage(MessageDO message) {
		this.message = message;
	}
}
