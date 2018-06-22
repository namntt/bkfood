package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the shipping database table.
 * 
 */
@Entity
@Table(name="shipping")
@NamedQuery(name="Shipping.findAll", query="SELECT s FROM Shipping s")
public class Shipping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="address_ship")
	private String addressShip;

	@Column(name="long_street")
	private int longStreet;

	@Column(name="ship_price")
	private int shipPrice;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="shipping")
	private List<Order> orders;

	public Shipping() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressShip() {
		return this.addressShip;
	}

	public void setAddressShip(String addressShip) {
		this.addressShip = addressShip;
	}

	public int getLongStreet() {
		return this.longStreet;
	}

	public void setLongStreet(int longStreet) {
		this.longStreet = longStreet;
	}

	public int getShipPrice() {
		return this.shipPrice;
	}

	public void setShipPrice(int shipPrice) {
		this.shipPrice = shipPrice;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setShipping(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setShipping(null);

		return order;
	}

}