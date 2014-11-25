package basicAlgorithms;

//Reverse singly linked list
/*
 * pre -> 1 -> 2 -> 3 -> 4
 * pre -> 2 -> 1 -> 3 -> 4
 * pre -> 3 -> 2 -> 1 -> 4
 * pre -> 4 -> 3 -> 2 -> 1
 * so pre has never been changed, head always has value 1
 * each step head.next was cut and insert into between pre and pre.next 
 * */
public class ReverseLinkedList {
	public class ListNode{
		int val;
		ListNode next = null;
		public ListNode(int value){
			val = value;
			next = null;
		}
	}
	
	public ListNode reverseLinkedList(ListNode head){
		if(head == null){
			return head;
		}
		ListNode pre = new ListNode(0);
		pre.next = head;
		while(head.next!=null){
			//store
			ListNode nextNext = head.next.next;
			//cut and insert
			head.next.next = pre.next;
			// cut and link
			pre.next = head.next;
			// move first item(head) forward
			head.next = nextNext;
		}
		return pre.next;
	}
	
	public static void main(String[] args){
		ReverseLinkedList ins = new ReverseLinkedList();
		//ListNode dummy =  new ReverseLinkedList(). new ListNode(0); //it also works
		ListNode dummy =  ins. new ListNode(0);
		ListNode head = ins. new ListNode(1);
		dummy.next = head;
		for(int i=2; i<=5; i++){
			head.next = ins. new ListNode(i);
			head = head.next;
		}
		ListNode test = ins.reverseLinkedList(dummy.next);
		for(int i=1; i<=5; i++){
			System.out.print(test.val + "->");
			test = test.next;
		}
		System.out.println('e');
	}
}
