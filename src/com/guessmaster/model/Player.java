package com.guessmaster.model;

/**
 * Immutable representation of the player.
 *
 * @param name the player's display name; must not be null or blank
 */
public record Player(String name) {

    /**
     * Validates and trims the player name.
     *
     * @throws IllegalArgumentException if name is null or blank
     */
    public Player {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name must not be blank");
        }
        name = name.trim();
    }
}

