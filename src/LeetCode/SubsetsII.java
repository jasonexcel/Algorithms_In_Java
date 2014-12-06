/**
 * 
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shaun
 *
 */
public class SubsetsII {
	public static void main(String args[]){
		SubsetsII ins = new SubsetsII();
		int[] num = {1,1,1};
		ins.subsetsWithDup(num);
	}
	//my solution
	// resultsA always holds values exclude current index;
	// resultsB will hold only solutions with current index number
    public List<List<Integer>> subsetsWithDup(int[] num) {
    	if(num==null){
        	return null;
        }
        //sort S first to meet requirement
        Arrays.sort(num);
        List<List<Integer>> resultsA = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        resultsA.add(empty);
        List<List<Integer>> resultsB = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(num[0]);
        resultsB.add(first);
        
        for(int i=1; i<num.length; i++){
    		List<List<Integer>> cloneB = new ArrayList<List<Integer>>(resultsB);
    		resultsA.addAll(cloneB);  
    		resultsB.clear();
    		
        	if(num[i] == num[i-1]){  
        		// current number equals to previous one then only current number 
        		// can only be appended to cloneB to create a new resultsB
        		int size = cloneB.size();
        		for(int j=0; j<size; j++){
            		//for each current resultB item, add the new number to the end of list
            		List<Integer> temp = new ArrayList<Integer>(cloneB.get(j));
            		temp.add(num[i]);
            		resultsB.add(new ArrayList<Integer>(temp));
            	}
        	}
        	else{    	
        		// size is equal to the length of all current results
        		int size = resultsA.size();
        		for(int j=0; j<size; j++){
            		List<Integer> temp = new ArrayList<Integer>(resultsA.get(j));
            		temp.add(num[i]);
            		resultsB.add(new ArrayList<Integer>(temp));
            	}
        	}
        	
        }
        resultsA.addAll(resultsB);
        return resultsA; 
    }
}
