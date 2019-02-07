package com.shreejit.OnlineShoppingWebappBackend.dao;

import java.util.List;

import com.shreejit.OnlineShoppingWebappBackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	//for displaying individual category
	
	Category get(int id);
}
