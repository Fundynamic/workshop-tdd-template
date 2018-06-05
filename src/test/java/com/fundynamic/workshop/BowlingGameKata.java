package com.fundynamic.workshop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
		rollMany(20, 0);
		assertEquals(0, game.score());
	}

	@Test
	public void allOnes() {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}

	@Test
	public void oneSpare() {
		game.roll(5);
		game.roll(5); // spare
		game.roll(3);

		assertEquals(16, game.score());
	}

	private void rollMany(int rolls, int pins) {
		for (int roll = 0; roll < rolls; roll++) {
			game.roll(pins);
		}
	}
}
