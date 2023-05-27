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
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Bakery {
	private List<BakedProduct> availableProducts;

	@Autowired
	public void setAvailableProducts(List<BakedProduct> products) {
		availableProducts = products;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Bakery is opening !1!!");
		availableProducts.forEach(product ->
				System.out.println(String.format(
						"Product %s is in bakery",
						product.hashCode())));
	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Bakery is closing!1!");
	}
}
