package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import bbc.codingtests.gameoflife.life.Life;
import bbc.codingtests.gameoflife.life.LifeImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LifeTest {

	//TODO make this test pass
	@Test
	public void testEmptyGrid() {
		String emptyStateInput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		assertEquals("An empty grid should stay the same", emptyStateInput, testLife.evolve(emptyState).toString());
	}

	@Test
	//TODO implement further tests for the other cases in the instructions
	public void testScenario0_noLiveCell_returnsNoLiveCells() {
		String deadcells = "...\n...\n...";
		String expectedOutput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState deadCellState = new GameStateImpl(deadcells);
		assertEquals("No live cells should evolves to a game state with no live cells", expectedOutput, testLife.evolve(deadCellState).toString());
	}

	@Test
	public void testScenario1_underpopulation() {
		String underPopulationInput = "*.*\n...\n...";
		String expectedOutput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState underPopulationState = new GameStateImpl(underPopulationInput);
		assertEquals("Underpopulation grid should lead to dead cell", expectedOutput, testLife.evolve(underPopulationState).toString());
	}

	@Test
	public void testScenario6() {
		String input = "...\n***\n...";
		String expectedOutput = ".*.\n.*.\n.*.";

		Life testLife = new LifeImpl();
		GameState gameState = new GameStateImpl(input);
		assertEquals("", expectedOutput, testLife.evolve(gameState).toString());
	}

	@Test
	public void testEvolve() {
		String underPopulationInput = "..........\n" +
				                      "..........\n" +
									  "****......\n" +
									  "...*......\n" +
									  "...*......";

		String expectedOutput = "..........\n" +
								".**.......\n" +
								".***......\n" +
								".*.**.....\n" +
								"..........";

		Life testLife = new LifeImpl();
		GameState overPopulationState = new GameStateImpl(underPopulationInput);
		assertEquals("Test", expectedOutput, testLife.evolve(overPopulationState).toString());
	}

	@Test
	public void testNullGameStateImpl() {
		Life testLife = new LifeImpl();
		GameState nullState = null;
		assertEquals("Over Population grid should lead to dead cell", null, testLife.evolve(nullState));
	}
}
