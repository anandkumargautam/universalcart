package com.delta.ecom.app.universalcart.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.Car;
import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.Flight;
import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.Hotel;
import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.Product;
import com.delta.ecom.app.universalcart.controller.helper.UniversalCartControllerHelper.ProductType;
import com.delta.ecom.app.universalcart.dto.ProductTypeDTO;
import com.delta.ecom.app.universalcart.dto.ProductTypes;
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
	public ProductTypes list() {
		log.debug("/producttypes called");

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			List<ProductTypeDTO> productTypes = new ProductTypeModel()
					.retrieveAll(session);

			ProductTypes types = new ProductTypes();
			types.types = productTypes;
			return types;
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

				// Check if product type exists
				ProductTypeModel productTypeModel = new ProductTypeModel();
				boolean productTypeExists = productTypeModel.checkExists(
						session, flight.type);

				if (productTypeExists) {
					// Construct DTO
					ProductsDTO productDTO = new ProductsDTO();
					productDTO.data = flight.shopInputDO;
					productDTO.email = flight.email;
					productDTO.type = flight.type;
					productDTO.entryTimestamp = new Timestamp(System
							.currentTimeMillis());

					tx = session.beginTransaction();
					new ProductsModel().save(session, productDTO);
					tx.commit();

					return new ResponseEntity<String>(
							"Product Type: Flight inserted successfully",
							HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(
							"Product Type doesnot exist",
							HttpStatus.BAD_REQUEST);
				}
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
				// Check if product type exists
				ProductTypeModel productTypeModel = new ProductTypeModel();
				boolean productTypeExists = productTypeModel.checkExists(
						session, car.type);

				if (productTypeExists) {
					// Construct DTO
					ProductsDTO productDTO = new ProductsDTO();
					productDTO.data = car.carDO;
					productDTO.email = car.email;
					productDTO.type = car.type;
					productDTO.entryTimestamp = new Timestamp(System
							.currentTimeMillis());

					tx = session.beginTransaction();
					new ProductsModel().save(session, productDTO);
					tx.commit();

					return new ResponseEntity<String>(
							"Product Type: Car inserted successfully",
							HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(
							"Product Type doesnot exist",
							HttpStatus.BAD_REQUEST);
				}
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
		log.debug("/hotel/add called");

		if (null != hotel && null != hotel.hotelDO) {
			Session session = null;
			Transaction tx = null;
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				// Check if product type exists
				ProductTypeModel productTypeModel = new ProductTypeModel();
				boolean productTypeExists = productTypeModel.checkExists(
						session, hotel.type);

				if (productTypeExists) {
					// Construct DTO
					ProductsDTO productDTO = new ProductsDTO();
					productDTO.data = hotel.hotelDO;
					productDTO.email = hotel.email;
					productDTO.type = hotel.type;
					productDTO.entryTimestamp = new Timestamp(System
							.currentTimeMillis());

					tx = session.beginTransaction();
					new ProductsModel().save(session, productDTO);
					tx.commit();

					return new ResponseEntity<String>(
							"Product Type: Hotel inserted successfully",
							HttpStatus.OK);
				} else {
					return new ResponseEntity<String>(
							"Product Type doesnot exist",
							HttpStatus.BAD_REQUEST);
				}
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
	 * Rest call to retrieve all products using email id
	 * 
	 * @return List<Product>
	 */
	@SuppressWarnings("unchecked")
	@CrossOrigin
	@RequestMapping(value = "/viewcart", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Product> viewCart(@RequestParam("email") String email) {
		log.debug("/viewcart called");

		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			// Fetch All Products
			List<ProductsDTO> productsDTOList = new ProductsModel().getByEmail(
					session, email);

			// Fetch and create map of product types
			Map<Integer, String> productTypeMap = new HashedMap();
			List<ProductTypeDTO> productTypes = new ProductTypeModel()
					.retrieveAll(session);
			for (ProductTypeDTO productType : productTypes) {
				if (null != productType) {
					productTypeMap.put(productType.id, productType.name);
				}
			}

			List<Product> products = new ArrayList<Product>();
			for (ProductsDTO productsDTO : productsDTOList) {
				Product product = new Product();
				product.type = productTypeMap.get(productsDTO.type);
				product.data = productsDTO.data;
				products.add(product);
			}
			return products;
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

}
