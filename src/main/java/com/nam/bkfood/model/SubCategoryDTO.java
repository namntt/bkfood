package com.nam.bkfood.model;

public class SubCategoryDTO {
	private Long id;

	private String name;
	
	private Long category_id;
	
	public SubCategoryDTO(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCategoryId() {
		return category_id;
	}

	public void setCategoryId(Long category_id) {
		this.category_id = category_id;
	}
	
	
}
