/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
package LeetCode;

import java.util.List;

/**
 * @author http://blog.csdn.net/linhuanmars/article/details/23230657
 *
 */
public class Triangle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minimumTotal(List<List<Integer>> triangle) {
	    if(triangle == null || triangle.size() == 0)
	        return 0;
	    if(triangle.size()==1)
	        return triangle.get(0).get(0);
	    int[] sums = new int[triangle.size()];
	    sums[0] = triangle.get(0).get(0);
	    for(int i=1;i<triangle.size();i++)
	    {
	        sums[i] = sums[i-1]+triangle.get(i).get(i);
	        for(int j=i-1;j>=1;j--)
	        {
	            sums[j] = (sums[j]<sums[j-1]?sums[j]:sums[j-1]) + triangle.get(i).get(j);
	        }
	        sums[0] = sums[0]+triangle.get(i).get(0);
	        
	    }
	    int minimum = sums[0];
	    for(int i=1;i<sums.length;i++)
	    {
	        if(sums[i]<minimum)
	        {
	            minimum = sums[i];
	        }
	    }
	    return minimum;
	}
	

}
