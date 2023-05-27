package com.example.demo.domain.dto.request;

import com.example.demo.domain.entity.Data;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductRequest {
	BigDecimal price;
	Data data;
}
