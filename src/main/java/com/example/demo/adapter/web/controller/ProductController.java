package com.example.demo.adapter.web.controller;

import com.example.demo.adapter.web.annotation.AdminApiV1;
import com.example.demo.domain.dto.request.ProductRequest;
import com.example.demo.domain.dto.response.ProductResponse;
import com.example.demo.service.ProductService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@AdminApiV1
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

	ProductService productService;

	@PostMapping("/products/add")
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
		return new ResponseEntity<>(productService.addNewProduct(productRequest), HttpStatus.OK);
	}

	@GetMapping("/products/list")
	public ResponseEntity<List<ProductResponse>> getProducts() {
		return new ResponseEntity<>(productService.getProductList(), HttpStatus.OK);
	}
}
