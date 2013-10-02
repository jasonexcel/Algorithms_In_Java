package LeetCode;

public class ClimbChairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(1));
	}
	public static int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] a = new int[n+1];
        int i = 2;
        a[0] = 1;
        a[1] = 1;
        while(i<=n){
            a[i] = a[i-1] + a[i-2];
            i++;
        }
        return a[n];
    }

}
