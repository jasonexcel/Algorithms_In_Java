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
		String str = "aqweabadc";
		String query = "abc";
		System.out.println(findShortestSubsequence(str, query));
	}
	
	public static String findShortestSubsequence(String str, String query) {
		if(query == null || query.length() == 0) {
			return "";
		}
		if(str == null || str.length() == 0) {
			return null;
		}
/*		Set<Character> set = new HashSet<Character>();
		for(int i=0; i<query.length(); i++) {
			set.add(query.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			if(set.contains(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
		}*/
		int sLen = str.length();
		int qLen = query.length();
		int subSeqS = 0;
		int subSeqL = Integer.MAX_VALUE;
		int qIndex = 0;
		for(int i=0; i<=sLen-qLen; i++) {
			qIndex = 0;
			for(int j=i; j<sLen; j++) {
				if(j-i+1>subSeqL) {
					break;
				}
				if(str.charAt(j) == query.charAt(qIndex)) {
					qIndex++;
					if(qIndex == qLen) {
						if(j-i+1<subSeqL) {
							subSeqL = j-i+1;
							subSeqS = i;
						}
						break;
					}
					
				}
			}
		}
		if(subSeqL <= sLen) {
			return str.substring(subSeqS, subSeqS+subSeqL);
		}
		
		return "";
	}
}
