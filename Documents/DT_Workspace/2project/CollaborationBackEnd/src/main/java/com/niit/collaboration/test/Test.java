package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.collaboration.config.ApplicationContextConfig;
import com.niit.collaboration.dao.UserDAO;

public class Test {
	public static void main( String[] args ){
	    AbstractApplicationContext context=new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
	    UserDAO userDao=(UserDAO)context.getBean("userDAO");
	    System.out.println("success ...............................");
	
	}
}
