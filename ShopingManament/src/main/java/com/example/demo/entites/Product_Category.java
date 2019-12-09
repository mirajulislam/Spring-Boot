package com.example.demo.entites;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "product_Category")
public class Product_Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int     cat_id;
	private String  cat_name;
	private String  cat_des;
	private String  cat_type;
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

	public String getCat_type() {
		return cat_type;
	}

	public void setCat_type(String cat_type) {
		this.cat_type = cat_type;
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



	public Product_Category(String cat_name, String cat_des, String cat_type, Date cat_pro_insert_date,
			Date cat_pro_update_date, Date cat_pro_deleteDate, boolean cat_pro_active) {

		this.cat_name = cat_name;
		this.cat_des = cat_des;
		this.cat_type = cat_type;
		this.cat_pro_insert_date = cat_pro_insert_date;
		this.cat_pro_update_date = cat_pro_update_date;
		this.cat_pro_deleteDate = cat_pro_deleteDate;
		this.cat_pro_active = cat_pro_active;
	
	}
	
	

}
