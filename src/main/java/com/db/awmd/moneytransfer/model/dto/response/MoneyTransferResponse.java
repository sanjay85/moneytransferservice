package com.db.awmd.moneytransfer.model.dto.response;

import lombok.Data;

@Data
public class MoneyTransferResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	private String transactionId;
}
