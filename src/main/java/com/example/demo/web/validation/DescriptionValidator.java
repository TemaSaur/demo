package com.example.demo.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class DescriptionValidator implements ConstraintValidator<DescriptionConstraint, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Pattern.matches("\s#[^\s]+", value);
	}
}