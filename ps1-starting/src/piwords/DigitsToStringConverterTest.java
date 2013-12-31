package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest {
    @Test
    public void basicNumberSerializerTest() {
        // Input is a 4 digit number, 0.123 represented in base 4
        int[] input = {0, 1, 2, 3};

        // Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
        char[] alphabet = {'d', 'c', 'b', 'a'};

        String expectedOutput = "dcba";
        assertEquals(expectedOutput,
                     DigitsToStringConverter.convertDigitsToString(
                             input, 4, alphabet));
    }

    @Test
    public void nullNumberSerializerTest() {
    	char[] alphabet = {'d', 'c', 'b', 'a'};    	     
        
        // digit > base
    	int[] input1 = {0, 1, 2, 6};
        assertNull(DigitsToStringConverter.convertDigitsToString(input1, 4, alphabet));
        
        // digit < 0
        int[] input2 = {0, -3, 2, 3};        
        assertNull(DigitsToStringConverter.convertDigitsToString(input2, 4, alphabet));
        
        // alphabet.length != base
        int[] input3 = {0, 3, 2, 3};
        assertNull(DigitsToStringConverter.convertDigitsToString(input3, 5, alphabet));       
        
    }
    
    @Test
    public void edgeNumberSerializerTest() {
    	// Beginning and end of character map/base
    	int[] input1 = {0, 3, 5, 6, 7, 7};
    	char[] alphabet1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
    	assertEquals("adfghh", DigitsToStringConverter.convertDigitsToString(input1, 8, alphabet1));
    	
    	// No digits
    	int[] input2 = {};
    	assertEquals("", DigitsToStringConverter.convertDigitsToString(input2, 8, alphabet1));
    	
    }
}
