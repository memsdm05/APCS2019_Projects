package Unit1.RomanNumeral;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * The type Roman to decimal test.
 */
public class RomanToDecimalTest {

    /**
     * Test roman to decimal.
     */
    @Test
    public void testRomanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("i"), 1);
        assertEquals(RomanToDecimal.romanToDecimal("I"), 1);
        assertEquals(RomanToDecimal.romanToDecimal("ix"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("xxx"), 30);
        assertEquals(RomanToDecimal.romanToDecimal("XXX"), 30);
        assertEquals(RomanToDecimal.romanToDecimal("c"), 100);
        assertEquals(RomanToDecimal.romanToDecimal("C"), 100);
        assertEquals(RomanToDecimal.romanToDecimal("MMMCMXCII"), 3992);
        assertEquals(RomanToDecimal.romanToDecimal("MMMCMLXXI"), 3971);

        assertEquals(RomanToDecimal.romanToDecimal("IVCLCDIXXCC"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("xlcmlxxlii"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("IXXCCMCMCMIX"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("cmivxccdcixcmcm"), -1);

        assertEquals(RomanToDecimal.romanToDecimal("8S,OP!cqWrjP.`t"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("@ANV$}@z"), -1);
        assertEquals(RomanToDecimal.romanToDecimal(";xhV~pDOI>1`k"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("Ztvkr'e33VC^y29"), -1);

        assertNotEquals(RomanToDecimal.romanToDecimal("Hehe_funnynumbers"), 42069);
        assertNotEquals(RomanToDecimal.romanToDecimal("Its 10:00 monday and im really tired why did i spend so much time optimising the code ahhhh"), 101010101);



    }
}