package com.niit.collaboration.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="c_job_applied")
@Component
public class JobApplication extends BaseDomain implements Serializable{

	public void setJobID(Long jobID) {
		// TODO Auto-generated method stub
		
	}

	public void setStatus(char status) {
		// TODO Auto-generated method stub
		
	}

	public void setRemarks(String remarks) {
		// TODO Auto-generated method stub
		
	}

	public void setDateApplied(Date date) {
		// TODO Auto-generated method stub
		
	}

	public String getDateApplied() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserID(String loggedInUserID) {
		// TODO Auto-generated method stub
		
	}

}
