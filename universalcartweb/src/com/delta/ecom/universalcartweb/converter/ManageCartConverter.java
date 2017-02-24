package com.delta.ecom.universalcartweb.converter;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;
import com.delta.ecom.universalcartweb.dataobject.CarDO;
import com.delta.ecom.universalcartweb.dataobject.CartDO;
import com.delta.ecom.universalcartweb.dataobject.FlightDO;
import com.delta.ecom.universalcartweb.dataobject.HotelDO;
import com.delta.ecom.universalcartweb.service.ServiceClientHelper.Product;
import com.delta.ecom.universalcartweb.service.ServiceClientHelper.Products;

public class ManageCartConverter {

	private final static DeltaLogger LOGGER = new DeltaLogger(
			ManageCartConverter.class.getName());
	private static final boolean loggerEnabled = LOGGER
			.isEnabledFor(Level.DEBUG);

	/**
	 * Convert List of Products to List of Cart Items
	 * 
	 * @param products
	 * @return List<CartDO>
	 */
	public static CartDO convertProductsToCart(Products products) {
		if (loggerEnabled) {
			LOGGER.debug("convertProductsToCart called");
		}

		CartDO cartDO = new CartDO();

		if (null != products && !products.products.isEmpty()) {

			for (Product product : products.products) {

				// Hotel
				if (product.type.equalsIgnoreCase("hotel")) {
					HotelDO hotelDO = new HotelDO();
					hotelDO.id = String.valueOf(product.id);
					hotelDO.hotelName = "Gordon Ramsay's BBQ";
					cartDO.getHotels().add(hotelDO);
				}
				// Car
				if (product.type.equalsIgnoreCase("car")) {
					CarDO carDO = new CarDO();
					carDO.id = String.valueOf(product.id);
					carDO.carName = "Alexa";
					cartDO.getCars().add(carDO);
				}
				// Flight
				if (product.type.equalsIgnoreCase("flight")) {
					FlightDO flightDO = new FlightDO();
					flightDO.id = String.valueOf(product.id);
					flightDO.flightNum = "1234";
					cartDO.getFlights().add(flightDO);
				}

			}
		}

		if (loggerEnabled) {
			LOGGER.debug("convertProductsToCart completed");
		}
		return cartDO;
	}
}
