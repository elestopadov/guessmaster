package com.guessmaster.util;

import java.util.Objects;
import java.util.Random;

/**
 * Generates random start values for a round's range.
 */
public class RangeGenerator {

    /** Minimum allowed start of the range (inclusive). */
    public static final int MIN_START = 1;
    /** Maximum allowed start of the range (inclusive). */
    public static final int MAX_START = 100;

    private final Random random;

    /**
     * Creates a generator backed by the supplied random source.
     *
     * @param random source of randomness (useful for tests)
     * @throws NullPointerException if random is null
     */
    public RangeGenerator(Random random) {
        this.random = Objects.requireNonNull(random, "random must not be null");
    }

    /**
     * Generates one random start value.
     *
     * @return a random start in [MIN_START, MAX_START]
     */
    public int randomStart() {
        return MIN_START + random.nextInt(MAX_START - MIN_START + 1);
    }
}
