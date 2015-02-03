/**
 * 
 */
package LeetCode;

import java.util.LinkedList;

/**
 * http://blog.csdn.net/linhuanmars/article/details/24444491
 * DP + Stack
 * o(m*n) time complexity, space complexity o(n)
 */
public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maximalRectangle(char[][] matrix) {
	    if(matrix==null || matrix.length==0 || matrix[0].length==0)
	    {
	        return 0;
	    }
	    int maxArea = 0;
	    int[] height = new int[matrix[0].length];
	    for(int i=0;i<matrix.length;i++)
	    {
	        for(int j=0;j<matrix[0].length;j++)
	        {
	            height[j] = matrix[i][j]=='0'?0:height[j]+1;
	        }
	        maxArea = Math.max(largestRectangleArea(height),maxArea);
	    }
	    return maxArea;
	}
	public int largestRectangleArea(int[] height) {
	    if(height==null || height.length==0)
	    {
	        return 0;
	    }
	    int maxArea = 0;
	    LinkedList<Integer> stack = new LinkedList<Integer>();
	    for(int i=0;i<height.length;i++)
	    {
	        
	        while(!stack.isEmpty() && height[i]<=height[stack.peek()])
	        {
	            int index = stack.pop();
	            int curArea = stack.isEmpty()?i*height[index]:(i-stack.peek()-1)*height[index];
	            maxArea = Math.max(maxArea,curArea);
	        }
	        stack.push(i);
	    }
	    while(!stack.isEmpty())
	    {
	        int index = stack.pop();
	        int curArea = stack.isEmpty()?height.length*height[index]:(height.length-stack.peek()-1)*height[index];
	        maxArea = Math.max(maxArea,curArea);            
	    }
	    return maxArea;
	}
}
