package basicAlgorithms;

public class CopyLinkedList {

	class Node<T> {
		T val;
		Node<T> next;
		public Node(T value) {
			val = value;
			next = null;
		}
	}
	public CopyLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public Node<Integer> Copy(Node<Integer> head){
		if(head == null) {
			return null;
		}
		Node<Integer> newHead = new Node<>(head.val);
		Node<Integer> cur = newHead;
		head = head.next;
		while(head != null) {
			cur.next = new Node<Integer>(head.val);
			cur = cur.next;
			head = head.next;
		}
		return newHead;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyLinkedList ins = new CopyLinkedList();
		Node<Integer> head = ins.new Node<Integer>(1);
		head.next = ins.new Node<Integer>(2);
		head.next.next = ins.new Node<Integer>(3);
		ins.Copy(head);
	}

}

