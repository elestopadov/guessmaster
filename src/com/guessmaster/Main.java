package com.guessmaster;

import com.guessmaster.app.GameApp;

/**
 * Entry point for the GuessMaster application.
 */
public final class Main {

    private Main() {
        // Prevent instantiation.
    }

    /**
     * Starts the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new GameApp().run();
    }
}
