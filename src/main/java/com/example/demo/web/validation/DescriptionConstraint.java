package com.example.demo.web.validation;

import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.Constraint;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;

@NotBlank
@Size(min = 10, max = 10000)
@Target({ FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DescriptionValidator.class)
@Documented
public @interface DescriptionConstraint {
	String message()
			default "Please enter a correct description. The length of the description must be between 10 and 10000 characters and contain at least one hashtag";

	Class<?>[] groups()
			default { };

	Class<? extends Payload>[] payload()
			default { };
}

