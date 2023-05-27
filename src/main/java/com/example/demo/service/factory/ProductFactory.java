package com.example.demo.service.factory;

import com.example.demo.adapter.repository.DataRepository;
import com.example.demo.domain.dto.request.ProductRequest;
import com.example.demo.domain.dto.response.ProductResponse;
import com.example.demo.domain.entity.Data;
import com.example.demo.domain.entity.Product;
import com.example.demo.domain.entity.context.DataContext;
import com.example.demo.domain.entity.context.ProductContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductFactory {
	DataRepository dataRepository;

	public ProductResponse createProductResponseFrom(Product product) {
		return new ProductResponse(
				product.getId(),
				product.getPrice(),
				createData(product.getData())
		);
	}

	public ProductContext createProductContextFrom(ProductRequest request) {
		Data data = Data.createDataFrom(new DataContext(request.getData().getDate()));
		data = dataRepository.save(data);
		return new ProductContext(
				request.getPrice(),
				data
		);
	}

	private ProductResponse.Data createData(Data data) {
		return new ProductResponse.Data(
				data.getId(),
				data.getDate()
		);
	}
}
