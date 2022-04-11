package com.training.LicManagerAgentWebService.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class LicManager {

	private int id;

	private String name;
	private List<LicAgent> agentList;

	public List<LicAgent> getAgentList() {
		return agentList;
	}

	public void setAgentList(List<LicAgent> agentList) {
		this.agentList = agentList;
	}

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
