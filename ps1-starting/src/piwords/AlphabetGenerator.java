package piwords; 
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AlphabetGenerator {
	/**
	 * Given a numeric base, return a char[] that maps every digit that is
	 * representable in that base to a lower-case char.
	 * 
	 * This method will try to weight each character of the alphabet
	 * proportional to their occurrence in words in a training set.
	 * 
	 * This method should do the following to generate an alphabet:
	 *   1. Count the occurrence of each character a-z in trainingData.
	 *   2. Compute the probability of each character a-z by taking
	 *      (occurrence / total_num_characters).
	 *   3. The output generated in step (2) is a PDF of the characters in the
	 *      training set. Convert this PDF into a CDF for each character.
	 *   4. Multiply the CDF value of each character by the base we are
	 *      converting into.
	 *   5. For each index 0 <= i < base,
	 *      output[i] = (the first character whose CDF * base is > i)
	 * 
	 * A concrete example:
	 * 	 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
	 *               "ccccc..." (198 "c"s)}, base = 93	
	 *   1. Count(a) = 302, Count(b) = 500, Count(c) = 193
	 *   2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
	 *      Pr(c) = 198 / 1000 = .198
	 *   3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
	 *   4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
	 *   5. Output = {"a", "a", ... (28 As, indexes 0-27),
	 *                "b", "b", ... (47 Bs, indexes 28-74),
	 *                "c", "c", ... (18 Cs, indexes 75-92)}
	 * 
	 * The letters should occur in lexicographically ascending order in the
	 * returned array.
	 *   - {"a", "b", "c", "c", "d"} is a valid output.
	 *   - {"b", "c", "c", "d", "a"} is not.
	 *   
	 * If base >= 0, the returned array should have length equal to the size of
	 * the base.
	 * 
	 * If base < 0, return null.
	 * 
	 * If a String of trainingData has any characters outside the range a-z,
	 * ignore those characters and continue.
	 * 
	 * @param base A numeric base to get an alphabet for.
	 * @param trainingData The training data from which to generate frequency
	 *                     counts. This array is not mutated.
	 * @return A char[] that maps every digit of the base to a char that the
	 *         digit should be translated into.
	 */
	public static char[] generateFrequencyAlphabet(int base, String[] trainingData) {
		if (base < 0) { return null; }
		Map<Character, Double> fullCDFMap = createCDFMapFromPDF(
				findProbabilities(createMapOfCharacters(trainingData), countCharacters(trainingData)), base);
		char[] charMap = new char[base];
		int elementCounter = 0;
		for (Map.Entry<Character, Double> entry : fullCDFMap.entrySet()) {
			for (int i = elementCounter; i < (int)(entry.getValue() + 0.0000001); i++) {
				charMap[i] = entry.getKey();
			}
			elementCounter = entry.getValue().intValue();
		}
		return charMap;
	}
	public static Map<Character, Integer> createMapOfCharacters(String[] stringsToCount) {
		Map<Character, Integer> countedChars = new HashMap<Character, Integer>();
		char testChar;
		for (int i = 0; i < stringsToCount.length; i++) {
			for (int k = 0; k < stringsToCount[i].length(); k++) {
				testChar = Character.toLowerCase(stringsToCount[i].charAt(k));
				if (Character.isAlphabetic(testChar)) {
					if (countedChars.get(testChar) == null) {
						countedChars.put(testChar, 1);
					}
					else {
						countedChars.put(testChar, countedChars.get(testChar)+1);
					}
				}
			}
		}
		return countedChars;
	}
	public static int countCharacters(String[] uncountedStrings) {
		char testChar;
		int count = 0;
		for (int i = 0; i < uncountedStrings.length; i++) {
			for (int k = 0; k < uncountedStrings[i].length(); k++) {
				testChar = uncountedStrings[i].charAt(k);
				if (Character.isAlphabetic(testChar)) {
					count++;
				}
			}
		}
		return count;
	}
	
		
	public static Map<Character, Double> findProbabilities(Map<Character, Integer> charOccurences, int totalCount) {
		Map<Character, Double> charProbabilities = new HashMap<Character, Double>();
		double count = (double)totalCount;
		for (Map.Entry<Character, Integer> entry : charOccurences.entrySet()) {
			charProbabilities.put(entry.getKey(), (double)entry.getValue()/count);
		}
		return charProbabilities;
	}
	
	public static Map<Character, Double> createCDFMapFromPDF(Map<Character, Double> pdfMap, int base) {
		Map<Character, Double> cdfMap = new TreeMap<Character, Double>(pdfMap);
		double runningProbability = 0;
		double holdingValue;
		for (Map.Entry<Character, Double> entry : cdfMap.entrySet()) {
			holdingValue = entry.getValue();
			entry.setValue((holdingValue+runningProbability)*base);
			runningProbability += holdingValue;
		}
		return cdfMap;
	}	
}
	
