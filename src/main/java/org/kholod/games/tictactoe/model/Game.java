package org.kholod.games.tictactoe.model;

import org.kholod.games.tictactoe.controller.Controller;
import org.kholod.games.tictactoe.view.PrintHelper;

public class Game {
    private Player player1;
    private Player player2;
    private Sign[][] field;
    private boolean gameOver = false;
    private Controller controller;

    public Game(Controller controller) {
        this.controller = controller;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void start() {
        field = new Sign[][]{
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING},
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING},
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING}
        };
        PrintHelper.print("Player 1");
        player1 = new Player(Sign.CROSS, this);
        PrintHelper.print("Player 2");
        player2 = new Player(Sign.ZERO, this);
        PrintHelper.print(player1.getName() + ", plays with " + player1.getSign().getView());
        PrintHelper.print(player2.getName() + ", plays with " + player2.getSign().getView());
        controller.getView().print();
    }

    public void step() {
        if (!gameOver) {
            player1.step();
            controller.getView().print();
            check(player1);
        }

        if (!gameOver) {
            player2.step();
            controller.getView().print();
            check(player2);
        }
    }

    public void check(Player player) {
        Sign sign = player.getSign();
        if (field[0][0] == sign && field[0][1] == sign && field[0][2] == sign
                || field[1][0] == sign && field[1][1] == sign && field[1][2] == sign
                || field[2][0] == sign && field[2][1] == sign && field[2][2] == sign
                || field[0][0] == sign && field[1][0] == sign && field[2][0] == sign
                || field[0][1] == sign && field[1][1] == sign && field[2][1] == sign
                || field[0][2] == sign && field[1][2] == sign && field[2][2] == sign
                || field[0][0] == sign && field[1][1] == sign && field[2][2] == sign
                || field[0][2] == sign && field[1][1] == sign && field[2][0] == sign
                ) {
            PrintHelper.print(player.getName() + "(" + player.getSign().getView() + ")" + "win" + "!!!");
            gameOver = true;
            return;
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == Sign.NOTHING)
                    return;
            }
        }
        PrintHelper.print("The game ended in a draw!!!");
        gameOver = true;
    }

    public Sign[][] getField() {
        return field;
    }
}
