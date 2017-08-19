package org.kholod.games.tictactoe.model;

import org.kholod.games.tictactoe.view.ConsoleHelper;

import java.io.IOException;

/**
 * Represents one player
 */
public class Player {
    private Sign sign;
    private String name;
    private Game game;

    public String getName() {
        return name;
    }

    public Sign getSign() {
        return sign;
    }

    /**
     * Creates a new player with given sign and game. Name is requested
     * from user
     *
     * @param sign given sign
     * @param game given game
     */
    public Player(Sign sign, Game game) {
        this.sign = sign;
        this.game = game;
        ConsoleHelper.print("Enter name:");
        try {
            this.name = ConsoleHelper.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Execute one step of this player
     */
    public void step() {
        ConsoleHelper.print(getName() + "(" + getSign().getView() + ") "
                + "moves");
        String coordinates = "";
        while (true) {
            ConsoleHelper.print("Enter coordinates x,y (example: \"0,2\"):");
            try {
                coordinates = ConsoleHelper.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!coordinates.matches("[012],[012]")) {
                ConsoleHelper.print("Incorrect input!");
                continue;
            }
            int x = Integer.parseInt(coordinates.substring(0, 1));
            int y = Integer.parseInt(coordinates.substring(2, 3));
            if (game.getField()[y][x] == Sign.NOTHING) {
                game.getField()[y][x] = getSign();
                return;
            } else {
                ConsoleHelper.print("This cell is busy!");
            }
        }
    }
}
