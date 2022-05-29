package com.db.awmd.moneytransfer.model.mapper;

import org.springframework.beans.BeanUtils;

import com.db.awmd.moneytransfer.model.dto.response.MoneyTransfer;
import com.db.awmd.moneytransfer.model.entity.MoneyTransferEntity;

public class MoneyTransferMapper extends BaseMapper<MoneyTransferEntity, MoneyTransfer> {
	@Override
	public MoneyTransferEntity convertToEntity(MoneyTransfer dto, Object... args) {
		MoneyTransferEntity entity = new MoneyTransferEntity();
		if (dto != null) {
			BeanUtils.copyProperties(dto, entity);
		}
		return entity;
	}

	@Override
	public MoneyTransfer convertToDto(MoneyTransferEntity entity, Object... args) {
		MoneyTransfer dto = new MoneyTransfer();
		if (entity != null) {
			BeanUtils.copyProperties(entity, dto);
		}
		return dto;
	}
}
