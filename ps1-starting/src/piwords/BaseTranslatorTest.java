package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseTranslatorTest {
    @Test
    public void basicBaseTranslatorTest() {
        // Middle Cases
        int[] input = {0, 1};
        int[] expectedOutput = {2, 5};
        assertArrayEquals(expectedOutput,
                          BaseTranslator.convertBase(input, 2, 10, 2));
        
        int[] input2 = {0, 0, 1, 0, 1};
        int[] expectedOutput2 = {1, 5, 6, 2, 5};
        assertArrayEquals(expectedOutput2, BaseTranslator.convertBase(input2, 2, 10, 5));
        
        
        //Invalid cases
        int[] input3 = {0, 1, 3, -3};
        assertNull(BaseTranslator.convertBase(input3, 5, 10, 2));
        int[] input4 = {0, 1, 11, 3};
        assertNull(BaseTranslator.convertBase(input4, 10, 2, 2));
        assertNull(BaseTranslator.convertBase(input, 1, 2, 2));
        assertNull(BaseTranslator.convertBase(input, 2, 1, 2));
        assertNull(BaseTranslator.convertBase(input, 2, 1, 0));
    }


}
