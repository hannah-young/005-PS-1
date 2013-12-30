package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {
    @Test
    public void basicPowerModTest() {              
        // Edge cases (near 0 for a or b, near 1 for m)
        assertEquals(0, PiGenerator.powerMod(0, 0, 1));
        assertEquals(0, PiGenerator.powerMod(1, 0, 1));
        assertEquals(0, PiGenerator.powerMod(1, 1, 1));
        assertEquals(1, PiGenerator.powerMod(1, 1, 3));
        assertEquals(0, PiGenerator.powerMod(1, 2, 1));
        
        // Edge cases where a or b is near 0, but the other is a middle case
        assertEquals(0, PiGenerator.powerMod(0, 25, 3));
        assertEquals(1, PiGenerator.powerMod(25, 0, 3));        
        
        // Middle Cases
        assertEquals(4, PiGenerator.powerMod(2, 4, 6));
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));

        // Invalid cases
        assertEquals(-1, PiGenerator.powerMod(0, 0, 0));
        assertEquals(-1, PiGenerator.powerMod(-1, 60, 0));
        assertEquals(-1, PiGenerator.powerMod(70, -1, 0));
        }
    
    @Test
    public void computePiIntoHexTest() {
    	// Edge Cases
    	int[] testArray = new int[0];
    	assertArrayEquals(testArray, PiGenerator.computePiInHex(0));
    	testArray = new int[1];
    	testArray[0] = 2;
    	assertArrayEquals(testArray, PiGenerator.computePiInHex(1));
    	
    	// Middle cases
    	testArray = new int[4];
    	testArray[0] = 2; testArray[1] = 4; testArray[2] = 3; testArray[3] = 15; 
    	assertArrayEquals(testArray, PiGenerator.computePiInHex(4));

    	// Invalid cases
    	assertNull(PiGenerator.computePiInHex(-1));
    	
    }

}
