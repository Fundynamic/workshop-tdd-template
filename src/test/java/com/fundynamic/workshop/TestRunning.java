package com.fundynamic.workshop;

import org.junit.Assert;
import org.junit.Test;

public class TestRunning {

	@Test
	public void itWorks() {
		Assert.assertTrue(true);
	}

	@Test
	public void itCanInstantiateClassFromMain() {
		new TestRunningFromMain();
	}

}
