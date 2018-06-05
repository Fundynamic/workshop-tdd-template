package com.fundynamic.workshop.dip.services;

public interface MailService {

	void sendCheckoutSuccess();

	// example: to show this is the hard way
	static MailService getInstance() {
		return new MailService() {
			@Override
			public void sendCheckoutSuccess() {
				throw new IllegalStateException("Cannot connect to mail server");
			}
		};
	}

}
