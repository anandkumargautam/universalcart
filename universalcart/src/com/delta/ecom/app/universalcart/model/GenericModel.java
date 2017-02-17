package com.delta.ecom.app.universalcart.model;

import org.hibernate.Session;

public abstract class GenericModel<Entity, DTO> {
	protected abstract Entity toEntity(DTO dto);

	protected abstract DTO toDTO(Entity entity);

	protected void _save(Session session, DTO dto) {
		session.save(toEntity(dto));
	}

	protected void _delete(Session session, DTO dto) {
		session.delete(toEntity(dto));
	}
}
