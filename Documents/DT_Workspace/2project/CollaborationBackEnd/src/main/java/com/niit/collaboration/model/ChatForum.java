package com.niit.collaboration.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="c_forum")
@Component
public class ChatForum extends BaseDomain implements Serializable{

}
