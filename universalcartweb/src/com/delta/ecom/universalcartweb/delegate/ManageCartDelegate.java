package com.delta.ecom.universalcartweb.delegate;

import java.util.List;

import org.apache.log4j.Level;

import com.delta.commons.util.DeltaLogger;
import com.delta.ecom.universalcartweb.dto.ProductsDTO;
import com.delta.ecom.universalcartweb.exception.ManageCartDelegateException;

public class ManageCartDelegate {
	private final static DeltaLogger LOGGER = new DeltaLogger(
			ManageCartDelegate.class.getName());
	private static final boolean loggerEnabled = LOGGER
			.isEnabledFor(Level.DEBUG);

	/**
	 * Retrieve Products from Database based on passenger details
	 * 
	 * @param passenger
	 * @return List<ProductsDTO>
	 * @throws ManageCartDelegateException
	 */
	public List<ProductsDTO> getAllProductsFromCart(String email)
			throws ManageCartDelegateException {
		if (loggerEnabled) {
			LOGGER.debug("getAllProductsFromCart called");
		}
		/*Session session = null;
		List<ProductsDTO> products = new ArrayList<ProductsDTO>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			products = new ProductsModel().getByEmail(session,
					passenger.emailId);
			LOGGER.info("Total Items retrieved : " + products.size());
		} catch (DBException ex) {
			LOGGER.error("Exception while retrieving data from products", ex);
			throw new ManageCartDelegateException(ex);
		} catch(Exception ex){
			LOGGER.error("Exception while retrieving data from products !", ex);
			throw new ManageCartDelegateException(ex);
		}
		finally {
			if (null != session)
				session.close();
		}
		if (loggerEnabled) {
			LOGGER.debug("getAllProductsFromCart completed");
		}
		return products;*/
		return null;
	}
}
