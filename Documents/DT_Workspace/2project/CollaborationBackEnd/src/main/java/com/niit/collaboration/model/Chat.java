package com.niit.collaboration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="c_chat")
@Component
public class Chat extends BaseDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7162975143047411175L;

}
