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
		int i = 0;
		for (int frame = 0; frame < 10; frame++) {
			score += rolls[i] + rolls[i + 1];
			i += 2; // 2 falls in frame
		}
		return score;
	}
}
