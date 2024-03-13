package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dao.Dao;
import com.product.model.ProductModel;
import com.product.service.Service;

@RestController
@RequestMapping("/api/products")
public class Controller {
@Autowired
	Service service;
	
	public ResponseEntity<List<ProductModel>> getAllProducts(){
		List<ProductModel> product=service.getAllproducts();
		return new ResponseEntity<>( product,HttpStatus.OK);
	}

	@GetMapping("/{productid}")
public ResponseEntity<ProductModel> getProducts(@PathVariable Long productid){
		ProductModel product=service.getProduct(productid);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<ProductModel> update(@RequestBody ProductModel product){
		ProductModel products=service.createProduct(product);
		return new ResponseEntity<>(products,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/{productId}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable int productId, @RequestBody ProductModel product) {
		ProductModel updatedProduct = service.updateProduct(productId, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
    	service.deleteByid(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
