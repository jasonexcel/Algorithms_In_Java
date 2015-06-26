package RealInterviewQuestion;

import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// the quick brown fox jumps over the lazy dog
		// quick: 1, brown: 1, the: 2
		// input: String doc
		// output: HashMap<String, Integer> res

		// doc is null
		// the      quick brown 'fox'!  I jumps over the lazy dog
		// 
		public Map<String, Integer> wordCount(String doc) {
		    Map<String, Integer> res = new HashMap<String, Integer>();
		    if(doc == null || doc.length() == 0) {
		        return res;
		    }
		    
		    doc = doc.trim();
		    String[] arr = doc.split("\\s+");
		    
		    for(int index=0; index<arr.length; index++) {	    	
		        String curStr = trimPrePostSpecialAndToLower(arr[index]);
		        if(curStr == null || curStr.length() == 0) {
		        	continue;
		        }

	            if(res.containsKey(curStr)) {
	                res.put(curStr, res.get(curStr)+1);
	            }
	            else {
	                res.put(curStr, 1);
	            }      	     
		    }
		    return res;
		}

		private String trimPrePostSpecialAndToLower(String str) {
			if(str == null || str.length() == 0) {
				return str;
			}
		    int start;
		    for(start=0; start<str.length(); start++) {
		    	char c = str.charAt(start);
		        if(('a'<=c&& c <='z') || ('A' <= c && c <= 'Z' )){
		            break;
		        }
		    }
		    int end;
		    
		    for(end = str.length()-1; end>=start; end--) {
		    	char c = str.charAt(end);
		        if(('a'<=c&& c <='z') || ('A' <= c && c <= 'Z' )){
		            break;
		        }
		    }
		    
		    if(start<=end) {
		        return str.substring(start, end+1).toLowerCase();
		    }
		    else {
		    	return "";
		    }
		}
}
