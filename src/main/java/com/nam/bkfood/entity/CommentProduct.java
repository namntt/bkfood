package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comment_product database table.
 * 
 */
@Entity
@Table(name="comment_product")
@NamedQuery(name="CommentProduct.findAll", query="SELECT c FROM CommentProduct c")
public class CommentProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="comment_date")
	private Date commentDate;

	@Column(name="content_comment")
	private String contentComment;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	private Product product;

	public CommentProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getContentComment() {
		return this.contentComment;
	}

	public void setContentComment(String contentComment) {
		this.contentComment = contentComment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}