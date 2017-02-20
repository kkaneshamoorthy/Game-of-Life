package bbc.codingtests.gameoflife.gamestate;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void testParsing() {
        String input = ".*.\n*.*\n...";
        GameState testState = new GameStateImpl(input);
        assertTrue("Row 0, col 1 should be alive",testState.isCellAliveAt(0,1));
        assertFalse("Row 2, col 2 should not be alive",testState.isCellAliveAt(2,2));
    }

    @Test
    public void testParsingFromStringGrid() {
        String input = "***\n...";
        GameStateImpl testState = new GameStateImpl(input);
        assertEquals("The number of row should be 2", 2, testState.getRows());
        assertEquals("The number of column should be 3", 3, testState.getCols());
        assertEquals("The output should equal to the input", input, testState.toString());
    }

    @Test
    public void testToString() {
        String input = "...\n***\n..*";
        GameState testState = new GameStateImpl(input);
        assertEquals("The output should equal to the input", input, testState.toString());
    }

    @Test
    public void testNighbourCount() {
        String input = ".*.\n...\n...";
        GameStateImpl testState = new GameStateImpl(input);
        assertEquals("The output should equal to the input", 1, testState.countAliveNeighbours(0, 0));
    }
}
