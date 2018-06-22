package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_detail database table.
 * 
 */
@Entity
@Table(name="order_detail")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int amount;

	@Column(name="total_price")
	private int totalPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne(fetch=FetchType.LAZY)
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	public OrderDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}