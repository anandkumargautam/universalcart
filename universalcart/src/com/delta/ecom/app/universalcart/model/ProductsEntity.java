package com.delta.ecom.app.universalcart.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;

	@Column(name = "type", nullable = false)
	private int type;

	@Column(name = "data", nullable = false)
	private String data;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "entrytimestamp", nullable = false)
	private Timestamp entryTimestamp;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEntryTimestamp(Timestamp entryTimestamp) {
		this.entryTimestamp = entryTimestamp;
	}

	public Timestamp getEntryTimestamp() {
		return entryTimestamp;
	}

}
