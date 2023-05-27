package com.example.demo.service.implementation;

import com.example.demo.adapter.repository.ProductRepository;
import com.example.demo.domain.dto.request.ProductRequest;
import com.example.demo.domain.dto.response.ProductResponse;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.entity.context.ProductContext;
import com.example.demo.service.ProductService;
import com.example.demo.service.factory.ProductFactory;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductServiceImplementation implements ProductService {
	ProductFactory productFactory;
	ProductRepository productRepository;

	@Override
	public List<ProductResponse> getProductList() {
		return productRepository.findAll().stream()
				.map(productFactory::createProductResponseFrom)
				.collect(Collectors.toList());
	}

	@Override
	public ProductResponse addNewProduct(ProductRequest request) {
		ProductContext context = productFactory.createProductContextFrom(request);
		Product product = Product.createProductFrom(context);
		product = productRepository.save(product);
		return productFactory.createProductResponseFrom(product);
	}
}
