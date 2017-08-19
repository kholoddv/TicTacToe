package org.kholod.games.tictactoe;

import org.kholod.games.tictactoe.controller.Controller;
import org.kholod.games.tictactoe.model.Game;
import org.kholod.games.tictactoe.view.View;

/**
 * Main class for start the game
 */
public class App {

    /**
     * Creates controller, game and view and starts the game
     *
     * @param args arguments of command line
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        Game game = new Game(controller);
        View view = new View(controller);
        controller.setGame(game);
        controller.setView(view);
        controller.start();
    }
}
