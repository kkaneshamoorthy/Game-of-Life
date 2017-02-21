package bbc.codingtests.gameoflife.gamestate;

import bbc.codingtests.gameoflife.life.Life;
import bbc.codingtests.gameoflife.life.LifeImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedLifeTest {
    private String input;
    private String expectedOutput;

    public ParameterizedLifeTest(String input, String expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection inputData() {
        return Arrays.asList( new Object[][] {
                {		"....*....\n" +
                        "....*....\n" +
                        "....*....\n" +
                        "....*....\n" +
                        "....*....\n" +
                        "....*....\n" +
                        "....*....\n" +
                        "....*....",

                        ".........\n" +
                        "...***...\n" +
                        "...***...\n" +
                        "...***...\n" +
                        "...***...\n" +
                        "...***...\n" +
                        "...***...\n" +
                        "........."
                },
                {
                        "...\n" +
                        "***\n" +
                        "...",

                        ".*.\n" +
                        ".*.\n" +
                        ".*."
                },
                {
                        "..........\n" +
                        "..........\n" +
                        "****......\n" +
                        "...*......\n" +
                        "...*......",

                        "..........\n" +
                        ".**.......\n" +
                        ".***......\n" +
                        ".*.**.....\n" +
                        ".........."
                }
        });
    }

    @Test
    public void testParameterizedInputs() {
        Life testLife = new LifeImpl();
        GameState gameState = new GameStateImpl(this.input);
        GameState evolvedState = testLife.evolve(gameState);
        assertEquals("The game state after evolve should be different", this.expectedOutput, evolvedState.toString());
    }
}