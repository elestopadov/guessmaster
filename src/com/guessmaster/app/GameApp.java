package com.guessmaster.app;

import com.guessmaster.core.Game;
import com.guessmaster.core.ScoreBoard;
import com.guessmaster.model.GuessResult;
import com.guessmaster.model.Player;
import com.guessmaster.ui.ConsoleUI;
import com.guessmaster.util.InputReader;

/**
 * Application orchestrator: menu loop and session wiring.
 */
public class GameApp {

    /** Creates the application orchestrator. */
    public GameApp() {
    }

    private final InputReader input = new InputReader();
    private final ConsoleUI ui = new ConsoleUI();
    private final ScoreBoard scoreBoard = new ScoreBoard();

    /** Runs the interactive session until the user exits. */
    public void run() {
        ui.printWelcome();
        Player player = new Player(readPlayerName());
        ui.printGreeting(player);

        boolean running = true;
        while (running) {
            ui.printMenu(player, scoreBoard);
            switch (input.readInt("Choose: ")) {
                case 1 -> playRound();
                case 2 -> running = false;
                default -> ui.printError("Invalid choice. Enter 1 or 2.");
            }
        }
        ui.printFarewell(player, scoreBoard);
    }

    /**
     * Reads and validates a non-blank player name.
     *
     * @return a non-blank player name
     */
    private String readPlayerName() {
        while (true) {
            String candidate = input.readLine("Enter your name: ");
            if (!candidate.isBlank()) {
                return candidate;
            }
            ui.printError("Name must not be empty.");
        }
    }

    /**
     * Plays one round and awards a point on a win.
     */
    private void playRound() {
        Game game = new Game();
        ui.printRangeInfo(game);
        while (!game.isFinished()) {
            int guess = input.readInt("Enter your guess: ");
            GuessResult result = game.makeGuess(guess);
            ui.printGuessResult(result, game);
        }
        if (game.isWon()) {
            scoreBoard.increment();
        }
    }
}
