package com.delta.ecom.universalcartweb.action;

import java.io.IOException;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;
import com.delta.commons.util.StringUtils;
import com.delta.ecom.universalcartweb.dataobject.CartDO;
import com.delta.ecom.universalcartweb.service.ServiceClient;
import com.opensymphony.xwork2.ActionContext;

public class ManageCartJSONAction extends BaseAction {

	private static final long serialVersionUID = 1491514741624543372L;
	private final static DeltaLogger LOGGER = new DeltaLogger(
			ManageCartJSONAction.class.getName());
	private static final boolean loggerEnabled = LOGGER
			.isEnabledFor(Level.DEBUG);

	private CartDO cart;

	public String getAllItems() {
		if (loggerEnabled) {
			LOGGER.debug("ManageCartJSONAction called");
		}
		String skymileNumber = null;
		// Validate Passenger's skymile
		try {

			// Convert String to Data Object
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			if (session.containsKey("skymileNumber")) {
				skymileNumber = (String) session.get("skymileNumber");
			}

			if (null != skymileNumber && StringUtils.isNotEmpty(skymileNumber)) {
				// Get Cart Items
				setCart(ServiceClient.getAllProductsFrmCart(skymileNumber));

			} else {
				LOGGER.error("Unable to cast json string to object");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
}
