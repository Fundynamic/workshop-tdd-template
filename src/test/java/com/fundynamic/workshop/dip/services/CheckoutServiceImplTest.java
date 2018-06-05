package com.fundynamic.workshop.dip.services;

import com.fundynamic.workshop.dip.models.CheckoutRequest;
import com.fundynamic.workshop.dip.models.PaymentResult;
import com.fundynamic.workshop.dip.models.PaymentResultCode;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutServiceImplTest {

	@Test
	public void easyTest() {
		// Arrange
		MailService mailService = Mockito.mock(MailService.class);
		PaymentProviderService paymentProviderService = Mockito.mock(PaymentProviderService.class);

		CheckoutServiceImpl checkoutService = new CheckoutServiceImpl(mailService, paymentProviderService);

		when(paymentProviderService.doPayment(any())).thenReturn(new PaymentResult(PaymentResultCode.SUCCESS));

		// Act
		checkoutService.doCheckout(new CheckoutRequest());

		// Assert / Verify
		verify(mailService).sendCheckoutSuccess();
	}

	@Test
	public void hardTest() {
		// Arrange
		CheckoutServiceImpl checkoutService = new CheckoutServiceImpl();

		// darn it, objects are created by Constructor / using getInstance. Which - who knows - will have their
		// own getInstance callees, etc...

		// Act
		checkoutService.doCheckout(new CheckoutRequest());

		// Assert / Verify
		// HOW!?
	}
}