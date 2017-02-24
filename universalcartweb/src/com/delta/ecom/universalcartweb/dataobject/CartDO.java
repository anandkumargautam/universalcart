package com.delta.ecom.universalcartweb.dataobject;

import java.util.ArrayList;
import java.util.List;

public class CartDO {
	
	// Flights
	private List<FlightDO> flights = new ArrayList<FlightDO>();
	private PriceDO totalFlightPrice;

	// Hotels
	private List<HotelDO> hotels = new ArrayList<HotelDO>();
	private PriceDO totalHotelPrice;

	// Cars
	private List<CarDO> cars = new ArrayList<CarDO>();
	private PriceDO totalCarPrice;

	// Total Cart Value
	private PriceDO totalCartValue;

	public List<FlightDO> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightDO> flights) {
		this.flights = flights;
	}

	public PriceDO getTotalFlightPrice() {
		return totalFlightPrice;
	}

	public void setTotalFlightPrice(PriceDO totalFlightPrice) {
		this.totalFlightPrice = totalFlightPrice;
	}

	public List<HotelDO> getHotels() {
		return hotels;
	}

	public void setHotels(List<HotelDO> hotels) {
		this.hotels = hotels;
	}

	public PriceDO getTotalHotelPrice() {
		return totalHotelPrice;
	}

	public void setTotalHotelPrice(PriceDO totalHotelPrice) {
		this.totalHotelPrice = totalHotelPrice;
	}

	public List<CarDO> getCars() {
		return cars;
	}

	public void setCars(List<CarDO> cars) {
		this.cars = cars;
	}

	public PriceDO getTotalCarPrice() {
		return totalCarPrice;
	}

	public void setTotalCarPrice(PriceDO totalCarPrice) {
		this.totalCarPrice = totalCarPrice;
	}

	public PriceDO getTotalCartValue() {
		return totalCartValue;
	}

	public void setTotalCartValue(PriceDO totalCartValue) {
		this.totalCartValue = totalCartValue;
	}
	
	
}
