package com.delta.ecom.universalcartweb.dataobject;

import java.util.List;

public class CartDO {
	// Flights
	public List<FlightDO> flights;
	public PriceDO totalFlightPrice;

	// Hotels
	public List<HotelDO> hotels;
	public PriceDO totalHotelPrice;

	// Cars
	public List<CarDO> cars;
	public PriceDO totalCarPrice;

	// Total Cart Value
	public PriceDO totalCartValue;
}
