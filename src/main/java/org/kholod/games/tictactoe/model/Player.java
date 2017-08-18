package org.kholod.games.tictactoe.model;

import org.kholod.games.tictactoe.view.PrintHelper;

import java.io.IOException;

public class Player {
    private Sign sign;
    private String name;
    private Game game;

    public Player(Sign sign, Game game) {
        this.sign = sign;
        this.game = game;
        PrintHelper.print("Enter name:");
        try {
            this.name = PrintHelper.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public Sign getSign() {
        return sign;
    }

    public void step() {
        PrintHelper.print(getName() + "(" + getSign().getView() + ")" + "moves");
        String coordinates = "";
        while (true) {
            PrintHelper.print("Enter coordinates x,y:");
            try {
                coordinates = PrintHelper.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!coordinates.matches("[012],[012]")) {
                PrintHelper.print("Incorrect input!");
                continue;
            }
            int x = Integer.parseInt(coordinates.substring(0, 1));
            int y = Integer.parseInt(coordinates.substring(2, 3));
            if (game.getField()[y][x] == Sign.NOTHING) {
                game.getField()[y][x] = getSign();
                return;
            } else {
                PrintHelper.print("This field is busy!");
            }
        }
    }
}
