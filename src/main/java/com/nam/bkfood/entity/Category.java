package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String name;

	//bi-directional many-to-one association to SubProductType
	@OneToMany(mappedBy="category")
	private List<SubCategory> subProductTypes;

	public Category() {
	}
	
	public Category(Long id) {
		this.id=id;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubCategory> getSubProductTypes() {
		return this.subProductTypes;
	}

	public void setSubProductTypes(List<SubCategory> subProductTypes) {
		this.subProductTypes = subProductTypes;
	}

	public SubCategory addSubProductType(SubCategory subProductType) {
		getSubProductTypes().add(subProductType);
		subProductType.setCategory(this);

		return subProductType;
	}

	public SubCategory removeSubProductType(SubCategory subProductType) {
		getSubProductTypes().remove(subProductType);
		subProductType.setCategory(null);

		return subProductType;
	}

}