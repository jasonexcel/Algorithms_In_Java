/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
 */
package LeetCode;

public class ContainsWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//http://blog.csdn.net/linhuanmars/article/details/21145429
	// O(n) time, O(1) space
	public int maxArea(int[] height) {
	    if(height==null || height.length==0)
	        return 0;
	    int l = 0;
	    int r = height.length-1;
	    int maxArea = 0;
	    while(l<r)
	    {
	        maxArea = Math.max(maxArea, Math.min(height[l],height[r])*(r-l));
	        if(height[l]<height[r])
	            l++; //!!! to maximize the area, move the lower one
	        else
	            r--;
	    }
	    return maxArea;
	}
	
    public int maxAreaII(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = height.length;
        if(size<2) return 0;
        int i = 0; 
        int j = size -1;
        int maxArea = 0;
        int area;
        while(i<j){
            if(height[i]<height[j]){
                area = height[i] * (j -i);
                i++;
            }
            else{
                area = height[j] * (j -i);
                j--;
            }
            maxArea = maxArea> area? maxArea:area;
        }
        return maxArea;
    }
}
