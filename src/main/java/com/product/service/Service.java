package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.product.dao.Dao;
import com.product.model.ProductModel;
@org.springframework.stereotype.Service
public class Service {

	@Autowired
	Dao daorepo;
	
	public List<ProductModel> getAllproducts(){
		return daorepo.findAll();
	}
	
	public ProductModel getProduct(Long prodid) {
		return daorepo.findById(null).orElse(null);
	}

	public ProductModel createProduct(ProductModel productModel) {
		return daorepo.save(productModel);
	}
	
	public void deleteByid(int id) {
		daorepo.deleteById(id);
	}
	
	public ProductModel updateProduct(int id,ProductModel product) {
		if(daorepo.existsById(id)) {
		 product.setId(id);
		 daorepo.save(product);
		}
		return null;
		
	}
}
