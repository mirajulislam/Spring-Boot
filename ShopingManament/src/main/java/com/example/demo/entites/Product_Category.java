package com.example.demo.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "create_category_table")
public class Product_Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int     cat_id;
	private String  cat_name;
	private String  cat_des;
	private Date    cat_create_date;
    private Date    cat_pro_insert_date;
    private Date    cat_pro_update_date;
    private Date    cat_pro_deleteDate;
	private boolean cat_pro_active;
	
	public Product_Category() {
		
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getCat_des() {
		return cat_des;
	}

	public void setCat_des(String cat_des) {
		this.cat_des = cat_des;
	}



	public Date getCat_create_date() {
		return cat_create_date;
	}



	public void setCat_create_date(Date cat_create_date) {
		this.cat_create_date = cat_create_date;
	}



	public Date getCat_pro_insert_date() {
		return cat_pro_insert_date;
	}



	public void setCat_pro_insert_date(Date cat_pro_insert_date) {
		this.cat_pro_insert_date = cat_pro_insert_date;
	}



	public Date getCat_pro_update_date() {
		return cat_pro_update_date;
	}



	public void setCat_pro_update_date(Date cat_pro_update_date) {
		this.cat_pro_update_date = cat_pro_update_date;
	}



	public Date getCat_pro_deleteDate() {
		return cat_pro_deleteDate;
	}



	public void setCat_pro_deleteDate(Date cat_pro_deleteDate) {
		this.cat_pro_deleteDate = cat_pro_deleteDate;
	}



	public boolean isCat_pro_active() {
		return cat_pro_active;
	}



	public void setCat_pro_active(boolean cat_pro_active) {
		this.cat_pro_active = cat_pro_active;
	}



	public Product_Category(int cat_id, String cat_name, String cat_des, Date cat_create_date, Date cat_pro_insert_date,
			Date cat_pro_update_date, Date cat_pro_deleteDate, boolean cat_pro_active) {

		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.cat_des = cat_des;
		this.cat_create_date = cat_create_date;
		this.cat_pro_insert_date = cat_pro_insert_date;
		this.cat_pro_update_date = cat_pro_update_date;
		this.cat_pro_deleteDate = cat_pro_deleteDate;
		this.cat_pro_active = cat_pro_active;
	}


}
