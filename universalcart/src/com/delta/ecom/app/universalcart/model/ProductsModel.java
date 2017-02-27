package com.delta.ecom.app.universalcart.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.delta.ecom.app.universalcart.dto.ProductsDTO;

public class ProductsModel extends GenericModel<ProductsEntity, ProductsDTO> {

	@Override
	public ProductsDTO toDTO(ProductsEntity entity) {
		ProductsDTO dto = new ProductsDTO();
		dto.data = entity.getData();
		dto.id = entity.getId();
		dto.type = entity.getType();
		dto.skymileNumber = entity.getSkymileNumber();
		dto.entryTimestamp = entity.getEntryTimestamp();
		return dto;
	}

	@Override
	public ProductsEntity toEntity(ProductsDTO dto) {
		ProductsEntity entity = new ProductsEntity();
		entity.setData(dto.data);
		entity.setId(dto.id);
		entity.setType(dto.type);
		entity.setSkymileNumber(dto.skymileNumber);
		entity.setEntryTimestamp(dto.entryTimestamp);
		return entity;
	}

	public void save(Session session, ProductsDTO dto) {
		_save(session, dto);
	}

	/**
	 * Select all items using skymile number
	 * 
	 * @param session
	 * @param skymiles
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductsDTO> getBySkymileNumber(Session session, String skymileNumber) {
		String query = "SELECT * FROM products WHERE skymilenumber = :skymileNumber";

		List<ProductsEntity> row = session.createSQLQuery(query).addEntity(
				ProductsEntity.class).setParameter("skymileNumber",
				skymileNumber).list();

		List<ProductsDTO> productsDTOList = new ArrayList<ProductsDTO>();
		if (null != row && !row.isEmpty()) {
			for (ProductsEntity entity : row) {
				if (null != entity) {
					productsDTOList.add(toDTO(entity));
				}
			}
		}
		return productsDTOList;
	}

}
