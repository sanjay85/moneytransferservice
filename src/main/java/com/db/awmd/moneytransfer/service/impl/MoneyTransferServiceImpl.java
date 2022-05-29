package com.db.awmd.moneytransfer.service.impl;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.awmd.moneytransfer.controller.MoneyTransferController;
import com.db.awmd.moneytransfer.exception.MoneyTransferGlobalException;
import com.db.awmd.moneytransfer.model.dto.request.Account;
import com.db.awmd.moneytransfer.model.dto.request.MoneyTransferRequest;
import com.db.awmd.moneytransfer.model.dto.request.TransactionStatus;
import com.db.awmd.moneytransfer.model.dto.response.MoneyTransferResponse;
import com.db.awmd.moneytransfer.model.entity.MoneyTransferEntity;
import com.db.awmd.moneytransfer.notification.EmailNotificationService;
import com.db.awmd.moneytransfer.repository.MoneyTransferRepository;
import com.db.awmd.moneytransfer.service.MoneyTransferService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author sanjayJogdand This is the Money transfer service implementation.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class MoneyTransferServiceImpl implements MoneyTransferService {
	Logger logger = Logger.getLogger(MoneyTransferController.class.getName());

	@Autowired
	private EmailNotificationService emailNotificationService;
	
	@Autowired
	private final MoneyTransferRepository moneyTransferRepository = null;

	/**
	 * This method is used to money transfer between account template
	 * 
	 * @param moneyTransferRequest
	 * @return moneyTransferResponse
	 */
	public MoneyTransferResponse moneyTransfer(MoneyTransferRequest moneyTransferequest)
			throws MoneyTransferGlobalException {
		logger.info("Sending money transfer request {}" + moneyTransferequest.toString());

		MoneyTransferEntity entity = new MoneyTransferEntity();
		BeanUtils.copyProperties(moneyTransferequest, entity);
		entity.setStatus(TransactionStatus.PENDING);
		MoneyTransferEntity optMoneyTransfer = moneyTransferRepository.save(entity);
		MoneyTransferResponse moneyTransferResponse = new MoneyTransferResponse();
		optMoneyTransfer.setStatus(TransactionStatus.SUCCESS);
		moneyTransferRepository.save(optMoneyTransfer);
		moneyTransferResponse.setMessage("Money Transfer Successfully Completed");
		emailNotificationService.notifyAboutTransfer(null, null);
		return moneyTransferResponse;

	}

}
