package com.shreejit.OnlineShoppingWebappBackend.dao;

import java.util.List;

import com.shreejit.OnlineShoppingWebappBackend.dto.Category;

public interface CategoryDAO {

	// for displaying individual category
	Category get(int id);

	// for list of category
	List<Category> list();

	/*
	 * CRUD Operations
	 */

	// For adding a new category
	boolean add(Category category);

	// For updating the existing category
	boolean update(Category category);

	// For deleting the existing category
	boolean delete(Category category);
}
