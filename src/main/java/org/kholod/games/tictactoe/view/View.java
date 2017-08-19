package org.kholod.games.tictactoe.view;

import org.kholod.games.tictactoe.controller.Controller;
import org.kholod.games.tictactoe.model.Sign;

/**
 * Represents view of game field
 */
public class View {

    private Controller controller;

    /**
     * Creates view with given controller
     *
     * @param controller given controller
     */
    public View(Controller controller) {
        this.controller = controller;
    }

    /**
     * Prints game field in actual state
     */
    public void print() {
        System.out.println();

        Sign[][] field = controller.getGame().getField();
        int xLength = field[0].length;
        int yLength = field.length;

        System.out.print("  ");
        for (int i = 0; i < xLength; i++) {
            System.out.print(i + "    ");
        }
        System.out.println();

        System.out.print("  ");
        for (int i = 0; i < xLength; i++) {
            if (i != xLength - 1)
                System.out.print("-----");
            else
                System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < yLength; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < xLength; j++) {
                System.out.print(field[i][j].getView());
                System.out.print("    ");
            }
            System.out.println();
            if (i != yLength - 1)
                System.out.println(" |");
        }

        System.out.println();
    }
}
