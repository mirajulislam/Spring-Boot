package com.example.demo.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.example.demo.entites.Product;
import com.example.demo.entites.Product_Category;
import com.example.demo.service.Categories_Services;
import com.example.demo.service.ProductServic;

@Controller
@RequestMapping("")
public class IndexController {
	@Autowired
	private ProductServic productServic;
	@Autowired 
	private Categories_Services categories_Services;
	
	

	@RequestMapping(value = { "/viewProductInsertPage" }, method = RequestMethod.GET)
	public ModelAndView viewProductInsertPage(Model mod) {
		return productServic.viewInsertProductPage(mod);
	}
	
	@RequestMapping(value = { "/viewCategoriesInsertPage" }, method = RequestMethod.GET)
	public ModelAndView viewCategoriesInsertPage() {
		return categories_Services.viewInsertCategoriesPage();
	}

	@RequestMapping(value = { "/saveProduct" }, method = RequestMethod.POST)
	public ModelAndView saveProduct(Product product,@RequestParam("cat_id") int cat_id) {

		return productServic.saveProduct(product,cat_id);
	}
	
	@RequestMapping(value = { "/saveproduct_Category" }, method = RequestMethod.POST)
	public ModelAndView saveproduct_Category(Product_Category product_Category) {

		return categories_Services.saveproduct_Category(product_Category);
	}
	
	

}
