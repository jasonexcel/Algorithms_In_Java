package Zcode.Z_code;
import java.util.*;
public class SubstringPalindrome {

	/**
	 * @param args
	 * Given a string S, find all palindromic substring in S.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abacabb";
		int i = 0;
		for(String e : findAllPalindrome(s)) {
			System.out.println(e);
			i++;
		}
		System.out.println("-----");
		for(String e : findAllPalindromeDP(s)) {
			System.out.println(e);
			i--;
		}
		System.out.println(i);
	}
	// o(n^2) time and space
	public static List<String> findAllPalindromeDP(String s) {
		List<String> results = new ArrayList<String>();
		//use hashset to avoid duplicates palindrome
		Set<String> set = new HashSet<String>();
		if(s == null || s.length() == 0) {
			return results;
		}
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];
		for(int end=0; end<len; end++) {
			for(int start=0; start<=end; start++) {
				if(s.charAt(start) == s.charAt(end)) {
					if(start + 2 >= end || isPalindrome[start+1][end-1]) {
						isPalindrome[start][end] = true;
						// add into set
						set.add(s.substring(start, end+1));
					}
				}
			}
		}
		for(String e : set) {
			results.add(e);
		}
		return results;
	}
	
	// O(n^2) time, O(n) space
	public static List<String> findAllPalindrome(String s) {
		List<String> results = new ArrayList<String>();
		//use hashset to avoid duplicates palindrome
		Set<String> set = new HashSet<String>();
		if(s == null || s.length() == 0) {
			return results;
		}
		int len = s.length();
		int center;
		for(center=0; center<2*len-1; center++) {
			int start = center/2;
			int end = start;
			if(center % 2 == 1) {
				end++;
			}
			findAllPalindromeAtCenter(s, start, end, set);
		}
		for(String e : set) {
			results.add(e);
		}
		return results;
	}
	
	private static void findAllPalindromeAtCenter(String s, int start, int end, Set<String> set) {
		while(start >= 0 && end < s.length()) {
			if(s.charAt(start) == s.charAt(end)) {
				set.add(s.substring(start, end+1));
				start--;
				end++;
			}
			else {
				break;
			}
		}
	}
}
