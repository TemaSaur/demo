package com.example.demo.adapter.repository.base;

import lombok.Getter;

@Getter
public abstract class BaseDomainEntity<TId> {
	private TId id;

	protected boolean isNotInitialized() {
		return id == null;
	}

	public void tryInitialize(TId id) {
		if (isNotInitialized())
			this.id = id;
	}
}
