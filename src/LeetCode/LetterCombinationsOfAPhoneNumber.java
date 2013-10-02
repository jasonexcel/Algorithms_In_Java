package LeetCode;
import java.util.ArrayList;
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
    
    private static void letterCombinationsHelper(String dig, int i, StringBuilder sb, ArrayList<String> arr){
        if(dig.length() == i) {
            arr.add(sb.toString());
            return;
        }
        int n = dig.charAt(i) - '2';
        char[] list = map[n];
        for(int j = 0; j<list.length; j++){
            sb.append(list[j]);
            letterCombinationsHelper(dig, i+1, sb, arr);
            sb.deleteCharAt(i);
            // or sb.deleteCharAt(sb.length()-1);
        }
    }
}
