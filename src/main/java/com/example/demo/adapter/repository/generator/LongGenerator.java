package com.example.demo.adapter.repository.generator;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LongGenerator implements IdGenerator<Long> {
	Map<Class<?>, Long> nextIds = new ConcurrentHashMap<>();

	@Override
	public Long generateNextFor(Class<?> cls) {
		Long lastId = nextIds.getOrDefault(cls, 1L);
		nextIds.put(cls, lastId + 1);
		return lastId;
	}
}
