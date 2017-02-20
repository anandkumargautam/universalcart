package com.delta.ecom.app.universalcart.test;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.delta.ecom.app.universalcart.dto.ProductTypeDTO;
import com.delta.ecom.app.universalcart.exceptions.UniversalCartException;
import com.delta.ecom.app.universalcart.hibernate.HibernateUtil;
import com.delta.ecom.app.universalcart.model.ProductTypeModel;

public class ProductTypeModelTest {

	private ProductTypeModel model;

	@Before
	public void init() {
		model = new ProductTypeModel();
	}

	@Test
	public void testSave() throws UniversalCartException {

		final String name = "flight";

		// Sample ProductType
		ProductTypeDTO dto = new ProductTypeDTO();
		dto.name = name;

		// Add to DB
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		model.save(session, dto);
		tx.commit();

		// Retrieve
		List<ProductTypeDTO> productTypes = model.retrieve(session, name);

		// Assert
		Assert.assertTrue(productTypes.size() > 0);
	}
	
	@Test
	public void testTime(){
		System.out.println(new Timestamp(System.currentTimeMillis()));
	}
}
