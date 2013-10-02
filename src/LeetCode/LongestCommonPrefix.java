package LeetCode;

public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int index = 1; index<strs.length; index++) {
                if(strs[index].length() == i || strs[index].charAt(i) != c) {
                    return sb.toString();
                }
                
            }
            sb.append(c);
        }
        return sb.toString();
        
    }
    
    // alternative way 
    public String longestCommonPrefixII(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length == 0) return "";
        String common = new String();
        common = strs[0];
        for(int i = 1; i<strs.length; i++) {
            if( strs[i] == null)    return null;
            common = longestCommonPrefixHelper(common, strs[i]);
            
        }
        return common;
        
    }
    
    private String longestCommonPrefixHelper(String strA, String strB) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < strA.length() && index < strB.length()) {
            if(strA.charAt(index) == strB.charAt(index)) {
                sb.append(strA.charAt(index));
                index++;
            }
            else{
                break;
            }
        }
        return sb.toString();
    }

}
