package com.guessmaster.util;

import java.util.Scanner;

/**
 * Safe console input helper. Does NOT close System.in.
 */
public class InputReader {

    /** Creates an input reader backed by {@link System#in}. */
    public InputReader() {
    }

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads one line of console input.
     *
     * @param prompt text shown before reading
     * @return trimmed user input
     */
    public String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Reads an integer, repeating the prompt until a valid number is given.
     *
     * @param prompt text shown before each attempt
     * @return parsed integer
     */
    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
