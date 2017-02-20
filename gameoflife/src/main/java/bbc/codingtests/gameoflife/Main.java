package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import bbc.codingtests.gameoflife.life.Life;
import bbc.codingtests.gameoflife.life.LifeImpl;

public class Main {
    public static void main(String[] args) {
        String input =
                "................*..\n" +
                "..............*.*..\n" +
                "....**......**.....\n" +
                "...*...*....**.....\n" +
                "..*.....*...**.....\n" +
                "..*...*.***...*.*..\n" +
                "..*.....*.......*..\n" +
                "...*...*...........\n" +
                "....**.............\n";

        evolve(input);
    }

    public static void evolve(String input) {
        GameState gameState = new GameStateImpl(input);
        Life life = new LifeImpl();

        int i = 0;

        while(i != 50) {
            GameState evolvedState = life.evolve(gameState);
            System.out.println(evolvedState.toString());
            System.out.println("===================");

            gameState = evolvedState;
            i++;
        }
    }
}
