/**
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 */
package LeetCode;
import java.util.*;
/**
 * @author sjia
 *
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
        if(s == null || s == null) {
            return true;
        }
        HashMap<Character, Character>  hm = new HashMap<Character, Character>();
        HashSet<Character> maped = new HashSet<Character>();
        for(int i=0; i<s.length(); i++) {
        	if(hm.containsKey(s.charAt(i))) {
        		if(hm.get(s.charAt(i)) != t.charAt(i)) {
        			return false;
        		}
        	}
        	else {
        	    if(maped.contains(t.charAt(i))) {
        	        return false;
        	    }
        		hm.put(s.charAt(i), t.charAt(i));
        		maped.add(t.charAt(i));
        	}
        }
        return true;

    }
	
	public boolean isIsomorphicII(String s, String t) {
        if(s == null || s == null) {
            return true;
        }
        char[][] map = new char[256][256];
        boolean[] maped = new boolean[256];
        for(int i=0; i<s.length(); i++) {
        	char key = s.charAt(i);
        	char value = t.charAt(i);
        	if(map[0][key] != 0) {
        		if(map[1][key] != value) {
        			return false;
        		}
        	}
        	else {
        	    if(maped[value]) {
        	        return false;
        	    }
        		map[0][key] = key;
        		map[1][key] = value;
        		maped[value] = true;
        	}
        }
        return true;

    }
}
