package com.guessmaster.core;

import com.guessmaster.model.GuessResult;
import com.guessmaster.util.RangeGenerator;

import java.util.Random;

/**
 * Represents a single round of the game.
 */
public class Game {

    /** Number of consecutive integers in the generated range. */
    public static final int RANGE_SIZE = 7;
    /** Maximum number of attempts per round. */
    public static final int MAX_ATTEMPTS = 3;

    private final int rangeStart;
    private final int rangeEnd;
    private final int secretNumber;
    private int attemptsLeft;
    private boolean won;

    /** Creates a new round with a fresh Random. */
    public Game() {
        this(new Random());
    }

    /**
     * Creates a new round using the supplied random source.
     *
     * @param random source of randomness (useful for tests)
     * @throws NullPointerException if random is null
     */
    public Game(Random random) {
        int start = new RangeGenerator(random).randomStart();
        this.rangeStart = start;
        this.rangeEnd = start + RANGE_SIZE - 1;
        this.secretNumber = start + random.nextInt(RANGE_SIZE);
        this.attemptsLeft = MAX_ATTEMPTS;
    }

    /**
     * Processes a single guess.
     *
     * @param guess the number proposed by the player
     * @return outcome of the guess
     * @throws IllegalStateException if the round already finished
     */
    public GuessResult makeGuess(int guess) {
        if (isFinished()) {
            throw new IllegalStateException("Round is already finished");
        }
        if (guess < rangeStart || guess > rangeEnd) {
            return GuessResult.OUT_OF_RANGE;
        }
        attemptsLeft--;
        if (guess == secretNumber) {
            won = true;
            return GuessResult.CORRECT;
        }
        if (attemptsLeft == 0) {
            return GuessResult.GAME_OVER;
        }
        return guess < secretNumber ? GuessResult.TOO_LOW : GuessResult.TOO_HIGH;
    }

    /**
     * Reports whether the round has ended with a win or loss.
     *
     * @return true if the round has ended
     */
    public boolean isFinished() { return won || attemptsLeft == 0; }

    /**
     * Reports whether the player guessed the secret number.
     *
     * @return true if the player won
     */
    public boolean isWon() { return won; }

    /**
     * Returns the inclusive lower bound of the range.
     *
     * @return inclusive lower bound
     */
    public int getRangeStart() { return rangeStart; }

    /**
     * Returns the inclusive upper bound of the range.
     *
     * @return inclusive upper bound
     */
    public int getRangeEnd() { return rangeEnd; }

    /**
     * Returns the number of attempts still available.
     *
     * @return attempts still available
     */
    public int getAttemptsLeft() { return attemptsLeft; }

    /**
     * Returns the secret number for revealing the answer after a loss.
     *
     * @return the secret number
     */
    public int getSecretNumber() { return secretNumber; }
}
