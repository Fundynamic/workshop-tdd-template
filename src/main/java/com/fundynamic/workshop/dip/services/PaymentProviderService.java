package com.fundynamic.workshop.dip.services;

import com.fundynamic.workshop.dip.models.PaymentRequest;
import com.fundynamic.workshop.dip.models.PaymentResult;

public interface PaymentProviderService {

	PaymentResult doPayment(PaymentRequest paymentRequest);

	// example: to show this is the hard way
	static PaymentProviderService getInstance() {
		return new PaymentProviderService() {
			@Override
			public PaymentResult doPayment(PaymentRequest paymentRequest) {
				throw new IllegalStateException("Unable to connect. - this could possibly be really going to a 3rd party mail server");
			}
		};
	}

}
