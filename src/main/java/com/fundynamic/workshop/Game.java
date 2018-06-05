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
		int firstInFrame = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isSpare(firstInFrame)) {
				score += 10 + nextBallForSpare(firstInFrame);
				firstInFrame += 2;
			} else {
				score += getScoreForTwoBallsInFrame(firstInFrame);
				firstInFrame += 2;
			}
		}
		return score;
	}

	private int getScoreForTwoBallsInFrame(int firstInFrame) {
		return rolls[firstInFrame] + rolls[firstInFrame + 1];
	}

	private int nextBallForSpare(int firstInFrame) {
		return rolls[firstInFrame + 2];
	}

	private boolean isSpare(int firstInFrame) {
		return getScoreForTwoBallsInFrame(firstInFrame) == 10;
	}
}
