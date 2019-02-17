package com.shreejit.OnlineShoppingWebappBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shreejit.OnlineShoppingWebappBackend.dao.CategoryDAO;
import com.shreejit.OnlineShoppingWebappBackend.dto.Category;



@Repository(value = "categoryDAO")
/*@Transactional*/
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	public SessionFactory sessionFactory;

	/*
	 * Static List
	 */
	/*
	  public static List<Category> categories = new ArrayList<>(); 
	  static {
		  Category category = new Category();
		  
		  // adding first category category.setId(1);
		  category.setName("Mobile Phones");
		  category.setDescription("Description for mobile");
		  category.setImageURL("mobile.png");
		  
		  categories.add(category);
		  
		  // adding second category category = new Category(); category.setId(2);
		  category.setName("Television");
		  category.setDescription("Description for TV");
		  category.setImageURL("tv.png");
		  
		  categories.add(category);
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
	 */
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}



	
	// Adding a category
	@Transactional
		@Override
		public boolean add(Category category) {
			// TODO Auto-generated method stub
	
			try {
				// add a category to the database table
				sessionFactory.getCurrentSession().persist(category);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
	
	// Function for getting a single category based on id
		@Override
		public Category get(int id) {

			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		}

	// Updating a single Category
		@Override
		public boolean update(Category category) {
			// TODO Auto-generated method stub
			try {
	
				// update a category to the database table
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
	
		}

	// Deleting a category
		@Override
		public boolean delete(Category category) {
	
			category.setActive(false);
			try {
				// delete a category to the database table
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}

}
