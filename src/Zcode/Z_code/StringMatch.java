package Zcode.Z_code;

import java.util.HashMap;

public class StringMatch {

	/**
	 * @param args
	 * String s1 = "waeginsapnaabangpisebbasepgnccccapisdnfngaabndlrjngeuiogbbegbuoecccc";
String s2 = "a+b+c-";

s2的形式是一个字母加上一个符号，正号代表有两个前面的字符，负号代表有四个，也就是说s2其实是"aabbcccc"，不考虑invalid。
在s1中，找出连续或者不连续的s2，也就是说从s1中找出"aa....bb.....cccc"，abc顺序不能变，但是之间可以有零个或多个字符，返回共有多少个。在上面这个例子中，有四个。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "waeginsapnaabangpisebbasepgnccccapisdnfngaabndlrjngeuiogbbegbuoecccc";
		String s2 = "a+b+c-";
		System.out.println(numDistinctDP(s1, s2));
	}
	public static int numDistinctDP(String s1, String s2){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        // key: character, value: count
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //transform s2
        for(int i = 0; i < s2.length(); i += 2){
            char c = s2.charAt(i);
            sb2.append(c);
            map.put(c, s2.charAt(i + 1) == '+'? 2: 4);
        }
        s2 = sb2.toString();
        //transform s1
        for(int i = 0; i < s1.length() - 1; i++){
            char c = s1.charAt(i);
            if(map.containsKey(c)){
                int value = map.get(c);
                if(isValid(s1, i, value, c)){
                    sb1.append(c);
                }
            }
        }
        //cannot match s2 to subsequence of sb1
        if(sb1.length() < s2.length()) {
        	return 0;
        }
        s1 = sb1.toString();
        //start DP
        int[][] num = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
        	num[i][0] = 1;
        }
        for(int i = 1; i <= s1.length(); i++){
        	for(int j = 1; j <= s2.length(); j++){
        		// !!!
        		num[i][j] += num[i - 1][j];
        		if(s1.charAt(i - 1) == s2.charAt(j - 1)){
        			num[i][j] += num[i - 1][j - 1];
        		}
        	}
        }
        return num[s1.length()][s2.length()];
	}
	// validate s1 contains the contiguous special character from index i of size 'length'
	private static boolean isValid(String s1, int i, int length, char c) {
		if(i+length>s1.length()) {
			return false;
		}
		for(int start=0; start<length; start++) {
			if(s1.charAt(i+start) != c) {
				return false;
			}
		}
		return true;
	}
}
