package org.kholod.games.tictactoe.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Contains methods help to work with console
 */
public class ConsoleHelper {

    /**
     * Prints given message to console
     *
     * @param message given message
     */
    public static void print(String message) {
        System.out.println(message);
    }

    /**
     * Reads message from console and returns it. Completes the program
     * if message is "exit" in any case
     *
     * @return message has been read
     * @throws IOException if input/output exception occurs
     */
    public static String read() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String message = reader.readLine();
        if (message.equalsIgnoreCase("exit")) {
            ConsoleHelper.print("By!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
        return message;
    }
}
