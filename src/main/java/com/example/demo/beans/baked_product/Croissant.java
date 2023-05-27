package com.example.demo.beans.baked_product;

import com.example.demo.beans.dough.Dough;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Croissant extends BakedProduct {
	public Croissant(@Qualifier(value="createPuffDough") Dough dough) {
		super(dough);
	}
}
