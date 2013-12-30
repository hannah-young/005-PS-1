package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {
    @Test
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));
        // 1^1 mod 1 = 1
        assertEquals(4, PiGenerator.powerMod(4, 7, 5));
        assertEquals(0, PiGenerator.powerMod(1, 1, 1));
        // 1^60 mod 1 = 60
        assertEquals(0, PiGenerator.powerMod(1, 60, 1));
        // 1^1 mod 50 = 1
        assertEquals(1, PiGenerator.powerMod(1, 1, 50));
        // 1^60 mod 50 = 1
        assertEquals(1, PiGenerator.powerMod(1, 60, 50));
        // 70^1 mod 1 = 70
        assertEquals(0, PiGenerator.powerMod(70, 1, 1));
        // 12^8 mod 1 = 0
        assertEquals(0, PiGenerator.powerMod(12, 8, 1));
        // 70^1 mod 50 = 20
        assertEquals(20, PiGenerator.powerMod(70, 1, 50));
        // 0^60 mod 50 = invalid
        assertEquals(-1, PiGenerator.powerMod(0, 60, 50));
        // 0^60 mod 50 = invalid
        assertEquals(-1, PiGenerator.powerMod(70, 0, 50));
        // 70^0 mod 50 = invalid
        assertEquals(-1, PiGenerator.powerMod(70, 60, 0));
        // 70^60 mod 0 = invalid
        assertEquals(-1, PiGenerator.powerMod(0, 0, 0));
        // 0^0 mod 0 = invalid
        }
    
    @Test
    public void computePiIntoHexTest() {
    	//assertEquals()
    	for (int i = 0; i < 5; ++i) {
    		System.out.println(PiGenerator.piDigit(i));
    	}    	
    	
    }

}
