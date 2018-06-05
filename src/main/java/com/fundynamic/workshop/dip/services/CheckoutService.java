package com.fundynamic.workshop.dip.services;

import com.fundynamic.workshop.dip.models.CheckoutRequest;
import com.fundynamic.workshop.dip.models.CheckoutResult;

public interface CheckoutService {

	CheckoutResult doCheckout(CheckoutRequest checkoutRequest);

}
