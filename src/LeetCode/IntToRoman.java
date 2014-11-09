/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Construct the hashmap, 
 * http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm
 */
package LeetCode;

import java.util.HashMap;

public class IntToRoman {
	public String intToRoman(int num) {
		//1. build the hashmap
        HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
        hm.put(1, 'I');
        hm.put(5, 'V');
        hm.put(10, 'X');
        hm.put(50, 'L');
        hm.put(100, 'C');
        hm.put(500, 'D');
        hm.put(1000, 'M');
        
        //2. step into the num from high digit to low digit
        //start from 1000 until 1
        StringBuilder sb = new StringBuilder();
        for(int base=1000; base>=1; base/=10){
        	int digit = num/base;
        	if(digit<=0){
        		continue;
        	}
        	if(0<digit && digit<=3){
        		while(digit>0){
        			sb.append(hm.get(base));
        			digit--;
        		}
        	}
        	// 400 = CD
        	else if(digit==4){
        		sb.append(hm.get(base));
        		sb.append(hm.get(base*5));
        	}
        	else if(4<digit&& digit<=8){
        		sb.append(hm.get(base*5));
        		while(digit>5){
        			sb.append(hm.get(base));
        			digit--;
        		}
        	}
        	// 90 = XC
        	else if(digit==9){
        		sb.append(hm.get(base));
        		sb.append(hm.get(base*10));
        	}
        	//3. remember to refresh the value
        	num=num%base;
        }
        return sb.toString();
    }
}
