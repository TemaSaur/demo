package com.example.demo.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Date;

@Value
public class ProductResponse {
	Long id;
	BigDecimal price;
	Data data;

	@Value
	public static class Data {
		Long id;
		@JsonFormat(pattern = "yyyy-MM-dd")
		Date date;
	}
}
