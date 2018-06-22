package com.nam.bkfood.model;

public class SearchSubCategoryDTO extends SearchDTO{
	private Long categoryId;

	private String name;
	
	public SearchSubCategoryDTO(){
		super();
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long id) {
		this.categoryId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
