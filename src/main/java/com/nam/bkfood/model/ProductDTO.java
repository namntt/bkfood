package com.nam.bkfood.model;

public class ProductDTO {
	private Long id;

	private String description;

	private String image;

	private String name;

	private int price;
	
	private Long typeId;
	
	
	public ProductDTO(){
		
	}
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	
	
	
	
}
