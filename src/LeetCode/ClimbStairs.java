/**
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
package LeetCode;

public class ClimbStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ClimbStairs1(1));
	}
	//o(n) time complexity, o(1) space complexity
    public static int ClimbStairs1(int n){
        if(n<1){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else if(n == 2){
            return 2;
        }
        int a1 = 1;
        int a2 = 2;
        int a = 0;
        for(int i=3; i<=n; i++){
            a = a1 + a2;
            a1 = a2;
            a2 = a;
        }
        return a;
    }
    //o(n) space
	public static int climbStairs2(int n) {
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
//    public static int climbStair3(int n){
//        //same as calculating fibnacci number
//    }
}
