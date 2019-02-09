package com.shreejit.OnlineShoppingWebappBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shreejit.OnlineShoppingWebappBackend.dao.CategoryDAO;
import com.shreejit.OnlineShoppingWebappBackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	@Autowired
	public SessionFactory sessionFactory;
	
	
	public static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Mobile Phones");
		category.setDescription("Descc for mobile");
		category.setImageURL("mobile.png");

		categories.add(category);

		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Television");
		category.setDescription("Descc for TV");
		category.setImageURL("tv.png");

		categories.add(category);

		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("Fridge and Refrigirators");
		category.setDescription("Descc for fridge");
		category.setImageURL("fridge.png");

		categories.add(category);

		// adding third category
		category = new Category();
		category.setId(4);
		category.setName("Computers and Laptops");
		category.setDescription("Descc for laptop");
		category.setImageURL("laptop.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub

		// using for loop
		for (Category category : categories) {
			if (category.getId() == id)
				return category;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		
		try {
			//add a category to the database table
				sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	

}
