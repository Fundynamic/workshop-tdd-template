package com.fundynamic.workshop.dip.models;

public class CheckoutResult {

	private final CheckoutResultCode checkoutResultCode;

	public CheckoutResult(CheckoutResultCode checkoutResultCode) {
		this.checkoutResultCode = checkoutResultCode;
	}

	public CheckoutResultCode getCheckoutResultCode() {
		return checkoutResultCode;
	}

	public boolean isSuccess() {
		return CheckoutResultCode.SUCCESS.equals(checkoutResultCode);
	}
}
