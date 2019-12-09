package com.example.demo.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entites.Product_Category;
import com.example.demo.repository.ProductCategories_repo;
@Service
public class Categories_Services {
	

	@Autowired
	private  ProductCategories_repo productCategories_repo;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private boolean active = true;
	
//	View Categories
	public ModelAndView viewInsertCategoriesPage() {
		ModelAndView modelAndView = new ModelAndView();
		Product_Category product_Category = new Product_Category();
		modelAndView.addObject("product_Category", product_Category);
		modelAndView.setViewName("product/Categories");
		return modelAndView;
	}
	
	// save Categories
	public ModelAndView saveproduct_Category(Product_Category product_Category) {

		product_Category.setCat_pro_insert_date(timestamp);
		product_Category.setCat_pro_active(active);
		productCategories_repo.save(product_Category);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "Categories has been added successfully!");
		modelAndView.addObject("product_Category", new Product_Category());
		modelAndView.setViewName("product/Categories");

		return modelAndView;
	}

}
