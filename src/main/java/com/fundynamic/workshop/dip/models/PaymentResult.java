package com.fundynamic.workshop.dip.models;

public class PaymentResult {

	private final PaymentResultCode resultCode;

	public PaymentResult(PaymentResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public PaymentResultCode getResultCode() {
		return resultCode;
	}

	public boolean isSuccess() {
		return PaymentResultCode.SUCCESS.equals(resultCode);
	}
}
