package com.shreejit.OnlineShoppingWebappBackend.dao;

import java.util.List;

import com.shreejit.OnlineShoppingWebappBackend.dto.Category;

public interface CategoryDAO {
	
	//For adding a new category
	boolean add(Category category);
	
	List<Category> list();
	
	//for displaying individual category
	
	Category get(int id);
}
