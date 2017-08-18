package org.kholod.games.tictactoe.model;

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
