package com.fundynamic.workshop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameKata {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void canRoll() {
		game.roll(1);
	}

	@Test
	public void gutterGame() {
		for (int roll = 0; roll < 20; roll++) {
			game.roll(0);
		}
		Assert.assertEquals(0, game.score());
	}

	@Test
	public void allOnes() {
		for (int roll = 0; roll < 20; roll++) {
			game.roll(1);
		}
		Assert.assertEquals(20, game.score());
	}
}
