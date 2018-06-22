package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String image;

	private String name;

	private int price;

	//bi-directional many-to-one association to CommentProduct
	@OneToMany(mappedBy="product")
	private List<CommentProduct> commentProducts;

	//bi-directional many-to-one association to DiscountProduct
	@OneToMany(mappedBy="product")
	private List<DiscountProduct> discountProducts;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;

	//bi-directional many-to-one association to SubProductType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="type_id")
	private SubCategory subProductType;

	public Product() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<CommentProduct> getCommentProducts() {
		return this.commentProducts;
	}

	public void setCommentProducts(List<CommentProduct> commentProducts) {
		this.commentProducts = commentProducts;
	}

	public CommentProduct addCommentProduct(CommentProduct commentProduct) {
		getCommentProducts().add(commentProduct);
		commentProduct.setProduct(this);

		return commentProduct;
	}

	public CommentProduct removeCommentProduct(CommentProduct commentProduct) {
		getCommentProducts().remove(commentProduct);
		commentProduct.setProduct(null);

		return commentProduct;
	}

	public List<DiscountProduct> getDiscountProducts() {
		return this.discountProducts;
	}

	public void setDiscountProducts(List<DiscountProduct> discountProducts) {
		this.discountProducts = discountProducts;
	}

	public DiscountProduct addDiscountProduct(DiscountProduct discountProduct) {
		getDiscountProducts().add(discountProduct);
		discountProduct.setProduct(this);

		return discountProduct;
	}

	public DiscountProduct removeDiscountProduct(DiscountProduct discountProduct) {
		getDiscountProducts().remove(discountProduct);
		discountProduct.setProduct(null);

		return discountProduct;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProduct(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProduct(null);

		return orderDetail;
	}

	public SubCategory getSubProductType() {
		return this.subProductType;
	}

	public void setSubProductType(SubCategory subProductType) {
		this.subProductType = subProductType;
	}

}