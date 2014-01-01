package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlphabetGeneratorTest {
    @Test
    public void generateFrequencyAlphabetTest() {
        // Expect in the training data that Pr(a) = 2/5, Pr(b) = 2/5,
        // Pr(c) = 1/5.
        String[] trainingData = {"aa", "bbc"};
        // In the output for base 10, they should be in the same proportion.
        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, trainingData));        
    }
    @Test
    public void testOnlyOneCharacter() {
    	String[] trainingData = {"a", "aa", "aaa", "a", "aa"};
    	char[] expectedOutput = {'a', 'a', 'a', 'a', 'a'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        5, trainingData));        
    }
    @Test
    public void testEqualProbabilityAmongstCharacters() {
    	String[] trainingData = {"abc", "cba", "bca", "aaa", "bbb", "ccc"};
    	char[] expectedOutput = {'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, trainingData));        
    }
    @Test
    public void testBaseInvalid() {
    	String[] trainingData = {"abc", "cba", "bca", "aaa", "bbb", "ccc"};
    	assertNull(AlphabetGenerator.generateFrequencyAlphabet(-1, trainingData));
    }
    @Test
    public void testCharsInTrainingOutsideAtoZ() {
    	String[] trainingData = {"abc1", "1cba", "bc1a", "111aaa", "bbb", "ccc", "#1$"};
    	char[] expectedOutput = {'a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, trainingData));   
    }
    @Test
    public void testOnlyOneCharacterStringsInTraining() {
    	String[] trainingData = {"d", "c", "e", "c", "f", "g", "e"};
    	char[] expectedOutput = {'c', 'c', 'd', 'e', 'e', 'f', 'g', 'g'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        8, trainingData));   
    }
    @Test
    public void testBaseZero() {
    	String[] trainingData = {"abc", "cba", "bca", "aaa", "bbb", "ccc"};
    	char[] expectedOutput = {};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        0, trainingData)); 
    }
}
