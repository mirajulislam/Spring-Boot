package com.example.demo.service;

import java.sql.Timestamp;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.contoller.IndexController;
import com.example.demo.entites.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServic {
	static org.slf4j.Logger log = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private ProductRepository productRepository;

	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private boolean active = true;

//	View Product
	public ModelAndView viewInsertProductPage() {
		ModelAndView modelAndView = new ModelAndView();
		Product product = new Product();
		modelAndView.addObject("product", product);
		modelAndView.setViewName("product/Product");
		return modelAndView;
	}

	public void saveProduct(Product product) {
		product.setPro_insert_date(timestamp);
		product.setPro_active(active);

		productRepository.save(product);
	}
}
