package com.delta.ecom.universalcartweb.util;

import com.delta.commons.properties.LocalProperties;

public class PropertiesUtil {

	public final static String APPNAME = "universalcart";
	public final static String APP_ERRORMAP = "errorcode";
	static {
		LocalProperties.load(APPNAME, "universalcart.properties");
		LocalProperties.load(APP_ERRORMAP, "errorcode.properties");
	}

	public static String get(String key) {
		return LocalProperties.get(APPNAME, key);
	}

	public static String getError(String key) {
		return LocalProperties.get(APP_ERRORMAP, key);
	}
}
