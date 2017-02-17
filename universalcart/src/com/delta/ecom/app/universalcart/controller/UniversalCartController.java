package com.delta.ecom.app.universalcart.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.Car;
import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.Flight;
import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.Hotel;
import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.ProductType;
import com.delta.ecom.app.universalcart.dto.ProductTypeDTO;
import com.delta.ecom.app.universalcart.dto.ProductsDTO;
import com.delta.ecom.app.universalcart.exceptions.UniversalCartException;
import com.delta.ecom.app.universalcart.hibernate.HibernateUtil;
import com.delta.ecom.app.universalcart.model.ProductTypeModel;
import com.delta.ecom.app.universalcart.model.ProductsModel;

@RestController
public class UniversalCartController {
	private static Logger log = LogManager
			.getLogger(UniversalCartController.class);

	/**
	 * Rest call to add product type
	 * 
	 * @param productType
	 * @return
	 */
	@RequestMapping(value = "/producttypes/addproducttype", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> addProductType(
			@RequestBody ProductType productType) {
		log.debug("/producttypes/addproducttype called");

		if (null != productType && null != productType.name) {
			Session session = null;
			Transaction tx = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();

				// Construct DTO
				ProductTypeDTO dto = new ProductTypeDTO();
				dto.name = productType.name;

				tx = session.beginTransaction();
				new ProductTypeModel().save(session, dto);
				tx.commit();

				return new ResponseEntity<String>("Product Type: "
						+ productType.name + " inserted successfully",
						HttpStatus.OK);
			} catch (HibernateException hbe) {
				log.error(hbe.getMessage());

				if (null != tx)
					tx.rollback();

			} catch (UniversalCartException e) {
				log.error(e.getMessage());

				if (null != tx)
					tx.rollback();

				return new ResponseEntity<String>(
						"Product Type already exists!!", HttpStatus.BAD_REQUEST);
			} finally {
				if (null != session)
					session.close();
			}
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Rest call to retrieve all product types
	 * 
	 * @return List<ProductTypeDTO>
	 */
	@RequestMapping(value = "/producttypes", method = RequestMethod.GET)
	public List<ProductTypeDTO> list() {
		log.debug("/producttypes called");

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			List<ProductTypeDTO> productTypes = new ProductTypeModel()
					.retrieveAll(session);
			return productTypes;
		} catch (HibernateException hbe) {
			log.error(hbe.getMessage());

			if (null != tx)
				tx.rollback();

		} finally {
			if (null != session)
				session.close();
		}
		return null;
	}

	/**
	 * Rest call to add flight to cart
	 * 
	 * @param flight
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "/flight/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> addFlight(@RequestBody Flight flight) {
		log.debug("/flight/add called");

		if (null != flight && null != flight.shopInputDO) {
			Session session = null;
			Transaction tx = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();

				// Construct DTO
				ProductsDTO productDTO = new ProductsDTO();
				productDTO.data = flight.shopInputDO;
				productDTO.email = flight.email;
				productDTO.type = flight.type;

				tx = session.beginTransaction();
				new ProductsModel().save(session, productDTO);
				tx.commit();

				return new ResponseEntity<String>(
						"Product Type: Flight inserted successfully",
						HttpStatus.OK);
			} catch (HibernateException hbe) {
				log.error(hbe.getMessage());

				if (null != tx)
					tx.rollback();

			} finally {
				if (null != session)
					session.close();
			}
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Rest call to add car to cart
	 * 
	 * @param flight
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "/car/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> addCar(@RequestBody Car car) {
		log.debug("/car/add called");

		if (null != car && null != car.carDO) {
			Session session = null;
			Transaction tx = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();

				// Construct DTO
				ProductsDTO productDTO = new ProductsDTO();
				productDTO.data = car.carDO;
				productDTO.email = car.email;
				productDTO.type = car.type;

				tx = session.beginTransaction();
				new ProductsModel().save(session, productDTO);
				tx.commit();

				return new ResponseEntity<String>(
						"Product Type: Car inserted successfully",
						HttpStatus.OK);
			} catch (HibernateException hbe) {
				log.error(hbe.getMessage());

				if (null != tx)
					tx.rollback();

			} finally {
				if (null != session)
					session.close();
			}
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Rest call to add hotel to cart
	 * 
	 * @param flight
	 * @return ResponseEntity<String>
	 */
	@RequestMapping(value = "/hotel/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> addHotel(@RequestBody Hotel hotel) {
		log.debug("/car/add called");

		if (null != hotel && null != hotel.hotelDO) {
			Session session = null;
			Transaction tx = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();

				// Construct DTO
				ProductsDTO productDTO = new ProductsDTO();
				productDTO.data = hotel.hotelDO;
				productDTO.email = hotel.email;
				productDTO.type = hotel.type;

				tx = session.beginTransaction();
				new ProductsModel().save(session, productDTO);
				tx.commit();

				return new ResponseEntity<String>(
						"Product Type: Hotel inserted successfully",
						HttpStatus.OK);
			} catch (HibernateException hbe) {
				log.error(hbe.getMessage());

				if (null != tx)
					tx.rollback();

			} finally {
				if (null != session)
					session.close();
			}
		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
	
}
