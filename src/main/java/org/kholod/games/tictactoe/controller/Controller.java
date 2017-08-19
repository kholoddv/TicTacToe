package org.kholod.games.tictactoe.controller;

import org.kholod.games.tictactoe.model.Game;
import org.kholod.games.tictactoe.view.View;

/**
 * Starts and manages the game
 */
public class Controller {
    private View view;
    private Game game;

    public View getView() {
        return view;
    }

    public Game getGame() {
        return game;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Starts the game and executes game steps while it isn't over
     */
    public void start() {
        game.start();
        while (!game.isGameOver()) {
            game.step();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
