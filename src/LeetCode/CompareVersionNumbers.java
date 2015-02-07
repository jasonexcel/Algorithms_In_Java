/**
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
 */
package LeetCode;

import java.util.ArrayList;

/**
 * @author sjia
 *
 */
public class CompareVersionNumbers {

	/**
	 * edge case: "01" vs "1"
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersionNumbers ins = new CompareVersionNumbers();
		String version1 = "1";
		String version2 = "01";
		System.out.println("res = " + ins.compareVersionII(version1, version2));
	}
	//my solution o(n) time, o(n) space
    public int compareVersion(String version1, String version2) {
        int i=0, j=0;
        int res = 0;        
        ArrayList<Integer> num1 = new ArrayList<Integer>();
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        while(i<version1.length() || j<version2.length()){
        	boolean leadingZeroRemoved1 = false;
        	boolean leadingZeroRemoved2 = false;
        	while(i<version1.length() && version1.charAt(i) != '.'){
        		if(version1.charAt(i) != '0'){
        			leadingZeroRemoved1 = true;
        		}
        		if(leadingZeroRemoved1){
        			num1.add(version1.charAt(i) - '0');
        		}
        		i++;
        	}
        	while(j<version2.length() && version2.charAt(j) != '.'){
        		if(version2.charAt(j) != '0'){
        			leadingZeroRemoved2 = true;
        		}
        		if(leadingZeroRemoved2){
        			num2.add(version2.charAt(j) - '0');
        		}
        		j++;
        	}
        	res = compareNumbers(num1, num2);
        	if(res != 0){
        		return res;
        	}
        	num1 = new ArrayList<Integer>();
        	num2 = new ArrayList<Integer>();
        	i++;
        	j++;        	
        }
        return compareNumbers(num1, num2);
    }
    
    private int compareNumbers(ArrayList<Integer> num1, ArrayList<Integer> num2){
    	if(num1.size() < num2.size()){
    		return -1;
    	}
    	else if(num1.size() > num2.size()){
    		return 1;
    	}
    	else{
    		for(int i=0; i<num1.size(); i++){
    			if(num1.get(i) == num2.get(i)){
    				continue;
    			}
    			else if(num1.get(i) < num2.get(i)){
    				return -1;
    			}
    			else{
    				return 1;
    			}
    			
    		}
    	}
    	return 0;
    }
    //o(n) time, o(1) space
    public int compareVersionII(String version1, String version2) {
        int res = 0;        
        int start1 = 0, end1=0, start2=0, end2=0;
        while(start1<version1.length() || start2<version2.length()){

        	while(start1<version1.length() && version1.charAt(start1) == '0'){        		
        		start1++;
        	}
        	end1 = start1;
        	while(end1<version1.length() && version1.charAt(end1) != '.'){
        		end1++;
        	}
        	while(start2<version2.length() && version2.charAt(start2) == '0'){        		
        		start2++;
        	}
        	end2 = start2;
        	while(end2<version2.length() && version2.charAt(end2) != '.'){
        		end2++;
        	}
        	res = compareNumbers(version1, start1, end1, version2, start2, end2);
        	if(res != 0){
        		return res;
        	}
        	end1++;
        	end2++;
        	start1 = end1;
        	start2 = end2;
        }
        //return compareNumbers(version1, start1, end1, version2, start2, end2);
        return res;
    }
    
    private int compareNumbers(String version1, int start1, int end1, String version2, int start2, int end2){
    	if(end1 - start1 > end2 - start2){
    		return 1;
    	}
    	else if(end1 - start1 < end2 - start2){
    		return -1;
    	}
    	else{
    		for(int i=0; i<end1-start1; i++){
    			if(version1.charAt(start1+i) > version2.charAt(start2+i)){
    				return 1;
    			}
    			else if (version1.charAt(start1+i) < version2.charAt(start2+i)){
    				return -1;
    			}
    		}
    	}
    	return 0;
    }
}
