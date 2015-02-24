/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
package LeetCode;
import java.util.Stack;
public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(addBinary2("10","111"));
	}
	//time complexity: o(max(m, n)), space complexity: o(max(m, n))
	   public static String addBinary(String a, String b) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int lena=a.length();
	        int lenb=b.length();
	        int carry=0;

	        char[] charA = a.toCharArray();
	        char[] charB = b.toCharArray();
	        int i=lena-1;
	        int j=lenb-1;
	        int curr;
	        StringBuilder ss = new StringBuilder();
	        Stack<Integer> temp = new Stack<Integer>();

	        while(i>=0 && j>=0)
	        {
	            curr = (charA[i--]-'0')+(int)(charB[j--]-'0')+carry;
	            carry = curr/2; 
	            curr= curr%2;
	            temp.push(curr);
	        }

	        while(i>=0)
	        {
	            curr = (int)(charA[i--]-'0')+carry;
	            carry = curr/2;
	            curr = curr%2;
	            temp.push(curr);
	        }
	        while(j>=0)
	        {
	            curr = (int)(charB[j--]-'0')+carry;
	            carry = curr/2;
	            curr = curr%2;
	            temp.push(curr);
	        }

	        if(carry!=0)
	        temp.push(carry);

	        while(!temp.isEmpty())
	        {
	            ss.append(temp.pop());

	        }

	        return ss.toString();

	    }
	   // my solution
	    public static String addBinary2(String a, String b) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int lenA = a.length();
	        int lenB = b.length();
	        if(a == null || b == null) return null;
	        if(lenA == 0 ) return b;
	        else if(lenB == 0) return a;
	        
	        int i = lenA -1, j = lenB -1;
	        int len = lenA > lenB? lenA+1:lenB+1;
	        int k = len -1;
	        char[] result = new char[len];
	        int carry = 0;
	        while(i>=0 && j>=0){
	            int temp = a.charAt(i--) - '0' + b.charAt(j--) - '0' + carry;
	            carry = temp/2;
	            result[k--] =  temp%2 == 0? '0' : '1';
	        }
	        while(i>=0){
	            int temp = a.charAt(i--) - '0' + carry;
	            carry = temp/2;
	            result[k--] = temp%2 == 0? '0' : '1';
	        }
	        while(j>=0){
	            int temp = b.charAt(j--) - '0' + carry;
	            carry = temp/2;
	            result[k--] = temp%2 == 0? '0' : '1';
	        }
	        
	        int p;
	        if(carry==1){
	            p = 0;
	            result[0] ='1';
	        }
	        else {
	            p = 1;
	        }
	        
	        StringBuilder c = new StringBuilder();
	        while(p<len){
	            c.append(result[p++]);      
	        }
	        return c.toString();
	    
	    }
}
