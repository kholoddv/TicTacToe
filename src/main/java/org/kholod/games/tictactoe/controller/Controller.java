package org.kholod.games.tictactoe.controller;

import org.kholod.games.tictactoe.model.Game;
import org.kholod.games.tictactoe.view.View;

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

    public static void main(String[] args) {
        Controller controller = new Controller();
        Game game = new Game(controller);
        View view = new View(controller);
        controller.setGame(game);
        controller.setView(view);
        controller.start();
    }
}
