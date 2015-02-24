/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
package LeetCode;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        boolean[] repeat = new boolean[256];
	}
	public class ListNode{
		int val;
		ListNode next;
		public ListNode(int x){
			val = x;
			next = null;
		}
	}
	//time complexity: o(n), space complexity: O(1)
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
        ListNode res = new ListNode(0);
        ListNode result = res; //!!!!
        int carry=0;
        while(l1!= null && l2!=null){
            int temp =  l1.val+l2.val+carry;
            res.next = new ListNode(temp%10);
            carry = temp/10;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;

        }
        while(l1 !=null){
            int temp = l1.val+carry;
            res.next = new ListNode(temp%10);
            carry = temp/10;
            res = res.next;                        
            l1 = l1.next;
        }
        while(l2!=null){
        	int temp = l2.val+carry;
            res.next = new ListNode(temp%10);
            carry = temp/10;
            res = res.next;                        
            l2 = l2.next;
        }
        if(carry==1){
            res.next = new ListNode(carry);
        }

        return result.next;
    }
}
