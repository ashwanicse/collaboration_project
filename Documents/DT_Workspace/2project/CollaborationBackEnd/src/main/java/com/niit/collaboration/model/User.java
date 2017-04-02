package com.niit.collaboration.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="c_user_detail")
@Component
public class User extends BaseDomain implements Serializable{
	
	@Id
	private String id;
	
	private String name;
	
	private String email;
	
	private String mobile;

	//roll:Employee role:Admin
	private String role;
	
	private String password;
	
	@Column(name="is_online")
	private char isOnline;
	
	private char status;
	
	private String reason;
	
	@Column(name="LAST_SEEN_TIME")
	private Date lastSeenTime;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String email, String mobile, String role, String password, char isOnline,
			char status, String reason, Date lastSeenTime) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.role = role;
		this.password = password;
		this.isOnline = isOnline;
		this.status = status;
		this.reason = reason;
		this.lastSeenTime = lastSeenTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getLastSeenTime() {
		return lastSeenTime;
	}

	public void setLastSeenTime(Date lastSeenTime) {
		this.lastSeenTime = lastSeenTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", role=" + role
				+ ", password=" + password + ", isOnline=" + isOnline + ", status=" + status + ", reason=" + reason
				+ ", lastSeenTime=" + lastSeenTime + "]";
	}
	
	
}
