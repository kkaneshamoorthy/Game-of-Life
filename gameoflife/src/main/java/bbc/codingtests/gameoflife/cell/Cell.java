package bbc.codingtests.gameoflife.cell;

public interface Cell {
    /***
     * @return the row the cell is at
     */
    int getRow();

    /***
     * @return the column the cell is at
     */
    int getCol();

    /***
     * @return whether the cell is alive or not
     */
    boolean isAlive();

    /***
     * set the status of the cell - alive (true) or dead (false)
     * @param isAlive
     */
    void setStatus(boolean isAlive);
}
