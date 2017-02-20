package bbc.codingtests.gameoflife.life;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

public class LifeImpl implements Life
{
	/***
	 * Evolve implementation for GameState
	 * @param currentState
	 * @return
	 */
	public GameState evolve(GameState currentState) {
		if (currentState == null)
			return currentState;

		GameState nextGameState = new GameStateImpl(currentState.getRows(), currentState.getCols());

		for (int i=0; i<currentState.getRows(); i++) {
			for (int j=0; j<currentState.getCols(); j++) {
				if (shouldAliveCellLive(currentState, i, j))
					nextGameState.setCellStatus(i, j, true);
				else
					nextGameState.setCellStatus(i, j, false);

				if (shouldDeadCellLive(currentState, i ,j))
					nextGameState.setCellStatus(i, j, true);
			}
		}

		return nextGameState;
	}

	/***
	 * Should an Alive cell (row, col) live
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean shouldAliveCellLive(GameState gameState, int row, int col) {
		int numOfliveNeighbours = gameState.getNumOfAliveNeighbours(row, col);

		return (gameState.isCellAliveAt(row, col) && (numOfliveNeighbours == 2 || numOfliveNeighbours == 3));
	}

	/***
	 * Should a dead cell(row, col) be revived
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean shouldDeadCellLive(GameState gameState, int row, int col) {
		int numOfliveNeighbours = gameState.getNumOfAliveNeighbours(row, col);

		return (!gameState.isCellAliveAt(row, col) && numOfliveNeighbours == 3);
	}
}
