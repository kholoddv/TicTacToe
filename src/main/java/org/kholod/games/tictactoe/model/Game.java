package org.kholod.games.tictactoe.model;

import org.kholod.games.tictactoe.controller.Controller;
import org.kholod.games.tictactoe.view.ConsoleHelper;

/**
 * Represents current game
 */
public class Game {
    private Player player1;
    private Player player2;
    private Sign[][] field;
    private boolean gameOver = false;
    private Controller controller;

    /**
     * Creates a new game with given controller
     *
     * @param controller given controller
     */
    public Game(Controller controller) {
        this.controller = controller;
    }

    public Sign[][] getField() {
        return field;
    }

    public void setField(Sign[][] field) {
        this.field = field;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Initializes field and players
     */
    public void start() {
        field = new Sign[][]{
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING},
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING},
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING}
        };

        ConsoleHelper.print("*********************************");
        ConsoleHelper.print("Hello! It is the tic-tac-toe game\n");
        ConsoleHelper.print("(Type \"exit\" for leaving game)");
        ConsoleHelper.print("*********************************");
        ConsoleHelper.print("");

        ConsoleHelper.print("Player 1");
        player1 = new Player(Sign.CROSS, this);
        ConsoleHelper.print("Player 2");
        player2 = new Player(Sign.ZERO, this);
        ConsoleHelper.print(player1.getName() + ", plays with "
                + player1.getSign().getView());
        ConsoleHelper.print(player2.getName() + ", plays with "
                + player2.getSign().getView());
        controller.getView().print();
    }

    /**
     * Does one step of game
     */
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

    /**
     * Checks whether the given player won. If he was not
     * checks whether the free cells remained
     *
     * @param player given player
     */
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
            ConsoleHelper.print(player.getName()
                    + "(" + player.getSign().getView() + ") " + "win" + "!!!");
            gameOver = true;
            return;
        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j] == Sign.NOTHING)
                    return;
            }
        }
        ConsoleHelper.print("The game ended in a draw!!!");
        gameOver = true;
    }
}
