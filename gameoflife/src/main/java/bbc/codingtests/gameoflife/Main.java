package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

public class Main {
    public static void main(String[] args) {
        String input = "........."+
                "\n........." +
                "\n........." +
                "\n........." +
                "\n........." +
                "\n........." +
                "\n........." +
                "\n.........";

        GameStateImpl gameState = new GameStateImpl(input);
    }
}
