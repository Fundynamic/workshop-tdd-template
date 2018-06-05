package com.fundynamic.workshop.dip;

import com.fundynamic.workshop.dip.models.CheckoutRequest;
import com.fundynamic.workshop.dip.models.CheckoutResult;
import com.fundynamic.workshop.dip.services.CheckoutService;
import com.fundynamic.workshop.dip.services.TimeProvider;

/**
 * This could be your 'controller' or whatever that binds your view to your code. It gets 'actions' are called, on submit, click, tap, etc.
 */
public class Program {

	/**
	 * Dependency
	 */
	private final CheckoutService checkoutService;
	private final TimeProvider timeProvider;

	public Program(CheckoutService checkoutService, TimeProvider timeProvider) {
		this.checkoutService = checkoutService;
		this.timeProvider = timeProvider;
	}

	public Program(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
		this.timeProvider = TimeProvider.getInstanceWithCurrentTimeInMilis();
	}

	/**
	 * This is where some UI is bound do the code, triggering this action
	 *
	 * @param checkoutRequest
	 */
	public String doCheckout(CheckoutRequest checkoutRequest) {
		if (checkoutRequest.timestamp + 1L > timeProvider.getCurrentTimeInMs()) {
			CheckoutResult checkoutResult = checkoutService.doCheckout(checkoutRequest);
			if (checkoutResult.isSuccess()) {
				return "redirect:/success.html";
			}
		}
		return "redirect:/failed.html";
	}

}
