package com.example.demo.domain.dto.response;

import lombok.Value;
import java.math.BigDecimal;
import java.util.Date;

@Value
public class ProductResponse {
	BigDecimal price;
	String description;
	Date productionDate;
}
