package com.nam.bkfood.model;

public class SearchProductDTO extends SearchDTO{
	private static final long serialVersionUID = 1L;

	private String name;
	private Long typeId;

	public SearchProductDTO() {

	}

	public SearchProductDTO(Long typeId) {
		super();
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
}
