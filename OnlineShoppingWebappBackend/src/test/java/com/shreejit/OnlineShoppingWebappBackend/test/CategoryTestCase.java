package com.shreejit.OnlineShoppingWebappBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shreejit.OnlineShoppingWebappBackend.dao.CategoryDAO;
import com.shreejit.OnlineShoppingWebappBackend.dto.Category;

public class CategoryTestCase {

	/*
	 * Add variable, so we can have application-context and using it we will be able
	 * to access the bean
	 */
	private static AnnotationConfigApplicationContext context;

	// To use the add,list,etc methods variable categoryDAO is declared
	// How we have annotated the @Repository
	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.bshreejit.OnlineShoppingWebappBackend");
		context.refresh();

		// fetching the CategoryDAO, since it also returns an object, we need to
		// type-cast it
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}

	
	@Test
	public void testAddCategory() {
		category = new Category();

		category.setName("Mobile Phones");
		category.setDescription("Descc for mobile");
		category.setImageURL("mobile.png");
		assertEquals("successfully added category inside the table", true, categoryDAO.add(category));
	}

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(1);
	 * assertEquals("successfully fetched category from the table", "Laptop",
	 * category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(1);
	 * category.setName("LP");
	 * assertEquals("successfully updated  a single category in the table", true,
	 * categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(1);
	 * assertEquals("successfully deleted  a single category in the table", false,
	 * categoryDAO.delete(category)); }
	 */
	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("successfully fetched the list of categories in the table", 3,
	 * categoryDAO.list().size()); }
	 */

	/*@Test
	public void testCRUDCategory() {
		category= new Category();
		//Adding the data in the category table
		category.setName("Mobile Phones");
		category.setDescription("Descc for mobile");
		category.setImageURL("mobile.png");
		assertEquals("successfully added category inside the table", true, categoryDAO.add(category));
		
		category.setName("Television");
		category.setDescription("Descc for TV");
		category.setImageURL("tv.png");
		assertEquals("successfully added category inside the table", true, categoryDAO.add(category));
		
		//Fetching and Updating the category
		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("successfully updated  a single category in the table", true, categoryDAO.update(category));
		
		//delete the category
		category = categoryDAO.get(2);
		assertEquals("successfully deleted  a single category in the table", false,categoryDAO.delete(category));
		
		//fetching the list of active category
		assertEquals("successfully fetched the list of categories in the table", 1, categoryDAO.list().size());
	}*/

}
