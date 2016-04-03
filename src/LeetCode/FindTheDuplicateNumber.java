package LeetCode;

public class FindTheDuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        return findDuplicateInRange(nums, 1, nums.length - 1);
    }
	
    private int findDuplicateInRange(int[] nums, int lBound, int rBound) {
        if(lBound >= rBound) {
            return rBound;
        }
        int mid = lBound + (rBound - lBound) / 2;
        int count = countLessThanOrEqual(nums, mid);
        if(count <= mid) {
            return findDuplicateInRange(nums, mid + 1, rBound);
        } else {
            return findDuplicateInRange(nums, lBound, mid);
        }
    }
    
    private int countLessThanOrEqual(int[] nums, int val) {
        int count = 0;
        for(int i : nums) {
            if(i <= val) {
                count++;
            }
        }
        return count;
    }
}
