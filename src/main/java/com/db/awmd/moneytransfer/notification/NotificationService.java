package com.db.awmd.moneytransfer.notification;

import com.db.awmd.moneytransfer.model.dto.request.Account;

public interface NotificationService {

	void notifyAboutTransfer(Account account, String transferDescription);
}
