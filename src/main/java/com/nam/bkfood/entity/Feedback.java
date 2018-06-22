package com.nam.bkfood.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@Table(name="feedback")
@NamedQuery(name="Feedback.findAll", query="SELECT f FROM Feedback f")
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="content_feedback")
	private String contentFeedback;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="feedback_date")
	private Date feedbackDate;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_kh")
	private User user;

	public Feedback() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContentFeedback() {
		return this.contentFeedback;
	}

	public void setContentFeedback(String contentFeedback) {
		this.contentFeedback = contentFeedback;
	}

	public Date getFeedbackDate() {
		return this.feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}