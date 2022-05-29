package com.db.awmd.moneytransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.awmd.moneytransfer.model.entity.MoneyTransferEntity;

public interface MoneyTransferRepository extends JpaRepository<MoneyTransferEntity, Long> {
}
