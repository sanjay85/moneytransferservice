package com.db.awmd.moneytransfer.notification;

import java.util.logging.Logger;

import com.db.awmd.moneytransfer.model.dto.request.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotificationService implements NotificationService {

	Logger logger = Logger.getLogger(EmailNotificationService.class.getName());

	@Override
	public void notifyAboutTransfer(Account account, String transferDescription) {
		// THIS METHOD SHOULD NOT BE CHANGED - ASSUME YOUR COLLEAGUE WILL IMPLEMENT IT
		logger.info("Sending notification to owner of {}: {}" + account.getAccountId() + transferDescription);
	}

}
