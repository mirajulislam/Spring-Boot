package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.contoller.IndexController;
import com.example.demo.entites.Product;
import com.example.demo.entites.Product_Category;
import com.example.demo.repository.ProductCategories_repo;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServic {
	static org.slf4j.Logger log = LoggerFactory.getLogger(IndexController.class);
	BindingResult bindingResult;
	@Autowired
	private ProductRepository productRepository;
	
	Model mod;

	@Autowired
	private  ProductCategories_repo productCategories_repo;
	
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private boolean active = true;

//	View Product
	public ModelAndView viewInsertProductPage(Model mod) {
		ModelAndView modelAndView = new ModelAndView();
		List<Product_Category>proCatList=productCategories_repo.findAll();
		mod.addAttribute("proCatList", proCatList);
		
		Product product = new Product();
		modelAndView.addObject("product", product);
		modelAndView.setViewName("product/Product");
		return modelAndView;
	}


	
	// save product
	public ModelAndView saveProduct(Product product,int cat_id) {
		Product_Category product_Category=new Product_Category();
		product_Category.setCat_id(cat_id);
		
		product.setPro_insert_date(timestamp);
		product.setPro_active(active);

		product.setProduct_Category(product_Category);
      	productRepository.save(product);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "Product has been added successfully!");
		modelAndView.addObject("product", new Product());
		modelAndView.setViewName("product/Product");

		return modelAndView;
	}
}
