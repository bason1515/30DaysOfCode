import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryRegexpTest {

    @Test
    public void testSimple() {
        assertFalse(BinaryRegexp.multipleOf3().matcher(" 0").matches());
        assertFalse(BinaryRegexp.multipleOf3().matcher("abc").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("000").matches());

        assertTrue(BinaryRegexp.multipleOf3().matcher("00011").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("00110").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("001001").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("001100").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("001111").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("010010").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("010101").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("011000").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("011011").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("011110").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("100100").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher("100111").matches());
        assertFalse(BinaryRegexp.multipleOf3().matcher("111").matches());
        assertTrue(BinaryRegexp.multipleOf3().matcher(Integer.toBinaryString(12345678)).matches());
    }

}