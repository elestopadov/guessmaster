package com.guessmaster.core;

/**
 * Tracks the player's score during a session.
 */
public class ScoreBoard {

    /** Creates an empty score board. */
    public ScoreBoard() {
    }

    private int score;

    /** Increases the score by one point. */
    public void increment() { score++; }

    /**
     * Returns the number of successfully solved rounds.
     *
     * @return number of successfully solved rounds
     */
    public int getScore() { return score; }
}
