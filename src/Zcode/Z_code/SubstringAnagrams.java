package Zcode.Z_code;

public class SubstringAnagrams {

	/**
	 * @param args
	 * 
// String input (M)
// String pattern (N)

// # output me the number of substrings in input that is an anagram of pattern
// input：abcba
// pattern：abc  
// ~> 2   {abc, cba}
 * http://www.1point3acres.com/bbs/thread-133151-1-1.html
	 */
	public static final int MAX = 256;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source = "abcbadacb";
		String pattern = "abc";
		System.out.println(countAnagrams(source, pattern));
	}
	// o(n) time
	public static int countAnagrams(String source, String pattern) {
		int count = 0;
		int sLen = source.length();
		int pLen = pattern.length();
		if(sLen < pLen) {
			return count;
		}
		int[] countP = new int[MAX];
		int[] countS = new int[MAX];
		for(int i=0; i<pLen; i++) {
			countP[pattern.charAt(i)]++;
			countS[source.charAt(i)]++;
		}
		// check the first one
		if(isAnagrams(countP, countS)) {
			count++;
		}
		for(int i=pLen; i<sLen; i++) {
			countS[source.charAt(i-pLen)]--;
			countS[source.charAt(i)]++;
			if(isAnagrams(countP, countS)) {
				count++;
			}
		}
		return count;	
	}
	// o(1) since the length of array is 256 here
	private static boolean isAnagrams(int[] arrA, int[] arrB) {
		for(int i=0; i<arrA.length; i++) {
			if(arrA[i] != arrB[i]) {
				return false;
			}
		}
		return true;
	}	
}
