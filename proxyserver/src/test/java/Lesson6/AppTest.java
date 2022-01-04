package Lesson6;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void firstBigger()
    {
        assertEquals(5, App.findMax(5, 2) );
    }
    @Test
    public void firstMax()
    {
        assertEquals(5, App.findMax(4, 2) );
    }
    @Test
    public void firstEquels()
    {
        assertEquals(5, App.findMax(5, 2) );
    }
}
