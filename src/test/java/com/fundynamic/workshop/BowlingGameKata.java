package com.fundynamic.workshop;

import org.junit.Test;

public class BowlingGameKata {

	@Test
	public void canCreateGame() {
		new Game();
	}

	@Test
	public void canRoll() {
		Game game = new Game();
		game.roll(1);
	}
}
