package com.db.awmd.moneytransfer.service;

import com.db.awmd.moneytransfer.exception.MoneyTransferGlobalException;
import com.db.awmd.moneytransfer.model.dto.request.MoneyTransferRequest;
import com.db.awmd.moneytransfer.model.dto.response.MoneyTransferResponse;

/**
 * 
 * @author sanjayJogdand This is the Money transfer service interface.
 */
public interface MoneyTransferService {

	public MoneyTransferResponse moneyTransfer(MoneyTransferRequest request) throws MoneyTransferGlobalException;
}
