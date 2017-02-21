package com.delta.ecom.universalcartweb.converter;

import java.util.List;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;
import com.delta.ecom.universalcartweb.dataobject.CarDO;
import com.delta.ecom.universalcartweb.dataobject.CartDO;
import com.delta.ecom.universalcartweb.dataobject.FlightDO;
import com.delta.ecom.universalcartweb.dataobject.HotelDO;
import com.delta.ecom.universalcartweb.dto.ProductsDTO;

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
	public static CartDO convertProductsToCart(List<ProductsDTO> products) {
		if (loggerEnabled) {
			LOGGER.debug("convertProductsToCart called");
		}

		CartDO cartDO = new CartDO();

		if (null != products && !products.isEmpty()) {

			for (ProductsDTO product : products) {

				// Hotel
				if (product.type == 8) {
					HotelDO hotelDO = new HotelDO();
					hotelDO.id = String.valueOf(product.id);
					hotelDO.hotelName = "Gordon Ramsay's BBQ";
					cartDO.hotels.add(hotelDO);
				}
				// Car
				if (product.type == 7) {
					CarDO carDO = new CarDO();
					carDO.id = String.valueOf(product.id);
					carDO.carName = "Alexa";
					cartDO.cars.add(carDO);
				}
				// Flight
				if (product.type == 6) {
					FlightDO flightDO = new FlightDO();
					flightDO.id = String.valueOf(product.id);
					flightDO.flightNum = "1234";
					cartDO.flights.add(flightDO);
				}

			}
		}

		if (loggerEnabled) {
			LOGGER.debug("convertProductsToCart completed");
		}
		return cartDO;
	}
}
