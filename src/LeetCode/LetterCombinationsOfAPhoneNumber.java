/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
package LeetCode;
import java.util.ArrayList;
import java.util.List;
public class LetterCombinationsOfAPhoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letterCombinations("3");
	}
    private static char[][] map = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' },
    		{ 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
			{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v'}, { 'w', 'x', 'y', 'z' } };

	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> ret = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		letterCombinationsHelper(digits, 0, sb, ret);
		return ret;
	}
    
	//dfs
    private static void letterCombinationsHelper(String dig, int i, StringBuilder sb, ArrayList<String> arr){
    	//if visited all digits, return the method
        if(dig.length() == i) {
            arr.add(sb.toString());
            return;
        }
        int n = dig.charAt(i) - '2';
        char[] list = map[n];
        // for each possible letter, append to a stringbuilder
        for(int j = 0; j<list.length; j++){
            sb.append(list[j]);
            letterCombinationsHelper(dig, i+1, sb, arr);
            //delete last character in the sb
            sb.deleteCharAt(i);
            // or sb.deleteCharAt(sb.length()-1);
        }
    }
    
    //iterative method
    //假设总共有n个digit，每个digit可以代表k个字符，那么时间复杂度是O(k^n)，就是结果的数量，空间复杂度也是一样
    public List<String> letterCombinationsIteration(String digits) {
    	List<String> results = new ArrayList<String>();
    	results.add("");
    	if(digits == null || digits.length() == 0){
    		return results;
    	}
        char[][] phoneLetters = {{' '},{'$'}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'},{'j','k','l'},
        		{'m','n','o'},{'p','q','r','s'}, {'t','u','v'},{'w','x','y','z'}};
        
        for(int i=0;i<digits.length();i++){
        	int number = digits.charAt(i) - '0';
        	List<String> temp = new ArrayList<String>();
        	//for each old result and possible letter
        	for(int j=0;j<results.size();j++){
        		for(int k=0;k<phoneLetters[number].length;k++){
        			//previous results combine with new letter        			
        			temp.add(results.get(j) + phoneLetters[number][k]);
        		}
        	}
        	results = temp;
        }
        return results;
    }
}
