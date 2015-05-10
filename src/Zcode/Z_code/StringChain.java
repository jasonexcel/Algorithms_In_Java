package Zcode.Z_code;

import java.util.*;
public class StringChain {

	/**
	 * @param args
	 * 类似word ladder，对于一个单词删掉任何一个字母，如果新单词出现在给的词典里 那么就形成一个 chain： 
	 * old word -> new word -> newer word, 求最长长度(return int) 
	 * 比如给vector<string> w = {a,ba,bca,bda,bdca} 最长是4： bdca->bda->ba->a;
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringChain sc = new StringChain();
		String[] input = {"a", "ab", "abc", "abdf", "abcdf", "abcadf", "pabcadf" };
		// expected result: 4
		System.out.println(sc.longestChain(input));
	}
		
	//DP
	public int longestChain(String[] input) {

		Arrays.sort(input, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		Map<Integer, Set<String>> lenMap = new HashMap<Integer, Set<String>>();
		for (String s : input) {
			if (lenMap.containsKey(s.length())) {
				lenMap.get(s.length()).add(s);
			} 
			else {
				Set<String> set = new HashSet<String>();
				set.add(s);
				lenMap.put(s.length(), set);
			}
		}

		Map<String, Integer> localMaxMap = new HashMap<String, Integer>();
		int longest = 0;
		for (String s : input) {
			
			int localMax;
			if(s.length() == 1) {
				localMax = 1;
			}
			else {
				localMax = subMaxLength(s, localMaxMap) + 1;
			}
			
			longest = Math.max(localMax, longest);
			localMaxMap.put(s, localMax);
		}

		return longest;
	}
	// get the passing string's greatest substring chain length
	private int subMaxLength(String s, Map<String, Integer> localMaxMap) {
		String sub;
		int maxLen = 0;
		StringBuilder sb = new StringBuilder(s);
		
		for(int i=0; i<sb.length(); i++) {
			char c = sb.charAt(i);
			sb.deleteCharAt(i);
			//sub = s.substring(0, i) + s.substring(i+1, s.length());
			if(localMaxMap.containsKey(sb.toString())) {
				maxLen = Math.max(maxLen,  localMaxMap.get(sb.toString()));
			}
			sb.insert(i, c);
		}
		return maxLen;
	}	
}
