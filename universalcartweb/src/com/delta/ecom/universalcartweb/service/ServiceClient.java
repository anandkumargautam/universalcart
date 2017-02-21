package com.delta.ecom.universalcartweb.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.collections.map.HashedMap;

import com.delta.commons.util.ObjectUtil;
import com.delta.ecom.universalcartweb.dto.ProductTypeDTO;
import com.delta.ecom.universalcartweb.dto.ProductTypes;
import com.google.gson.reflect.TypeToken;

public class ServiceClient {

	static URL url;
	static HttpURLConnection connection;

	static {
		try {
			url = new URL("http://10.245.231.50:8080/producttypes");
			connection = (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<Integer, String> getProductTypes() throws IOException,
			JAXBException {
		HttpURLConnection connection = null;
		Map<Integer, String> typeMap = new HashedMap();
		try {
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
}
