package LeetCode;

public class IncreasingTripletSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean increasingTriplet(int[] nums) {
        if( nums == null || nums.length < 3) {
            return false;
        }
        int globalFirst = nums[0];
        int globalSecond = Integer.MAX_VALUE;
        int local = nums[0];
        for(int i=1; i<nums.length; i++) {
                if(nums[i] > globalSecond) {
                    return true;
                }
                else if(nums[i] > globalFirst) {
                    globalSecond = nums[i];
                }
                else if(nums[i] > local) {
                    globalFirst = local;
                    globalSecond = nums[i];
                }
                else if(nums[i] < local) {
                    local = nums[i];
                }
            
        }
        return false;
    }

}
