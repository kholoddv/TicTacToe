package org.kholod.games.tictactoe.model;

import org.junit.Before;
import org.junit.Test;
import org.kholod.games.tictactoe.controller.Controller;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void init() {
        Controller controller = new Controller();
        game = new Game(controller);
    }

    @Test
    public void check_InitialField_GameOverFalse() throws Exception {
        //Arrange
        Player player = new Player(Sign.CROSS, "PlayerX", game);
        Sign[][] field = new Sign[][]{
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING},
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING},
                {Sign.NOTHING, Sign.NOTHING, Sign.NOTHING}
        };
        game.setField(field);

        //Act
        game.check(player);

        //Assert
        assertFalse(game.isGameOver());
    }

    @Test
    public void check_ZeroWon_GameOverTrue() throws Exception {
        //Arrange
        Player player = new Player(Sign.ZERO, "Player0", game);
        Sign[][] field = new Sign[][]{
                {Sign.CROSS, Sign.NOTHING, Sign.ZERO},
                {Sign.CROSS, Sign.ZERO, Sign.NOTHING},
                {Sign.ZERO, Sign.NOTHING, Sign.CROSS}
        };
        game.setField(field);

        //Act
        game.check(player);

        //Assert
        assertTrue(game.isGameOver());
    }

    @Test
    public void check_endedInADraw_GameOverTrue() throws Exception {
        //Arrange
        Player player = new Player(Sign.ZERO, "Player0", game);
        Sign[][] field = new Sign[][]{
                {Sign.CROSS, Sign.ZERO, Sign.CROSS},
                {Sign.CROSS, Sign.ZERO, Sign.ZERO},
                {Sign.ZERO, Sign.CROSS, Sign.CROSS}
        };
        game.setField(field);

        //Act
        game.check(player);

        //Assert
        assertTrue(game.isGameOver());
    }
}