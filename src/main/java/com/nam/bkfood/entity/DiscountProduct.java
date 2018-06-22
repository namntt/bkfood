package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the discount_product database table.
 * 
 */
@Entity
@Table(name="discount_product")
@NamedQuery(name="DiscountProduct.findAll", query="SELECT d FROM DiscountProduct d")
public class DiscountProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="code_discount")
	private String codeDiscount;

	@Column(name="number_discount")
	private int numberDiscount;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	public DiscountProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodeDiscount() {
		return this.codeDiscount;
	}

	public void setCodeDiscount(String codeDiscount) {
		this.codeDiscount = codeDiscount;
	}

	public int getNumberDiscount() {
		return this.numberDiscount;
	}

	public void setNumberDiscount(int numberDiscount) {
		this.numberDiscount = numberDiscount;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}