package com.niit.collaboration.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="C_FRIEND")
@Component
public class Friend extends BaseDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4040945702424803847L;
	@Id
	private int id;
	@Column(name="user_id")
	private String userID;
	@Column(name="friend_id")
	private String friendID;
	
	//New, accepted, rejected,blocked
	private String status;
	

	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friend(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
		// TODO Auto-generated constructor stub
	}
	@Column(name="is_online")
	private char  isOnline;
	
	@Column(name = "LAST_SEEN_TIME")
	private Date lastSeenTime;
	
	
	public char getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFriendID() {
		return friendID;
	}
	public void setFriendID(String friendID) {
		this.friendID = friendID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", userID=" + userID + ", friendID=" + friendID + ", status=" + status
				+ ", isOnline=" + isOnline + ", lastSeenTime=" + lastSeenTime + "]";
	}
	
}
