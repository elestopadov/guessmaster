package com.guessmaster.ui;

import com.guessmaster.core.Game;
import com.guessmaster.core.ScoreBoard;
import com.guessmaster.model.GuessResult;
import com.guessmaster.model.Player;

/**
 * Handles all console output (ASCII-only for CI safety).
 */
public class ConsoleUI {

    /** Creates a console UI. */
    public ConsoleUI() {
    }

    /** Prints the welcome banner. */
    public void printWelcome() {
        System.out.println("=================================");
        System.out.println("         GuessMaster 1.0         ");
        System.out.println("=================================");
    }

    /**
     * Prints a greeting for the current player.
     *
     * @param player the player who just entered their name
     */
    public void printGreeting(Player player) {
        System.out.println("Hello, " + player.name() + "! Let's play.");
    }

    /**
     * Prints the main menu with the current player and score.
     *
     * @param player current player
     * @param scoreBoard current score board
     */
    public void printMenu(Player player, ScoreBoard scoreBoard) {
        System.out.println();
        System.out.println("--- Main menu ---");
        System.out.println("Player: " + player.name());
        System.out.println("Score : " + scoreBoard.getScore());
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
    }

    /**
     * Prints the current round range and attempt limit.
     *
     * @param game the active round
     */
    public void printRangeInfo(Game game) {
        System.out.printf(
                "%nNew round! Guess a number between %d and %d. You have %d attempts.%n",
                game.getRangeStart(), game.getRangeEnd(), Game.MAX_ATTEMPTS);
    }

    /**
     * Prints feedback for a guess result.
     *
     * @param result outcome of the guess
     * @param game the active round
     */
    public void printGuessResult(GuessResult result, Game game) {
        switch (result) {
            case OUT_OF_RANGE -> System.out.printf(
                    "Please enter a number between %d and %d.%n",
                    game.getRangeStart(), game.getRangeEnd());
            case TOO_LOW -> System.out.printf(
                    "Too low! Attempts left: %d%n", game.getAttemptsLeft());
            case TOO_HIGH -> System.out.printf(
                    "Too high! Attempts left: %d%n", game.getAttemptsLeft());
            case CORRECT -> System.out.println("Correct! You earned 1 point.");
            case GAME_OVER -> System.out.printf(
                    "Out of attempts! The secret number was %d.%n",
                    game.getSecretNumber());
        }
    }

    /**
     * Prints the final score and goodbye message.
     *
     * @param player the player leaving the game
     * @param scoreBoard final score board
     */
    public void printFarewell(Player player, ScoreBoard scoreBoard) {
        System.out.printf("%nGoodbye, %s! Final score: %d.%n",
                player.name(), scoreBoard.getScore());
    }

    /**
     * Prints an error message.
     *
     * @param message error text to display
     */
    public void printError(String message) {
        System.out.println("[!] " + message);
    }
}
