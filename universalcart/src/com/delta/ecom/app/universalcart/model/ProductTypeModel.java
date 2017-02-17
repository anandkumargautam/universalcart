package com.delta.ecom.app.universalcart.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.delta.ecom.app.universalcart.dto.ProductTypeDTO;
import com.delta.ecom.app.universalcart.exceptions.UniversalCartException;

public class ProductTypeModel extends
		GenericModel<ProductTypeEntity, ProductTypeDTO> {

	@Override
	public ProductTypeDTO toDTO(ProductTypeEntity entity) {
		ProductTypeDTO dto = new ProductTypeDTO();
		dto.id = entity.getId();
		dto.name = entity.getName();
		return dto;
	}

	@Override
	public ProductTypeEntity toEntity(ProductTypeDTO dto) {
		ProductTypeEntity entity = new ProductTypeEntity();
		entity.setId(dto.id);
		entity.setName(dto.name);
		return entity;
	}

	/**
	 * Get Product Type using id
	 * 
	 * @param session
	 * @param id
	 * @return ProductTypeDTO
	 */
	public ProductTypeDTO get(Session session, int id) {
		return toDTO((ProductTypeEntity) session.get(ProductTypeEntity.class,
				id));
	}

	/**
	 * Get Product Type exists using name
	 * 
	 * @param session
	 * @param typeName
	 * @return boolean
	 */
	public boolean checkExists(Session session, String typeName) {
		return retrieve(session, typeName).size() > 0 ? true : false;
	}

	/**
	 * Check Product Type exists using id
	 * 
	 * @param session
	 * @param id
	 * @return boolean
	 */
	public boolean checkExists(Session session, int id) {
		return get(session, id) != null ? true : false;
	}

	/**
	 * Save Product Type if not exist else throw error
	 * 
	 * @param session
	 * @param dto
	 * @throws UniversalCartException
	 */
	public void save(Session session, ProductTypeDTO dto)
			throws UniversalCartException {
		List<ProductTypeDTO> productTypes = retrieve(session, dto.name);
		if (productTypes.size() > 0 && !productTypes.isEmpty()) {
			throw new UniversalCartException("Product Type Already present.");
		}
		_save(session, dto);
	}

	/**
	 * Retrieve ProductType details using product name
	 * 
	 * @param session
	 * @param name
	 * @return List<ProductTypeDTO>
	 */
	@SuppressWarnings("unchecked")
	public List<ProductTypeDTO> retrieve(Session session, String name) {
		String query = "SELECT * FROM producttype WHERE name = :name ;";
		List<ProductTypeEntity> row = session.createSQLQuery(query).addEntity(
				ProductTypeEntity.class).setParameter("name", name).list();

		List<ProductTypeDTO> productTypes = new ArrayList<ProductTypeDTO>();
		if (null != row && !row.isEmpty()) {
			for (ProductTypeEntity entity : row) {
				if (null != entity) {
					productTypes.add(toDTO(entity));
				}
			}
		}
		return productTypes;
	}

	/**
	 * Retrieve all ProductTypes
	 * 
	 * @param session
	 * @return List<ProductTypeDTO>
	 */
	@SuppressWarnings("unchecked")
	public List<ProductTypeDTO> retrieveAll(Session session) {
		String query = "SELECT * FROM producttype";
		List<ProductTypeEntity> row = session.createSQLQuery(query).addEntity(
				ProductTypeEntity.class).list();

		List<ProductTypeDTO> productTypes = new ArrayList<ProductTypeDTO>();
		if (null != row && !row.isEmpty()) {
			for (ProductTypeEntity entity : row) {
				if (null != entity) {
					productTypes.add(toDTO(entity));
				}
			}
		}
		return productTypes;
	}

}
