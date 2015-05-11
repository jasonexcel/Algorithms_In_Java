package Zcode.Z_code;

public class MinimumInsertionsToFormAPalindrome {

	/**
	 * @param args
	 * http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
	 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.

Before we go further, let us understand with few examples:
    ab: Number of insertions required is 1. bab
    aa: Number of insertions required is 0. aa
    abcd: Number of insertions required is 3. dcbabcd
    abcda: Number of insertions required is 2. adcbcda which is same as number of insertions in the substring bcd(Why?).
    abcde: Number of insertions required is 4. edcbabcde
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "accaa", "aacca"
		String s = "aacca";
		System.out.println(minimumToPalindrome(s));
		System.out.println(minimumToPalindromeII(s));
	}
	// recursive, time is too expensive, np
	public static int minimumToPalindrome(String s) {
		if(s == null || s.length() < 2) {
			return 0;
		}
		if(s.charAt(0) == s.charAt(s.length()-1)) {
			return minimumToPalindrome(s.substring(1, s.length()-1));
		}
		else {
			return Math.min(minimumToPalindrome(s.substring(0, s.length()-1)),
					minimumToPalindrome(s.substring(1, s.length()))) + 1;
		}
	}
	
	// with cache
	// O(n^2) time and space
	public static int minimumToPalindromeII(String s) {
		if(s == null || s.length() < 2) {
			return 0;
		}
		int[][] min = new int[s.length()][s.length()];
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<s.length(); j++) {
				if(i != j) {
					min[i][j] = -1;
				}
			}
		}
		minHelper(s, min, 0, s.length()-1);
		return min[0][s.length()-1];
	}
	
	private static void minHelper(String s, int[][] min, int left, int right) {
		if(left >= right) {
			min[left][right] = 0;
			return;
		}
		if(s.charAt(left) == s.charAt(right)) {
			if(min[left+1][right-1] == -1) {
				minHelper(s, min, left+1, right-1);
			}
			min[left][right] = min[left+1][right-1];
			return;

		}
		else {
			if(min[left][right-1] == -1) {
				minHelper(s, min, left, right-1);
			}
			if(min[left+1][right] == -1) {
				minHelper(s, min, left+1, right);							
			}
			min[left][right] = Math.min(min[left][right-1], min[left+1][right]) + 1;
			return;
		}
	}
	
	// LCS method
	//1) Find the length of LCS of input string and its reverse. Let the length be ‘l’.
	//2) The minimum number insertions needed is length of input string minus ‘l’.
	// O(n^2) time and space
}
