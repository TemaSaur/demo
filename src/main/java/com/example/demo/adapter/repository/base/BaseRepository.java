package com.example.demo.adapter.repository.base;

import com.example.demo.adapter.repository.generator.IdGenerator;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public abstract class BaseRepository
		<T extends BaseDomainEntity<TId>, TId>
		implements JpaRepository<T, TId> {
	private Map<TId, T> entities = new ConcurrentHashMap<>();
	private IdGenerator<TId> idGenerator;

	public BaseRepository(IdGenerator<TId> idGenerator) {
		this.idGenerator = idGenerator;
	}


	@Override
	public List<T> findAll() {
		return new ArrayList<>(entities.values());
	}

	@Override
	public List<T> findAll(Sort sort) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<T> findAllById(Iterable<TId> ids) {
		return StreamSupport.stream(ids.spliterator(), false)
				.map(entities::get)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

	@Override
	public long count() {
		return entities.size();
	}

	@Override
	public void deleteById(TId id) {
		entities.remove(id);
	}

	@Override
	public void delete(T entity) {
		entities.remove(entity.getId());
	}

	@Override
	public void deleteAllById(Iterable<? extends TId> IDs) {
		IDs.forEach(
				id -> entities.remove(id)
		);
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		entities.forEach(
				entity -> this.entities.remove(entity.getId())
		);
	}

	@Override
	public void deleteAll() {
		entities.clear();
	}

	@Override
	public <S extends T> S save(S entity) {
		if (entity.isNotInitialized()) {
			TId id = idGenerator.generateNextFor(entity.getClass());
			entity.tryInitialize(id);
		}
		entities.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public <S extends T> List<S> saveAll(Iterable<S> entities) {
		return StreamSupport.stream(entities.spliterator(), false)
				.filter(Objects::nonNull)
				.map(this::save)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<T> findById(TId id) {
		return Optional.ofNullable(entities.get(id));
	}

	@Override
	public boolean existsById(TId id) {
		return entities.containsKey(id);
	}

	@Override
	public void flush() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> S saveAndFlush(S entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAllInBatch(Iterable<T> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<TId> IDs) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAllInBatch() {
		throw new UnsupportedOperationException();
	}

	@Override
	public T getOne(TId aID) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T getById(TId aID) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T getReferenceById(TId aID) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> Optional<S> findOne(Example<S> example) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> long count(Example<S> example) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T> boolean exists(Example<S> example) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
		throw new UnsupportedOperationException();
	}
}
