/**
 * 
 */
package LeetCode;

import java.util.LinkedList;

/**
 * @author Shaun
 *
 */
public class LargestRectangleInHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleInHistogram ins = new LargestRectangleInHistogram();
		int[] height = {2,1,5,6,2,3};
		System.out.println("max = " + ins.largestRectangleAreaII(height));
	}
	// time complexity: o(n^2), time limit exceeded
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
        	return 0;
        }
        int max = 0;
        int len = height.length;
        for(int i=0; i<len; i++){
        	int h = height[i];
        	int left = i, right = i;
            //trick to avoid duplicate calculation
        	while(left>=0 && height[left]>=h){
        		left--;
        	}
        	left++;
        	while(right<len && height[right]>=h){
        		right++;
        	}
        	right--;
        	int area = h * (right - left + 1);
        	max = Math.max(max, area);
        }
        return max;
    }
    
    //o(n) http://blog.csdn.net/linhuanmars/article/details/20524507
    //graph: http://blog.csdn.net/doc_sgl/article/details/11805519 
    public int largestRectangleAreaII(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i=0;i<height.length;i++)
        {
            while(!stack.isEmpty() && height[i]<=height[stack.peek()])
            {
                int index = stack.pop();
                int curHeight = height[index];
                int curArea;
                if(stack.isEmpty()) {
                    //the range is from 0 to i - 1; [0, i)
                    curArea = i * curHeight;
                } else {
                    // the range is from stack.peek()+1 to i - 1; (stack.peek, i)
                    curArea = (i - stack.peek() - 1) * curHeight;
                }
                max = Math.max(max,curArea);
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
        {
            int index = stack.pop();
            int curArea = stack.isEmpty() ? height.length*height[index]
                    : (height.length-stack.peek()-1)*height[index];
            max = Math.max(max,curArea);            
        }
        return max;
    }
}
