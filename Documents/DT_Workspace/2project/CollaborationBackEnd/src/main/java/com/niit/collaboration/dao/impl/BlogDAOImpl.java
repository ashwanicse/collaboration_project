package com.niit.collaboration.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

/**
 * @author Ashwani
 *
 */
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Override
	public List<Blog> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blog get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	public BlogDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	
	private Session getSession(){
		
		return sessionFactory.getCurrentSession();
	}
		
    
	@Override
	public Blog getBlog(long id) {
		// TODO Auto-generated method stub
		return (Blog)getSession().get(Blog.class, id);
	}

	@Override
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return (List<Blog>)getSession().createQuery("from blog where status='A'").list();
	}

	@Override
	public List<Blog> getMyAllBlogs(String userId) {
		// TODO Auto-generated method stub
		return (List<Blog>)getSession().createQuery("from blog where userId="+userId).list();
	}

	@Override
	public boolean save(Blog blog) {
		// TODO Auto-generated method stub
		try{
		   getSession().save(blog);
		   return true;
		}
		catch(Exception e){
			e.printStackTrace();
		   return false;
		}
	}

	@Override
	public boolean update(Blog blog) {
		// TODO Auto-generated method stub
		try{
			   getSession().update(blog);
			   return true;
			}
			catch(Exception e){
				e.printStackTrace();
			   return false;
			}
	}
	
	
	
	

}
