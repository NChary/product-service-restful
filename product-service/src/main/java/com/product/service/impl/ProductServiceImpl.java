package com.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.product.controller.ProductController;
import com.product.entity.ProductEntity;
import com.product.exceptions.ProductNotFoundException;
import com.product.model.ApiResponse;
import com.product.model.Product;
import com.product.repo.ProductRepository;
import com.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@CacheConfig(cacheNames = {"products"})
public class ProductServiceImpl implements ProductService{

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	CacheManager cacheManager;
	
	@Override
	public String saveProductDetails(Product product) {
		
		log.info("Product Service class = received request");
		
		// Convert model into Entity
		ProductEntity productEntity = new ProductEntity(product.getPid(), product.getPname(), product.getSerialNumber(), 
				product.getPrice());
		
		productRepository.save(productEntity); // Entity class
		evictAllCaches();
		return "Record saved successfully";
	}

	public void evictAllCaches() {
	    cacheManager.getCacheNames().stream()
	      .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
	}
	
	@Cacheable(value = "getAllProducts")
	@Override
	public List<ProductEntity> fetchAllRecords() {
		return productRepository.findAll();
	}
	
	/*@CacheEvict(key="#getAllProducts")
	public void evictCache() {
		//remove cache
	}*/
	
	@CachePut(cacheNames = "getAllProducts")
	public void updateCache() {
		
	}
	
	

	@Override
	public String updateProduct(Product product) {
		
		ProductEntity productEntity = new ProductEntity(product.getPid(), product.getPname(), product.getSerialNumber(), 
				product.getPrice());
		
		productEntity.setId(product.getId());
		
		ProductEntity pentity = productRepository.save(productEntity); // Entity class
		
		return "Updated product details successfully";
	
	}

	@Override
	public String deleteProduct(Integer pid) {
		productRepository.deleteById(pid);
		return "Product deleted successfully";
	}

	@Override
	public ApiResponse findByProductName(String name) {
		ApiResponse apiResponse = null;
		Optional<ProductEntity> pOptional = productRepository.findByPname(name);
		if(pOptional.isPresent()) {
			apiResponse = new ApiResponse();
			apiResponse.setStatusCode("000");
			apiResponse.setStatusMessage("SUCCESS");
			apiResponse.setResult(pOptional.get());
			return apiResponse;
		}else {
			throw new ProductNotFoundException("Product Not found");
		}
	}

}
