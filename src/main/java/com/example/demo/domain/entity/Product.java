package com.example.demo.domain.entity;

import com.example.demo.adapter.repository.base.BaseDomainEntity;
import com.example.demo.domain.entity.context.ProductContext;
import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class Product extends BaseDomainEntity<Long> {
	@NonNull
	BigDecimal price;
	@NonNull
	Data data;

	public static Product createProductFrom(ProductContext context) {
		return new Product(
				context.getPrice(),
				context.getData());
	}
}
