package com.example.demo.beans.baked_product;

import com.example.demo.beans.dough.Dough;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static lombok.AccessLevel.PROTECTED;

@RequiredArgsConstructor
@FieldDefaults(level=PROTECTED)
public class BakedProduct {
	@NonNull
	private final Dough dough;
	private boolean isInStork = true;

	@PostConstruct
	public void postConstruct() {
		dough.start();
		printDough(dough);
	}

	@PreDestroy
	public void preDestroy() {
		dough.stop();
		printDough(dough);
	}

	private void printDough(Dough dough) {
		System.out.println(String.format(
				"The dough (cost %d) is%s ready to cook",
				dough.getCost(),
				dough.getIsAvailable() ? "" : " not"));
	}
}
