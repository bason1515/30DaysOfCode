import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScreenLockTest {
    ScreenLock sl = new ScreenLock();

    @Test
    public void testForLength2 () {
        assertEquals(5, sl.calculateCombinations('C',2));
        assertEquals(7, sl.calculateCombinations('H',2));
        assertEquals(8, sl.calculateCombinations('E',2));
    }

    @Test
    public void testForLength3 () {
        assertEquals(31, sl.calculateCombinations('C',3));
        assertEquals(37, sl.calculateCombinations('H',3));
        assertEquals(48, sl.calculateCombinations('E',3));
    }

    @Test
    public void testForLength4 () {
        assertEquals(256, sl.calculateCombinations('E',4));
    }

    @Test
    public void validAndroidPattern () {
        int sum = 0;
        for (int i = 4; i <= 9; i++) {
            for (char c = 'A'; c <= 'I'; c++) {
                sum += sl.calculateCombinations(c, i);
            }
        }
        assertEquals(389112, sum);
    }
}