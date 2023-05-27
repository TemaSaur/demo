package com.example.demo.beans.dough;

import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PROTECTED;

@Getter
@FieldDefaults(level=PROTECTED)
public class Dough {
	@NonNull
	private final int cost;
	private Boolean isAvailable;

	public Dough(int cost) {
		this.cost = cost;
	}

	public void start() {
		isAvailable = true;
		System.out.println("Dough is ready :)");
	}

	public void stop() {
		isAvailable = false;
		System.out.println("No dough left :(");
	}
}
