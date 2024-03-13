package com.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.model.ProductModel;

@Repository
public interface Dao extends JpaRepository<ProductModel, Integer> {

}
