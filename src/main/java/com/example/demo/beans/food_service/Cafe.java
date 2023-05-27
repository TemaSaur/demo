package com.example.demo.beans.food_service;

import com.example.demo.beans.baked_product.BakedProduct;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cafe {
	@Autowired
	List<BakedProduct> availableProducts;

	@PostConstruct
	public void postConstruct() {
		System.out.println("Cafe is opening!11");
		availableProducts.forEach(product ->
				System.out.println(String.format(
						"Product %s is in cafe",
						product.hashCode())));
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Cafe is closing!1");
	}
}
