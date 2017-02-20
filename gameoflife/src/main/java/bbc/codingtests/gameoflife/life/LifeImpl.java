package bbc.codingtests.gameoflife.life;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import bbc.codingtests.gameoflife.life.Life;

public class LifeImpl implements Life
{
	/***
	 * Evolve implementation for GameState
	 * @param currentState
	 * @return
	 */
	public GameState evolve(GameState currentState) {
		//Assumption: In the future there maybe different implementation of GameState
		//Assumption: the GameState interface can not be modified
		if (currentState == null)
			return currentState;
		else if (currentState instanceof GameStateImpl)
			return evolve((GameStateImpl) currentState);
		else
			throw new UnsupportedOperationException("Provide an implementation for the given GameState type");
	}

	/***
	 * Evolve implementation for GameStateImpl
	 * @param currentGameState
	 * @return
	 */
	private GameState evolve(GameStateImpl currentGameState) {
		GameStateImpl nextGameState = new GameStateImpl(currentGameState.getRows(), currentGameState.getCols());

		for (int i=0; i<currentGameState.getRows(); i++) {
			for (int j=0; j<currentGameState.getCols(); j++) {
				if (currentGameState.shouldAliveCellLive(i, j))
					nextGameState.setData(i, j, true);
				else
					nextGameState.setData(i, j, false);

				if (currentGameState.shouldDeadCellLive(i ,j))
					nextGameState.setData(i, j, true);
			}
		}

		return nextGameState;
	}
}
