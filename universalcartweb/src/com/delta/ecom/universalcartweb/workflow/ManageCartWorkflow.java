package com.delta.ecom.universalcartweb.workflow;

import java.util.List;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;
import com.delta.ecom.universalcartweb.converter.ManageCartConverter;
import com.delta.ecom.universalcartweb.dataobject.CartDO;
import com.delta.ecom.universalcartweb.dataobject.PassengerDO;
import com.delta.ecom.universalcartweb.delegate.ManageCartDelegate;
import com.delta.ecom.universalcartweb.dto.ProductsDTO;
import com.delta.ecom.universalcartweb.exception.ManageCartDelegateException;

public class ManageCartWorkflow {

	private final static DeltaLogger LOGGER = new DeltaLogger(
			ManageCartWorkflow.class.getName());
	private static final boolean loggerEnabled = LOGGER
			.isEnabledFor(Level.DEBUG);

	/**
	 * Retrieves Cart Items and formats to required format
	 * 
	 * @param passenger
	 * @return CartDO
	 * @throws ManageCartDelegateException
	 */
	public static CartDO getAllProducts(PassengerDO passenger)
			throws ManageCartDelegateException {
		if (loggerEnabled) {
			LOGGER.debug("getAllProducts called");
		}

		List<ProductsDTO> products = new ManageCartDelegate()
				.getAllProductsFromCart(passenger);

		if (loggerEnabled) {
			LOGGER.debug("getAllProducts completed");
		}

		// Convert to required format
		return ManageCartConverter.convertProductsToCart(products);
	}
}
