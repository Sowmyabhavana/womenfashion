package com.niit.womenfashionBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component

public class Category {
	
	@Id
	private String catId;
	private String catName;
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	@OneToMany(mappedBy="category")
	private List<Products> products;
		
	
	
	
	public Category() {
		this.catId = "Category"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
}
