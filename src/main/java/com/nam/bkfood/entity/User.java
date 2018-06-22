package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String avatar;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String name;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	private String username;

	//bi-directional many-to-one association to CommentProduct
	@OneToMany(mappedBy="user")
	private List<CommentProduct> commentProducts;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="user")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
	private Role role;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<CommentProduct> getCommentProducts() {
		return this.commentProducts;
	}

	public void setCommentProducts(List<CommentProduct> commentProducts) {
		this.commentProducts = commentProducts;
	}

	public CommentProduct addCommentProduct(CommentProduct commentProduct) {
		getCommentProducts().add(commentProduct);
		commentProduct.setUser(this);

		return commentProduct;
	}

	public CommentProduct removeCommentProduct(CommentProduct commentProduct) {
		getCommentProducts().remove(commentProduct);
		commentProduct.setUser(null);

		return commentProduct;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setUser(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setUser(null);

		return feedback;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}