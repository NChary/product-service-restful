package com.product.service;

import java.util.List;

import com.product.entity.ProductEntity;
import com.product.model.ApiResponse;
import com.product.model.Product;

public interface ProductService {

	public String saveProductDetails(Product product);
	
	public List<ProductEntity> fetchAllRecords();
	
	public String updateProduct(Product product);
	
	public String deleteProduct(Integer pid);
	
	public ApiResponse findByProductName(String name);
}
