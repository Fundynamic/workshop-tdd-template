package com.fundynamic.workshop.dip.services;

import com.fundynamic.workshop.dip.models.*;

public class CheckoutServiceImpl implements CheckoutService {

	private final MailService mailService;

	private final PaymentProviderService paymentProviderService;

	// Hard
	public CheckoutServiceImpl() {
		this.mailService = MailService.getInstance();
		this.paymentProviderService = PaymentProviderService.getInstance();
	}

	// Easy
	public CheckoutServiceImpl(MailService mailService, PaymentProviderService paymentProviderService) {
		this.mailService = mailService;
		this.paymentProviderService = paymentProviderService;
	}

	@Override
	public CheckoutResult doCheckout(CheckoutRequest checkoutRequest) {
		PaymentRequest paymentRequest = new PaymentRequest(); // harder to test code... , replace with Factory...

		PaymentResult result = paymentProviderService.doPayment(paymentRequest);

		if (result.isSuccess()) {
			mailService.sendCheckoutSuccess();
			return new CheckoutResult(CheckoutResultCode.SUCCESS);
		}

		return new CheckoutResult(CheckoutResultCode.FAILED);
	}


}
