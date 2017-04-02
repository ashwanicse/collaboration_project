package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;

public interface BlogDAO {



	public List<Blog> list();

	
	public Blog get(int id);


	public boolean update(Blog blog);
	public boolean save(Blog blog);

	
	



}
