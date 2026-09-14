package com.guessmaster.model;

/**
 * Possible outcomes of a single guess.
 */
public enum GuessResult {
    /** The guess matched the secret number. */
    CORRECT,
    /** The guess was inside the range but lower than the secret. */
    TOO_LOW,
    /** The guess was inside the range but higher than the secret. */
    TOO_HIGH,
    /** The guess was outside the valid range (attempt not consumed). */
    OUT_OF_RANGE,
    /** No attempts left and the secret was not guessed. */
    GAME_OVER
}
