package com.fundynamic.workshop;

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

}
