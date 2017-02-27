package com.delta.ecom.universalcartweb.dataobject;

import com.delta.ecom.data.flight.ShopInputDO;

public class FlightDO {
	private String id;
	private String flightNum;
	
	private ShopInputDO shopInputDO;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlightNum() {
		return flightNum;
	}
	public void setFlightNum(String flightNum) {
		this.flightNum = flightNum;
	}
	public void setShopInputDO(ShopInputDO shopInputDO) {
		this.shopInputDO = shopInputDO;
	}
	public ShopInputDO getShopInputDO() {
		return shopInputDO;
	}
	
	
}
