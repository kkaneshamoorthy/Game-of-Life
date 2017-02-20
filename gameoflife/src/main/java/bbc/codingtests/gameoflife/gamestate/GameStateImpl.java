package bbc.codingtests.gameoflife.gamestate;

import bbc.codingtests.gameoflife.cell.CellImpl;

/***
 * Author: BBC & Kowrishankar
 * Date: 13/02/2017
 */
public class GameStateImpl implements GameState {

    private CellImpl[][] grid;

    public GameStateImpl(String input) {
        this.grid = parseInput(input);
    }

    public GameStateImpl(int row, int col) {
        this.grid = new CellImpl[row][col];
    }

    /***
     * Returns whether a cell is alive or dead
     * @param row
     * @param col
     * @return
     */
    public boolean isCellAliveAt(int row, int col) {
        if ((row < this.getRows() && row >= 0) && (col < this.getCols() && col >= 0)) //is within the grid
            return this.grid[row][col].isAlive();

        //Assumption: if the row or col is outside of the grid -> return false
        return false;
    }

    /***
     * Should an Alive cell (row, col) live
     * @param row
     * @param col
     * @return
     */
    public boolean shouldAliveCellLive(int row, int col) {
        int numOfliveNeighbours = countAliveNeighbours(row, col);

        return (this.isCellAliveAt(row, col) && (numOfliveNeighbours == 2 || numOfliveNeighbours == 3));
    }

    /***
     * Should a dead cell(row, col) be revived
     * @param row
     * @param col
     * @return
     */
    public boolean shouldDeadCellLive(int row, int col) {
        int numOfliveNeighbours = countAliveNeighbours(row, col);

        return (!this.isCellAliveAt(row, col) && numOfliveNeighbours == 3);
    }

    /***
     * Count the number of alive neighbours
     * @param row
     * @param col
     * @return
     */
    public int countAliveNeighbours(int row, int col) {
        //Calculating the 8 neighbours (row, col) =>  (x,y)
        // ------------------------------
        // | x-1,y-1 | x-1,y | x-1,y+1 |
        // ------------------------------
        // | x,y-1   | x,y   | x+1,y+1 |
        // ------------------------------
        // | x+1,y-1 | x+1,y | x+1,y+1 |
        // ------------------------------
        int numOfLiveNeighbours = 0;

        if (isCellAliveAt(row-1, col-1))   ++numOfLiveNeighbours;
        if (isCellAliveAt(row, col-1))     ++numOfLiveNeighbours;
        if (isCellAliveAt(row+1, col-1))   ++numOfLiveNeighbours;
        if (isCellAliveAt(row-1, col))     ++numOfLiveNeighbours;
        if (isCellAliveAt(row+1, col))     ++numOfLiveNeighbours;
        if (isCellAliveAt(row-1, col+1))   ++numOfLiveNeighbours;
        if (isCellAliveAt(row, col+1))     ++numOfLiveNeighbours;
        if (isCellAliveAt(row+1, col+1))   ++numOfLiveNeighbours;

        return numOfLiveNeighbours;
    }

    /***
     * Return the number of rows
     * @return
     */
    public int getRows() {
        return this.grid.length;
    }

    /***
     * Returns the number of cols
     * @return
     */
    public int getCols() {
        if (this.getRows() <= 0) return 0;

        //Assumption: Every row has the same number of columns
        return this.grid[0].length;
    }

    /***
     * Changes the cell referenced by row and col
     * @param row
     * @param col
     * @param isAlive
     */
    public void setData(int row, int col, boolean isAlive) {
        if (this.grid[row][col] == null) {
            this.grid[row][col] = new CellImpl(row, col, isAlive);
            return;
        }

        this.grid[row][col].setStatus(isAlive);
    }

    /***
     * Generates a string form of the game state
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder gameInStr = new StringBuilder();
        int row = this.getRows();
        int col = this.getCols();

        for (int i=0; i<row; i++) {
            for (int j = 0; j<col; j++)
                if (this.grid[i][j].isAlive())
                    gameInStr.append("*");
                else
                    gameInStr.append(".");

            if (i != this.grid.length-1) gameInStr.append("\n");
        }

        return gameInStr.toString();
    }

    /***
     * Generates a grid given string form
     * @param input String
     */
    private CellImpl[][] parseInput(String input) {
        String[] data = input.split("\n");
        int row = data.length;
        int col = data[0].length();
        CellImpl[][] grid = new CellImpl[row][col];

        for (int i=0; i<row; i++) {
            String rowData = data[i];
            for (int j=0; j<col; j++) {
                char cellData = rowData.charAt(j);
                //Assumption: if the input is not *, then its a dead cell
                if (cellData == '*')
                    grid[i][j] = new CellImpl(i, j, true);
                else
                    grid[i][j] = new CellImpl(i, j, false);
            }
        }

        return grid;
    }
}
