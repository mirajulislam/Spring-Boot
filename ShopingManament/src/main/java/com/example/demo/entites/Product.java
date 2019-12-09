package com.example.demo.entites;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "create_product_table")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int     pro_id;
	private String  pro_name;
	private String  pro_pre_price;
    private String  pro_past_price;
    private String  pro_images;
    private String  pro_total;
    private String  pro_description;
    private Date    pro_insert_date;
    private Date    pro_update_date;
    private Date    pro_deleteDate;
    private boolean pro_active;
    
    @OneToOne(targetEntity = Product_Category.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "cat_id")
    private Product_Category product_Category;

	public Product() {
		
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_pre_price() {
		return pro_pre_price;
	}

	public void setPro_pre_price(String pro_pre_price) {
		this.pro_pre_price = pro_pre_price;
	}

	public String getPro_past_price() {
		return pro_past_price;
	}

	public void setPro_past_price(String pro_past_price) {
		this.pro_past_price = pro_past_price;
	}

	public String getPro_images() {
		return pro_images;
	}

	public void setPro_images(String pro_images) {
		this.pro_images = pro_images;
	}

	public String getPro_total() {
		return pro_total;
	}

	public void setPro_total(String pro_total) {
		this.pro_total = pro_total;
	}

	public String getPro_description() {
		return pro_description;
	}

	public void setPro_description(String pro_description) {
		this.pro_description = pro_description;
	}

	public Date getPro_insert_date() {
		return pro_insert_date;
	}

	public void setPro_insert_date(Date pro_insert_date) {
		this.pro_insert_date = pro_insert_date;
	}

	public Date getPro_update_date() {
		return pro_update_date;
	}

	public void setPro_update_date(Date pro_update_date) {
		this.pro_update_date = pro_update_date;
	}

	public Date getPro_deleteDate() {
		return pro_deleteDate;
	}

	public void setPro_deleteDate(Date pro_deleteDate) {
		this.pro_deleteDate = pro_deleteDate;
	}

	public boolean isPro_active() {
		return pro_active;
	}

	public void setPro_active(boolean pro_active) {
		this.pro_active = pro_active;
	}

	public Product_Category getProduct_Category() {
		return product_Category;
	}

	public void setProduct_Category(Product_Category product_Category) {
		this.product_Category = product_Category;
	}

	public Product(String pro_name, String pro_pre_price, String pro_past_price, String pro_images, String pro_total,
			String pro_description, Date pro_insert_date, Date pro_update_date, Date pro_deleteDate, boolean pro_active,
			Product_Category product_Category) {
		this.pro_name = pro_name;
		this.pro_pre_price = pro_pre_price;
		this.pro_past_price = pro_past_price;
		this.pro_images = pro_images;
		this.pro_total = pro_total;
		this.pro_description = pro_description;
		this.pro_insert_date = pro_insert_date;
		this.pro_update_date = pro_update_date;
		this.pro_deleteDate = pro_deleteDate;
		this.pro_active = pro_active;
		this.product_Category = product_Category;
	}

}
