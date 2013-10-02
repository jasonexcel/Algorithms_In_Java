package LeetCode;

public class ContainsWithMostWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxArea(int[] height) {
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
