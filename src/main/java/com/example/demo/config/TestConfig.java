package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {
	@Bean
	@Profile(value = "test")
	public String testBean() {
		System.out.println("test");
		return "test";
	}

	@Bean
	@ConditionalOnBean(name = "testBean")
	public String dependsOnBean() {
		System.out.println("dependsOnBean");
		return "dependsOnBean";
	}

	@Bean
	@ConditionalOnExpression(value = "!'${my-config.my-env}'.equals('default')")
	public String dependsOnExpression() {
		System.out.println("dependsOnExpression");
		return "dependsOnExpression";
	}
}
