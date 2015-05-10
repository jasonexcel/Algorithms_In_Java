/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */

package LeetCode;

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(53));
		System.out.println(testDecimal(1080));
	}
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            char cur = (char)('A' + (n -1) % 26); // !!!
            sb.append(cur);
            n = (n - 1) / 26; // !!!
        }
        return sb.reverse().toString();
    }
    // compare with decimal here
    public static String testDecimal(int n) {
    	StringBuilder sb = new StringBuilder();
    	while(n > 0) {
    		char cur = (char)('0' + n % 10);
    		sb.append(cur);
    		n = n / 10;
    	}
    	return sb.reverse().toString();
    }
}
