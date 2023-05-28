package com.example.demo.domain.dto.request;

import com.example.demo.web.validation.DateConstraint;
import com.example.demo.web.validation.DescriptionConstraint;
import lombok.Value;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

@Value
public class ProductRequest {
	@Min(0)
	BigDecimal price;

	@DescriptionConstraint
	String description;

	@DateConstraint
	Date productionDate;
}
