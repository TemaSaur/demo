package com.example.demo.adapter.repository.generator;

public interface IdGenerator<T> {
	T generateNextFor(Class<?> cls);
}
