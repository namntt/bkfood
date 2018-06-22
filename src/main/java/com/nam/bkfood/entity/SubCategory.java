package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sub_product_type database table.
 * 
 */
@Entity
@Table(name="sub_product_type")
public class SubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="subProductType")
	private List<Product> products;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	private Category category;
	
	public SubCategory() {
		
	}

	public SubCategory(Long id) {
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

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSubProductType(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSubProductType(null);

		return product;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}