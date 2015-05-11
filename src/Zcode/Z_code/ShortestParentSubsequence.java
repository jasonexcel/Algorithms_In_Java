package Zcode.Z_code;
import java.util.*;

class WindowNode {
	char c;
	int index;
	
	public WindowNode(char c, int i) {
		this.c = c;
		this.index = i;
	}
}
public class ShortestParentSubsequence {

	/**
	 * @param args
	 * 给两个string，str和query，要求找str里最短的包含query的字串。
	 * 比如str = “aqweabadc”, query = "abc" 所以返回abadc
	 * 
	 * ) It was long description for a DNA problem. Main DNA sequence(a string) is given 
	 * (let say strDNA) and another string to search for(let say strPat). You have to find
	 *  the minimum length window in strDNA where strPat is subsequence.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abacd";
		String query = "abc";

	}
	
	public static String findShortestSubsequence(String str, String query) {
		if(query == null || query.length() == 0) {
			return "";
		}
		if(str == null || str.length() == 0) {
			return null;
		}
		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<query.length(); i++) {
			set.add(query.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			if(set.contains(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
		}
		// TODO
		return null;
	}
}
