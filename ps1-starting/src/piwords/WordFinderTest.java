package piwords;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordFinderTest {
    @Test
    public void basicGetSubstringsTest() {
        String haystack = "abcde";
        String[] needles = {"ab", "abc", "de", "fg"};

        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 0);
        expectedOutput.put("abc", 0);
        expectedOutput.put("de", 3);
        

        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                                                              needles));
    }
    
    @Test
    public void edgeTestOneCharAtBeginningMidEnd() {
    	String haystack = "abcde";
    	String[] needles = {"a", "c", "e"};
    	
    	Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
    	expectedOutput.put("a", 0);
    	expectedOutput.put("c", 2);
    	expectedOutput.put("e", 4);
    	
    	assertEquals(expectedOutput, WordFinder.getSubstrings(haystack, needles));
    }
    
    @Test
    public void edgeTestNeedleIsEntireHaystack() {
    	String haystack = "jklmno";
    	String[] needles = {"jklmno"};
    	
    	Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
    	expectedOutput.put("jklmno", 0);
    	
    	assertEquals(expectedOutput, WordFinder.getSubstrings(haystack, needles));
    }
    
    public void testNoNeedlesInHaystack() {
    	String haystack = "pqrtstuv";
    	String[] needles = {"ab", "hjk", "wxz"};
    	
    	Map<String, Integer> expectedOutput = new HashMap<String, Integer>();    	 	
    	assertEquals(expectedOutput, WordFinder.getSubstrings(haystack, needles));

    }
    
    public void testNeedleLargerThanHaystack() {
    	String haystack = "wxyz";
    	String[] needles = {"wx", "tuvwxyz"};
    	
    	Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
    	expectedOutput.put("wx", 0);
    	assertEquals(expectedOutput, WordFinder.getSubstrings(haystack, needles));
    }
}
