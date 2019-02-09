package com.shreejit.OnlineShoppingWebappBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shreejit.OnlineShoppingWebappBackend.dao.CategoryDAO;
import com.shreejit.OnlineShoppingWebappBackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	// How we have annotated the @Repository
	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.bshreejit.OnlineShoppingWebappBackend");
		context.refresh();

		// fetching the CategoryDAO
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		//since it returns an object, we need to type-cast it
		
	}

	@Test
	public void testAddCategory() {
		category= new Category();
		
		category.setName("Mobile Phones");
		category.setDescription("Descc for mobile");
		category.setImageURL("mobile.png");

		assertEquals("successfully added category inside the table", true,categoryDAO.add(category) );
	}
}
