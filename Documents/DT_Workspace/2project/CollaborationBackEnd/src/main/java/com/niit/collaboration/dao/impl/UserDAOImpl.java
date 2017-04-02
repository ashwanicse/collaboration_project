package com.niit.collaboration.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

/**
* @author Ashwani
*
*/

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	/*
	 *  @Section - 1 : SessionFactory and Session creation and initialization
	 */
	@Autowired
    private SessionFactory sessionFactory;
	
	public UserDAOImpl() {
		super();
	}
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
    private Session getSession(){		
		return sessionFactory.getCurrentSession();
	}

    /*
	 * @Section - 1 : Completed
	 */
    
    
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(String id) {
		return (User)getSession().get(User.class, id);
	}

	@Override
	public boolean save(User user) {   	
		try{
			   getSession().save(user);
			   return true;
			}
			catch(Exception e){
				e.printStackTrace();
			   return false;
			}
	}

	@Override
	public boolean update(User user) {
		try{
			   getSession().update(user);
			   return true;
			}
			catch(Exception e){
				e.printStackTrace();
			   return false;
			}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User authenticate(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOnline(String userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOffLine(String userID) {
		// TODO Auto-generated method stub
		
	}

	

}
