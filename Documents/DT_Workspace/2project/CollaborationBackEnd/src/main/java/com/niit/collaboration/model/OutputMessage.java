package com.niit.collaboration.model;

import java.util.Date;

public class OutputMessage extends Message {

    private Date time;
    
    private String userID;
    
    public OutputMessage(Message original, Date time, String userID) {
       super(original.getId(), original.getMessage());
       this.time=time;
       this.userID=userID;
        
    }
    
    
  

	public String getUserID() {
		return userID;
	}




	public void setUserID(String userID) {
		this.userID = userID;
	}




	public Date getTime() {
        return time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }
}
