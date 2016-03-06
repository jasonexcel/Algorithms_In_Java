package basicAlgorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean wordPatternI(String pattern, String str) {
        if(pattern == null && str == null  || pattern.isEmpty() && str.isEmpty()) {
            return true;
        }
        if(pattern == null || str == null) {
            return false;
        }
        if(pattern.isEmpty() || str.isEmpty()) {
            return false;
        }
        String[] arr = str.split(" ");
        if(pattern.length() != arr.length) {
            return false;
        }
        Map<Character, String> matchL = new HashMap<Character, String>();
        Set<String> matchR = new HashSet<String>();
        for(int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            String word = arr[i];
            if(!matchL.containsKey(letter) && !matchR.contains(word)) {
                matchL.put(letter, word);
                matchR.add(word);
            } else if(matchL.containsKey(letter) && matchR.contains(word)) {
                if( !matchL.get(letter).equals(word)) {
                    return false;
                }
            } else {
                return false;
            }
            
        }
        return true;
    }
    
	public boolean wordPattern(String pattern, String str) {
        if(pattern == null && str == null  || pattern.isEmpty() && str.isEmpty()) {
            return true;
        }
        if(pattern == null || str == null) {
            return false;
        }
        if(pattern.isEmpty() || str.isEmpty()) {
            return false;
        }
        String[] arr = str.split("\\s");
        if(pattern.length() != arr.length) {
            return false;
        }
        Map<Character, String> matchL = new HashMap<Character, String>();
        Map<String, Character> matchR = new HashMap<String, Character>();
        for(int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            String word = arr[i];
            if(!matchL.containsKey(letter) && !matchR.containsKey(word)) {
                matchL.put(letter, word);
                matchR.put(word, letter);
            } else if(matchL.containsKey(letter) && matchR.containsKey(word)) {
                if( !matchL.get(letter).equals(word) || matchR.get(word).charValue() != letter) {
                    return false;
                }
            } else {
                return false;
            }
            
        }
        return true;
    }
}
