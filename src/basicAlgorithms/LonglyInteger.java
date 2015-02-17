/**
 * There are N integers in an array A. All but one integer occur in pairs. Your task is to find out the number that occurs only once.
 */


package basicAlgorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * @author Shaun
 *
 */
public class LonglyInteger {
	//bitwise xor 
	static int lonelyintegerBit(int[] a) {
		if(a == null || a.length == 0){
			return 0;
		}
        int res = a[0];
        for(int i=1; i<a.length; i++){
        	res = res ^ a[i];
        }
        return res;
    }
	
	static int lonelyinteger(int[] a) {
        if(a == null || a.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<a.length; i++){
            if(set.contains(a[i])){
                set.remove(a[i]);
            }
            else{
                set.add(a[i]);
            }
        }
        if(set.size() == 1){
            return (int)set.iterator().next();
        }
        return 0;
    }
	
	
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = lonelyinteger(_a);
        System.out.println(res);
        
    }

}
