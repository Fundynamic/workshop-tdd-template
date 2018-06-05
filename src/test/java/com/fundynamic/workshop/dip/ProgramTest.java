package com.fundynamic.workshop.dip;

import com.fundynamic.workshop.dip.models.CheckoutRequest;
import com.fundynamic.workshop.dip.models.CheckoutResult;
import com.fundynamic.workshop.dip.models.CheckoutResultCode;
import com.fundynamic.workshop.dip.services.CheckoutService;
import com.fundynamic.workshop.dip.services.TimeProvider;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

	// BAD EXAMPLE
	@Test
	public void requestTimestampOneSecondAfterSystemTimeShouldCauseFailure() throws InterruptedException {
	    // because reasons...
		CheckoutService checkoutService = mock(CheckoutService.class);

		Program program = new Program(checkoutService);

		// Act
		CheckoutRequest checkoutRequest = new CheckoutRequest();
		Thread.sleep(1001L); // WHAT!?
		String response = program.doCheckout(checkoutRequest);

		// Assert
		Assert.assertEquals("redirect:/failed.html", response);
	}

	// GOOD EXAMPLE
	@Test
	public void requestTimestampOneSecondAfterSystemTimeShouldCauseFailureInTheSaneWay() throws InterruptedException {
		long timeInMilisForRequest = 1000;

	    // because reasons...
		CheckoutService checkoutService = mock(CheckoutService.class);
		TimeProvider timeProvider = mock(TimeProvider.class);

		when(timeProvider.getCurrentTimeInMs()).thenReturn(timeInMilisForRequest + 1001);
		Program program = new Program(checkoutService, timeProvider);

		// Act
		CheckoutRequest checkoutRequest = new CheckoutRequest(timeInMilisForRequest);

		String response = program.doCheckout(checkoutRequest);

		// Assert
		Assert.assertEquals("redirect:/failed.html", response);
	}

	// GOOD EXAMPLE
	@Test
	public void requestTimestampOneSecondAfterSystemTimeShouldCauseFailureInTheSaneWayCheckNoInteraction() throws InterruptedException {
		long timeInMilisForRequest = 1000;

	    // because reasons...
		CheckoutService checkoutService = mock(CheckoutService.class);
		TimeProvider timeProvider = mock(TimeProvider.class);

		when(timeProvider.getCurrentTimeInMs()).thenReturn(timeInMilisForRequest + 1001);
		Program program = new Program(checkoutService, timeProvider);

		// Act
		CheckoutRequest checkoutRequest = new CheckoutRequest(timeInMilisForRequest);

		program.doCheckout(checkoutRequest);

		// Verify
		verify(checkoutService, never()).doCheckout(any());
	}

	// GOOD EXAMPLE / another way of 'stubbing'
	@Test
	public void requestTimestampOneSecondAfterSystemTimeShouldCauseFailureInTheSaneWayExample2() throws InterruptedException {
		long timeInMilisForRequest = 1000;

	    // because reasons...
		CheckoutService checkoutService = mock(CheckoutService.class);
		TimeProvider timeProvider = new TimeProvider() {
			@Override
			public long getCurrentTimeInMs() {
				return timeInMilisForRequest + 1001;
			}
		};

		Program program = new Program(checkoutService, timeProvider);

		// Act
		CheckoutRequest checkoutRequest = new CheckoutRequest(timeInMilisForRequest);

		String response = program.doCheckout(checkoutRequest);

		// Assert
		Assert.assertEquals("redirect:/failed.html", response);
	}
}