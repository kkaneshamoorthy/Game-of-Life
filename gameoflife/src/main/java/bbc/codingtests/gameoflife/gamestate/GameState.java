package bbc.codingtests.gameoflife.gamestate;

//Assumption: the GameState interface can be modified
public interface GameState {
    /**
     * Whether the cell at the given row and column is alive or not
     * Should return false if the coordinates are outside the grid
     * @param row
     * @param col
     * @return
     */
    boolean isCellAliveAt(int row, int col);

    /***
     * @param row
     * @param col
     * @return the number of alive neighbours
     */
    int getNumOfAliveNeighbours(int row, int col);

    /***
     * Sets whether a cell should be alive or dead
     * @param row
     * @param col
     * @param isAlive
     */
    void setCellStatus(int row, int col, boolean isAlive);

    /**
     * @return Number of rows the game has
     */
    int getRows();

    /**
     * @return Number of columns the game has
     */
    int getCols();
}
