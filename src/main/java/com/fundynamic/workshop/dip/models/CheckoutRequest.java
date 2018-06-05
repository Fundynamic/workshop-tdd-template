package com.fundynamic.workshop.dip.models;

public class CheckoutRequest {

	// amount, personal data, visa card, etc.

	public final long timestamp;

	public CheckoutRequest(long timestamp) {
		this.timestamp = timestamp;
	}

	public CheckoutRequest() {
		// BAD: Time is a dependency
		this.timestamp = System.currentTimeMillis();
	}
}
