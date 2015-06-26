package Zcode.Z_code;

import java.io.*;
import java.util.*;
/**
 * bits flip. 大意就是有一串0,1的数组，然后可以取中间任意一段，把0置换为1,1置换为0. 问这样一次置换之后，
 * 这组数组最多还有多少个1
 * @author Shaun
 *
 */
public class bitFlip {
	/**
	 * @param args
	 */
	
	// O(N) time complexity, iteration once
	static int bitFlip(int[] arr) {
		if(arr == null || arr.length == 0) {
			return 0;
		}
		int currentOnes = 0;
		for(int elem : arr) {
			if(elem == 1) {
				currentOnes++;
			}
		}
		
		int extraOnes = 0;
		int localExtraOnes = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 1) {
				localExtraOnes--; 
			}
			else {
				localExtraOnes++;
			}
			localExtraOnes = Math.max(0, localExtraOnes);
			extraOnes = Math.max(extraOnes, localExtraOnes);
		}
		return currentOnes + extraOnes;
		
	}
	
	public static void main(String [] args) throws Exception
    {
/*        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int t = 0; t < n; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }*/
        int[] test = {1, 0, 0, 1, 0, 0, 1, 0};
        int res = bitFlip(test);
        System.out.println(res);
        //System.console();
    }
}
