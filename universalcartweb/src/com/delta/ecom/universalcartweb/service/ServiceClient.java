package com.delta.ecom.universalcartweb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBException;

import org.apache.commons.collections.map.HashedMap;

import com.delta.commons.util.ObjectUtil;
import com.delta.ecom.universalcartweb.constant.UniversalCartConstants;
import com.delta.ecom.universalcartweb.dataobject.PassengerDO;
import com.delta.ecom.universalcartweb.dataobject.ProductDO;
import com.delta.ecom.universalcartweb.dto.ProductTypeDTO;
import com.delta.ecom.universalcartweb.dto.ProductTypes;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class ServiceClient {

	static String serverUrl;
	static HttpURLConnection connection;

	static {

		serverUrl = "http://10.245.231.50:8080";

	}

	@SuppressWarnings("unchecked")
	public static Map<Integer, String> getProductTypes() throws IOException,
			JAXBException {
		URL url = null;
		HttpURLConnection connection = null;
		Map<Integer, String> typeMap = new HashedMap();
		try {
			url = new URL(serverUrl + "/producttypes");
			connection = (HttpURLConnection) url.openConnection();
			if (null != connection) {
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Accept", "application/json");

				InputStream xml = connection.getInputStream();

				BufferedReader streamReader = new BufferedReader(
						new InputStreamReader(xml, "UTF-8"));
				StringBuilder responseStrBuilder = new StringBuilder();

				String inputStr;
				while ((inputStr = streamReader.readLine()) != null) {
					responseStrBuilder.append(inputStr);
				}

				Type collectionType = new TypeToken<ProductTypes>() {
				}.getType();
				ProductTypes prdTypes = (ProductTypes) ObjectUtil
						.deSerializeObjFromJSON(responseStrBuilder.toString(),
								collectionType);

				for (ProductTypeDTO productTypeDTO : prdTypes.types) {
					if (null != productTypeDTO) {
						typeMap.put(productTypeDTO.id, productTypeDTO.name);
					}
				}
			}
		} finally {
			if (null != connection)
				connection.disconnect();
		}
		return typeMap;
	}

	/**
	 * Add Product
	 * 
	 * @param passenger
	 * @param product
	 * @throws IOException
	 * @throws JAXBException
	 */
	public static void addProduct(PassengerDO passenger, ProductDO product)
			throws IOException, JAXBException {
		URL url = null;
		HttpURLConnection connection = null;
		try {

			if (null != product && null != product.type && null != product.data) {
				if (product.type
						.equalsIgnoreCase(UniversalCartConstants.FLIGHT)) {
					url = new URL(serverUrl + "/flight/add");
				} else if (product.type
						.equalsIgnoreCase(UniversalCartConstants.HOTEL)) {
					url = new URL(serverUrl + "/hotel/add");
				} else if (product.type
						.equalsIgnoreCase(UniversalCartConstants.CAR)) {
					url = new URL(serverUrl + "/car/add");
				}
			}
			connection = (HttpURLConnection) url.openConnection();
			if (null != connection) {
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type",
						"application/json; charset=UTF-8");
				connection.setDoOutput(true);
				connection.setDoInput(true);

				JsonObject obj = new JsonObject();
				obj.addProperty("email", passenger.emailId);
				obj.addProperty("type", String.valueOf(getType(product.type)));
				obj.addProperty("data", product.data);

				OutputStream os = connection.getOutputStream();
				os.write(obj.toString().getBytes("UTF-8"));
				os.close();

				InputStream xml = connection.getInputStream();

				BufferedReader streamReader = new BufferedReader(
						new InputStreamReader(xml, "UTF-8"));
				StringBuilder responseStrBuilder = new StringBuilder();

				String inputStr;
				while ((inputStr = streamReader.readLine()) != null) {
					responseStrBuilder.append(inputStr);
				}

			}
		} finally {
			if (null != connection)
				connection.disconnect();
		}
	}

	/**
	 * Returns type
	 * 
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws JAXBException
	 */
	private static Integer getType(String type) throws IOException,
			JAXBException {
		Map<Integer, String> types = getProductTypes();
		for (Entry<Integer, String> entry : types.entrySet()) {
			if (entry.getValue().equalsIgnoreCase(type)) {
				return entry.getKey();
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException, JAXBException {
		PassengerDO pax = new PassengerDO();
		pax.emailId = "test@gmail.com";

		ProductDO product = new ProductDO();
		product.data = "asdasdasd";
		product.type = "flight";

		addProduct(pax, product);
	}
}
