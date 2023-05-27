package com.example.demo.adapter.repository;

import com.example.demo.adapter.repository.base.BaseRepository;
import com.example.demo.adapter.repository.generator.IdGenerator;
import com.example.demo.domain.entity.Data;
import org.springframework.stereotype.Component;

@Component
public class DataRepository extends BaseRepository<Data, Long> {
	public DataRepository(IdGenerator<Long> idGenerator) {
		super(idGenerator);
	}
}
