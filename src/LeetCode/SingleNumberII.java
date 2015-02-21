/**
 * 
 */
package LeetCode;

import java.util.HashMap;

/**
 * @author Shaun
 *
 */
public class SingleNumberII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumberII ins = new SingleNumberII();
		int[] A = {2, 2, 2, 3};
		ins.singleNumber(A);
	}
	//http://blog.csdn.net/linhuanmars/article/details/22645599
	public int singleNumber(int[] A) {
	    int[] digits = new int[32];//store the repetition time for each digit
	    for(int i=0;i<32;i++)
	    {
	        for(int j=0;j<A.length;j++)
	        {
	            digits[i] += (A[j]>>i)&1;// bitwise AND to get the digit in ones
	        }
	    }
	    int res = 0;
	    //convert the res from binary number to digital number
	    for(int i=0;i<32;i++)
	    {
	        res += (digits[i]%3)<<i;
	    }
	    return res;
	}
	
    public int singleNumberMap(int[] A) {
        if(A == null || A.length == 0){
             return 0;
         }
         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
         for(int i=0; i<A.length; i++){
             if(!map.containsKey(A[i])){
                 map.put(A[i], 1);
             }
             else{
                 if(map.get(A[i])==2){
                	 map.remove(A[i]);
                 }
                 else{
                	 map.put(A[i], 2);
                 }
             }

         }
         if(map.size() == 1){
             return (int)map.keySet().iterator().next();
         }
         return 0; 
     }
}
