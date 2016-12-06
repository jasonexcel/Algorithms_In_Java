/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
 */
package LeetCode;

/**
 * https://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/
 *http://www.wikihow.com/Multiply-Large-Numbers-Quickly-With-the-Box-Method
 * Box method
 */
public class MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings ins = new MultiplyStrings();
		String num1 = "9", num2 = "9";
		System.out.println(ins.multiply(num1, num2));

	}
	// preferred
    public String multiply(String num1, String num2) {
        if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1+len2];
        for(int i=0; i<len1; i++) {
            for(int j=0; j<len2; j++) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i+j+1] += mul;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int index=len1+len2-1; index>=1; index--) {
			sb.append(res[index]%10);
            res[index-1] += res[index] / 10;
        }
        if(res[0] != 0) {
            sb.append(res[0]);
        }
        return sb.reverse().toString();
    }
    
	//time o(n*n), space o(n)
	public String multiplyI(String num1, String num2) {
		if(num1 == null || num2 == null || num1.length()==0 || num2.length()==0){
	    	return "";
	    }	        
	    if(num1.charAt(0)=='0'){
	    	return "0";
	    }
	    if(num2.charAt(0)=='0'){
	    	return "0";
	    }
	    //reverse both of strings for easy operation
	    num1 = new StringBuilder(num1).reverse().toString();
	    num2 = new StringBuilder(num2).reverse().toString();
	    // even 99 * 99 is < 10000, so maximally 4 digits
	    int[] d = new int[num1.length() + num2.length()];
	    //store multiplication into array d
	    for (int i = 0; i < num1.length(); i++) {
	        int a = num1.charAt(i) - '0';
	        for (int j = 0; j < num2.length(); j++) {
	            int b = num2.charAt(j) - '0';
	            d[i + j] += a * b;
	        }
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < d.length; i++) {
	        int digit = d[i] % 10;
	        int carry = d[i] / 10;
	        sb.insert(0, digit); //build the string from lower digit, insert at the place index 0
	        if (i < d.length - 1)
	            d[i + 1] += carry;	//carry to upper digit
	        }
	    //trim starting zeros for the result length is (m+n-1), not (m+n)
	    while (sb.length() > 1 && sb.charAt(0) == '0') {
	        sb.deleteCharAt(0);
	    }
	    return sb.toString();
	}


	public String multiplyII(String num1, String num2) {
	    if(num1 == null || num2 == null || num1.length()==0 || num2.length()==0){
	    	return "";
	    }
	        
	    if(num1.charAt(0)=='0'){
	    	return "0";
	    }
	    if(num2.charAt(0)=='0'){
	    	return "0";
	    }
	        
	    StringBuilder res = new StringBuilder();
	    int num = 0;
	    for(int i=num1.length()+num2.length();i>0;i--){
	        for(int j=Math.min(i-1,num1.length());j>0;j--){
	            if(i-j<=num2.length()){
	                num += (int)(num1.charAt(j-1)-'0')*(int)(num2.charAt(i-1-j)-'0');
	            }
	        }
	        if(i!=1 || num>0){
	        	res.append(num%10);
	        }
	            
	        num = num/10;
	    }
	    return res.reverse().toString();
	}	
}
