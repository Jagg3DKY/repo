import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testPlot() {
        Plot plot = new Plot();
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
    }

    @Test
    void testPlotIntIntIntInt() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(4, plot.getWidth());
        assertEquals(5, plot.getDepth());
    }

    @Test
    void testPlotPlot() {
        Plot originalPlot = new Plot(2, 3, 4, 5);
        Plot copiedPlot = new Plot(originalPlot);
        assertEquals(originalPlot.getX(), copiedPlot.getX());
        assertEquals(originalPlot.getY(), copiedPlot.getY());
        assertEquals(originalPlot.getWidth(), copiedPlot.getWidth());
        assertEquals(originalPlot.getDepth(), copiedPlot.getDepth());
    }

    @Test
    void testOverlaps() {
        Plot plot1 = new Plot(0, 0, 4, 4);
        Plot plot2 = new Plot(2, 2, 4, 4);
        Plot plot3 = new Plot(5, 5, 2, 2);

        assertTrue(plot1.overlaps(plot2));
        assertFalse(plot1.overlaps(plot3));
    }

    @Test
    void testEncompasses() {
        Plot plot1 = new Plot(0, 0, 5, 5);
        Plot plot2 = new Plot(1, 1, 3, 3);
        Plot plot3 = new Plot(2, 2, 6, 6);

        assertTrue(plot1.encompasses(plot2));
        assertFalse(plot1.encompasses(plot3));
    }

    @Test
    void testToString() {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals("2,3,4,5", plot.toString());
    }
}
