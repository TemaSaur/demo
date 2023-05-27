package com.example.demo.adapter.repository;

import com.example.demo.adapter.repository.base.BaseRepository;
import com.example.demo.adapter.repository.generator.IdGenerator;
import com.example.demo.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository extends BaseRepository<Product, Long> {
	public ProductRepository(IdGenerator<Long> idGenerator) {
		super(idGenerator);
	}
}
