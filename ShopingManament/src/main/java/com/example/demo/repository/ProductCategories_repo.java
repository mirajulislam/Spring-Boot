package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.Product_Category;
@Repository("productCategories_repo")
public interface ProductCategories_repo extends JpaRepository<Product_Category,Integer> {

}
