package com.example.demo.factory;

import com.example.demo.domain.dto.request.ProductRequest;
import com.example.demo.domain.dto.response.ProductResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE)
public class ProductFactory {
	public ProductResponse processRequest(ProductRequest request) {
		return new ProductResponse(
			request.getPrice(),
			request.getDescription(),
			request.getProductionDate()
		);
	}
}
