package org.kholod.games.tictactoe.model;

/**
 * Contains enumeration of possible signs for game
 */
public enum Sign {
    NOTHING("."),
    CROSS("X"),
    ZERO("0");

    private String view;

    Sign(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
