package org.kholod.games.tictactoe.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintHelper {
    public static void print(String string) {
        System.out.println(string);
    }

    public static String read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
