package bbc.codingtests.gameoflife.cell;

/**
 * Created by kowrishankar on 17/02/17.
 * The purpose of the class is to store information about a cell
 * Class means easy to maintain and future proof - as any additional data can easily be stored
 */
public class CellImpl implements Cell {
    private boolean isAlive = false;
    private int row;
    private int col;

    public CellImpl(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public CellImpl(int row, int col, boolean cellStatus) {
        this(row, col);
        this.setStatus(cellStatus);
    }

    /***
     * Returns the row number
     * @return
     */
    public int getRow() {
        return this.row;
    }

    /***
     * Returns the column number
     * @return
     */
    public int getCol() {
        return this.col;
    }

    /***
     * Returns whether the cell is alive or dead
     * @return
     */
    public boolean isAlive() {
        return this.isAlive;
    }

    /***
     * Sets the cell status - whether alive or dead
     * @param isAlive
     */
    public void setStatus(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
