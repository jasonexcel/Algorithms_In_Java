/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
package LeetCode;

public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num == null || num.length == 0){
            return;
        }   
    	//2, 3, 6, 5, 4, 1 as the example
        // find the val = 3, then find the 4 at index j = 4
        // swap 3 with 4, reverse {6, 5, 3, 1}
        //2, 4, 1, 3, 5, 6
        int i;
        for(i=num.length-2; i>=0; i--){ 
        	// rule: for any index i [0, i-2], num[i]>=num[i+1], not meet the rule then break the loop
        	//consider condition: 1, 1, 5, 
        	// the chance to break or swap is num[i]<num[i+1], even though they are equal,
        	// the goal of swap is to get a greater value
            if(num[i]<num[i+1]){            
            	break;
            }
        }
        // no chance to break: for example, 3,2,1 or 3,2,2
        if(i<0){
            reverse(num, 0, num.length-1);
            return;
        }
        //i is the break point
        int val = num[i];
        int j;
        //this for loop is to find the min value from ‘i+1' to end which is also greater than val
        for(j=i;j<=num.length-2;j++){
        	//when we find j, where num[j]>val && val>=num[j+1], break
            if(val>=num[j+1]){
                break;
            }
        }
        // we find j, do swap
        swap(num, i, j);
        //reverse the right side to achieve the lowest permutation
        reverse(num, i+1, num.length-1);
        return;
       }
       
   //reverse the array between 'from' to 'to'
   private void reverse(int[] num, int from, int to){
       while(from<to){
           swap(num, from, to);
           from++;
           to--;
       }
   }
   // swap the value of array at index a and b
   private void swap(int[] num, int a, int b){
       int temp = num[a];
           num[a] = num[b];
           num[b] = temp;
   }
}
