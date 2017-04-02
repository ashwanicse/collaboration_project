package com.niit.collaboration.model;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="c_blog")
@Component
public class Blog extends BaseDomain implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3617429842445047326L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	@Column(name="userId")	
	private String userID;
	
	@Column(name="dateTime")	
	private Date dateTime;
	
	private char status;
	private String reason;
	private Clob description;

	
	
	public Blog(Long id, String title, String userID, Date dateTime, char status, String reason, Clob description) {
		super();
		this.id = id;
		this.title = title;
		this.userID = userID;
		this.dateTime = dateTime;
		this.status = status;
		this.reason = reason;
		this.description = description;
	}
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char c) {
		this.status = c;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Clob getDescription() {
		return description;
	}
	public void setDescription(Clob description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", userID=" + userID + ", dateTime=" + dateTime + ", status="
				+ status + ", reason=" + reason + ", description=" + description + "]";
	}
	
	

}
