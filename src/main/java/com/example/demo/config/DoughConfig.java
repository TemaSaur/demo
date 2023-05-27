package com.example.demo.config;

import com.example.demo.beans.dough.Dough;
import com.example.demo.beans.dough.YeastDough;
import com.example.demo.beans.dough.PuffDough;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DoughConfig {
	@Bean
	@Scope(value="prototype")
	public Dough createYeastDough() {
		return new YeastDough();
	}

	@Bean
	@Scope(value="prototype")
	public Dough createPuffDough() {
		return new PuffDough();
	}
}
