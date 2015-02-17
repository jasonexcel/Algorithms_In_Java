/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Shaun
 *
 */
public class FourSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//use hashset to resolve duplicates, easiest to code
	//o(n^3) time complexity, o(1) space (extra space)
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	    HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    Arrays.sort(num);
	    for (int i = 0; i <= num.length-4; i++) {
	        for (int j = i + 1; j <= num.length-3; j++) {
	            int low = j + 1;
	            int high = num.length - 1;
	 
	            while (low < high) {
	                int sum = num[i] + num[j] + num[low] + num[high];
	 
	                if (sum > target) {
	                    high--;
	                } else if (sum < target) {
	                    low++;
	                } else if (sum == target) {
	                    ArrayList<Integer> temp = new ArrayList<Integer>();
	                    temp.add(num[i]);
	                    temp.add(num[j]);
	                    temp.add(num[low]);
	                    temp.add(num[high]);
	 
	                    if (!hashSet.contains(temp)) {
	                        hashSet.add(temp);
	                        result.add(temp);
	                    }
	 
	                    low++;
	                    high--;
	                }
	            }
	        }
	    }
	 
	    return result;
	}
	
	//complete method
	public ArrayList<ArrayList<Integer>> fourSumCodeGanker(int[] num, int target) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    if(num==null||num.length==0)
	        return res;
	    Arrays.sort(num);
	    for(int i=num.length-1;i>2;i--)
	    {
	        if(i==num.length-1 || num[i]!=num[i+1])
	        {
	            ArrayList<ArrayList<Integer>> curRes = threeSum(num,i-1,target-num[i]);
	            for(int j=0;j<curRes.size();j++)
	            {
	                curRes.get(j).add(num[i]);
	            }
	            res.addAll(curRes);
	        }
	    }
	    return res;        
	}
	private ArrayList<ArrayList<Integer>> threeSum(int[] num, int end, int target)
	{
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    for(int i=end;i>1;i--)
	    {
	        if(i==end || num[i]!=num[i+1])
	        {
	            ArrayList<ArrayList<Integer>> curRes = twoSum(num,i-1,target-num[i]);
	            for(int j=0;j<curRes.size();j++)
	            {
	                curRes.get(j).add(num[i]);
	            }
	            res.addAll(curRes);
	        }
	    }
	    return res;
	}
	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target)
	{
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    int l=0;
	    int r=end;
	    while(l<r)
	    {
	        if(num[l]+num[r]==target)
	        {
	            ArrayList<Integer> item = new ArrayList<Integer>();
	            item.add(num[l]);
	            item.add(num[r]);
	            res.add(item);
	            l++;
	            r--;
	            while(l<r&&num[l]==num[l-1])
	                l++;
	            while(l<r&&num[r]==num[r+1])
	                r--;
	        }
	        else if(num[l]+num[r]>target)
	        {
	            r--;
	        }
	        else
	        {
	            l++;
	        }
	    }
	    return res;
	}
}
