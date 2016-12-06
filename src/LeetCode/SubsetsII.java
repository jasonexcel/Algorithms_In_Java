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
		int[] num = {1};
		ins.subsetsWithDup(num);
	}

    //templates
    public List<List<Integer>> subsetsWithDupTemplates(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<Integer>();
        helper(results, res, nums, 0);

        return results;
    }
    private void helper(List<List<Integer>> results, List<Integer> res, int[] nums, int pos) {
        results.add(new ArrayList<Integer>(res));

        for(int i = pos; i < nums.length; i++) {
            if(i != pos && nums[i] == nums[i-1]) {
                continue;
            }
            res.add(nums[i]);
            helper(results, res, nums, i + 1);
            res.remove(res.size() - 1);
        }
    }

    // preferred
    public List<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if(nums==null || nums.length==0) {
            return res;
        }
        Arrays.sort(nums);
        int startIndex = 0;
        int partitionIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                startIndex = partitionIndex;
            }
            else {
                startIndex = 0;
            }
            partitionIndex = res.size();
            for(int j=startIndex; j<partitionIndex; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
            
        }
        return res;
    }
    
	//my solution
	// resultsA always holds values exclude current index;
	// resultsB will hold only solutions with current index number
    public List<List<Integer>> subsetsWithDupIII(int[] num) {
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
    
    // code ganker
    public ArrayList<ArrayList<Integer>> subsetsWithDupII(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if(num==null || num.length==0)
            return res;
        Arrays.sort(num);
        int start = 0;
        for(int i=0;i<num.length;i++)
        {
            int size = res.size();
            for(int j=start;j<size;j++)
            {
                ArrayList<Integer> newItem = new ArrayList<Integer>(res.get(j));
                newItem.add(num[i]);
                res.add(newItem);
            }
            if(i<num.length-1 && num[i]==num[i+1])
            {
            	// !!!
                start = size;
            }
            else
            {
                start = 0;
            }
        }
        return res;
    }
}
