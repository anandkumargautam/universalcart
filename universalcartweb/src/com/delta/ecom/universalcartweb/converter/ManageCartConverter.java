package com.delta.ecom.universalcartweb.converter;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;
import com.delta.commons.util.jaxb.JaxBWrapper;
import com.delta.ecom.data.flight.ShopInputDO;
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
					hotelDO.setId(String.valueOf(product.id));
					hotelDO.setHotelName("Gordon Ramsay's BBQ");
					cartDO.getHotels().add(hotelDO);
				}
				// Car
				if (product.type.equalsIgnoreCase("car")) {
					CarDO carDO = new CarDO();
					carDO.setId(String.valueOf(product.id));
					carDO.setCarName("Alexa");
					cartDO.getCars().add(carDO);
				}
				// Flight
				if (product.type.equalsIgnoreCase("flight")) {
					FlightDO flightDO = new FlightDO();
					flightDO.setId(String.valueOf(product.id));

					flightDO.setFlightNum("1234");
					flightDO.setShopInputDO(getShopInputDO(product.data));
					cartDO.getFlights().add(flightDO);
				}

			}
		}

		if (loggerEnabled) {
			LOGGER.debug("convertProductsToCart completed");
		}
		return cartDO;
	}

	private static ShopInputDO getShopInputDO(String data) {
		ShopInputDO shopInputDO = new ShopInputDO();
		JaxBWrapper wrapper = new JaxBWrapper(ShopInputDO.class);
		try {
			shopInputDO = wrapper.unmarshallXML(data);
		} catch (JAXBException e) {
			e.printStackTrace();
			LOGGER.error("Unable to unmarshal ShopInputDO");
		}
		return shopInputDO;
	}
}
