package LeetCode;

public class HouseRobber {

	public HouseRobber() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int rob(int[] num) {
        int max = 0;
        if(num == null) {
            return max;
        }
        int maxPrePre = 0;
        int maxPre = 0;
        for(int i=0; i<num.length; i++) {
            int takenI = maxPrePre + num[i];
            max = Math.max(maxPre, takenI);
            maxPrePre = maxPre; // max[i-2] move 1 step forward
            maxPre = max; // max[i-1] move forward
        }
        return max;
    }
}
