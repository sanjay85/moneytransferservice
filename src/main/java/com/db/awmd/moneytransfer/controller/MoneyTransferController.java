package com.db.awmd.moneytransfer.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.awmd.moneytransfer.model.dto.request.MoneyTransferRequest;
import com.db.awmd.moneytransfer.service.MoneyTransferService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author sanjayJogdand This is the Money transfer Controller
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transfer")
public class MoneyTransferController {
	Logger logger = Logger.getLogger(MoneyTransferController.class.getName());

	@Autowired
	private final MoneyTransferService moneyTransferService = null;

	/**
	 * This method is used to money transfer between account template
	 * 
	 * @param moneyTransferRequest
	 * @return
	 */
	@PostMapping
	public ResponseEntity moneyTransfer(@RequestBody MoneyTransferRequest moneyTransferRequest) {
		logger.info("Recevied Money transfer request from API {}" + moneyTransferRequest.toString());
		return ResponseEntity.ok(moneyTransferService.moneyTransfer(moneyTransferRequest));
	}
}
