package LeetCode;

public class SwapNodesInPairs {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode ln = new ListNode(0);
        ln.next = head;
        ListNode start = ln;
        while(head != null && head.next != null) {
        	// 技巧：从链表最左边逐渐开始修改指向结点；最后再向前移动结点本身
            start.next = head.next;
            head.next = head.next.next;
            start.next.next = head;
            start = head;
            head = head.next;
        }
        
        return ln.next;
    }

}
