package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProductEntity;
import com.product.exceptions.ProductNotFoundException;
import com.product.model.ApiResponse;
import com.product.model.Product;
import com.product.service.ProductService;
import com.product.util.ProductUtility;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/v1")
public class ProductController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public String saveProduct(@RequestBody Product product) {
		log.info("############################ ProductController :: Received request = "+ProductUtility.convertObjectToJson(product));
		return productService.saveProductDetails(product);
	}

	//Get 
	@GetMapping("/product")
	public List<ProductEntity> getAllProducts(){
		return productService.fetchAllRecords();
	}

	@PutMapping("/product")
	public String updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("/product/{pid}")
	public String deleteProduct(@PathVariable Integer pid) {
		return productService.deleteProduct(pid);
	}

	// find a product
	@GetMapping("/product/{productName}")
	public ResponseEntity<ApiResponse> findByProduct(@PathVariable String productName) {
		ApiResponse apiResponse = productService.findByProductName(productName);
		return new ResponseEntity<>(apiResponse,HttpStatus.OK);
	}

}
