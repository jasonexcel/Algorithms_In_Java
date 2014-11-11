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
    
	//tail recursive method here?
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
    public List<String> letterCombinationsIteration(String digits) {
    	List<String> results = new ArrayList<String>();
    	results.add("");
    	if(digits == null || digits.length() == 0){
    		return results;
    	}
        char[][] phoneLetters = {{' '},{'$'}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'}, {'t','u','v'},{'w','x','y','z'}};

        
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
