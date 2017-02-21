package bbc.codingtests.gameoflife.cell;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CellTest {

    @Test
    public void test_isAlive() {
        Cell deadCell = new CellImpl(0 ,1, false);
        Cell liveCell = new CellImpl(0 ,2, true);

        assertEquals("The cell must be dead", false, deadCell.isAlive());
        assertEquals("The cell must be live", true, liveCell.isAlive());
    }

    @Test
    public void test_setStatus() {
        Cell deadCell = new CellImpl(0 ,1, false);
        assertEquals("The cell must be dead", false, deadCell.isAlive());
        deadCell.setStatus(true);
        assertEquals("The cell must be live", true, deadCell.isAlive());
    }
}
