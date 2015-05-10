package Zcode.Z_code;

import java.util.HashMap;
import java.util.Map;

public class SansaAndXor {

	/**
	 * @param args
	 * https://www.hackerrank.com/contests/w9/challenges/sansa-and-xor
	 * Test case #00: 
1⊕2⊕3⊕(1⊕2)⊕(2⊕3)⊕(1⊕2⊕3)=2 

Test case #01: 
4⊕5⊕7⊕5⊕(4⊕5)⊕(5⊕7)⊕(7⊕5)⊕(4⊕5⊕7)⊕(5⊕7⊕5)⊕(4⊕5⊕7⊕5)=0   

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// preferred
	public static int xorII(int[] input) {
		int count = input.length;
		// key is the number, value is the occurrence count 
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		int result = 0;
		for(int i = 0; i < count; i++){
			// count = left side choice * right side choice
			int numCount = (i + 1)*(count - i); //!!!
			int tmp = input[i];
			if(map.containsKey(tmp)){
				map.put(tmp, numCount+map.get(tmp));
			}else{
				map.put(tmp, numCount);
			}
		}
		
		for(int k: map.keySet()){
			int value = map.get(k);
			if(value%2!=0){
				result = result^k;
			}
		}
		
		return result;
	}
	// cannot pass all
	public static int xor(int[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}
		int len = input.length;
		int[][] dp = new int[len][len];
		// Basic subarrays.
		for (int i=0; i<len; i++) {
			dp[0][i] = input[i];
		}
		// First loop, length of subarrays.
		// Starts from 2.
		for (int i=2; i<=len; i++) {
			for (int j=0; j<=len-i; j++) {
				dp[i-1][j] = input[j] ^ dp[i-2][j+1];
			}
		}
		
		int res = 0;
		// XOR all subarrays. 0 does not matter. because num ^ 0 = num.
		for (int i=0; i<len; i++) {
			for (int j=0; j<len; j++) {
				res ^= dp[i][j];
			}
		}
		return res;
	}
	

}
