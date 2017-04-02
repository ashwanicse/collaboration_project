package com.niit.collaboration.model;

import java.io.Serializable;

public class Message implements Serializable{


	private String message;

	private long id;

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public Message(Long id, String message) {
		this.message = message;
		this.id=id;
	}
	
	

}
