package com.example.demo.domain.entity;

import com.example.demo.adapter.repository.base.BaseDomainEntity;
import com.example.demo.domain.entity.context.DataContext;
import lombok.NonNull;
import lombok.Value;
import java.util.Date;

@Value
public class Data extends BaseDomainEntity<Long> {
	@NonNull
	Date date;

	public static Data createDataFrom(DataContext context) {
		return new Data(context.getDate());
	}
}
