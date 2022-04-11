package com.training.licmanagerwebservice.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
@Entity
public class LicManager {
	@Id

	private int id;

	private String name;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LicManager(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public LicManager() {
		super();
	}

	@Override
	public String toString() {
		return "LicManager [id=" + id + ", name=" + name + "]";
	}

}