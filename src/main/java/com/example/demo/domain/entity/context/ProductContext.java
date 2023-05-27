package com.example.demo.domain.entity.context;

import com.example.demo.domain.entity.Data;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductContext {
	BigDecimal price;
	Data data;
}
