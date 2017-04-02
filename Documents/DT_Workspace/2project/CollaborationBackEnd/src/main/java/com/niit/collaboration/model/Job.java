package com.niit.collaboration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="c_job")
@Component
public class Job extends BaseDomain implements Serializable{

	public void setStatus(char c) {
		// TODO Auto-generated method stub
		
	}

}
