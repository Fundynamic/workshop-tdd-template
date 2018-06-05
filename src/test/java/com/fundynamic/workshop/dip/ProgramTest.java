package com.fundynamic.workshop.dip;

import com.fundynamic.workshop.dip.models.CheckoutRequest;
import com.fundynamic.workshop.dip.models.CheckoutResult;
import com.fundynamic.workshop.dip.models.CheckoutResultCode;
import com.fundynamic.workshop.dip.services.CheckoutService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProgramTest {

	@Test
	public void onSuccessRedirectToSuccess() {
		CheckoutService checkoutService = mock(CheckoutService.class);

		Program program = new Program(checkoutService);

		when(checkoutService.doCheckout(any())).thenReturn(new CheckoutResult(CheckoutResultCode.SUCCESS));

		// Act
		String response = program.doCheckout(new CheckoutRequest());

		// Assert
		Assert.assertEquals("redirect:/success.html", response);
	}

	@Test
	public void onFailureRedirectToFailed() {
		CheckoutService checkoutService = mock(CheckoutService.class);

		Program program = new Program(checkoutService);

		when(checkoutService.doCheckout(any())).thenReturn(new CheckoutResult(CheckoutResultCode.FAILED));

		// Act
		String response = program.doCheckout(new CheckoutRequest());

		// Assert
		Assert.assertEquals("redirect:/failed.html", response);
	}
}