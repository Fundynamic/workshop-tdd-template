package com.fundynamic.workshop;

public class Game {

	private int currentRoll = 0;
	private int rolls[] = new int[21]; // 9 frames 2 rolls, 10th frame possibly 3 rolls

	public void roll(int pins) {
		rolls[currentRoll] = pins;
		currentRoll++;
	}

	public int score() {
		int score = 0;
		for (int roll = 0; roll < 21; roll++) {
			score += rolls[roll];
		}
		return score;
	}
}
