/**
 * Career Cup: 2.1 Write code to remove duplicates from an unsorted linked list 
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
package crackingTheCodingInterveiw150;

import java.util.Hashtable;

public class CareerCup2_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node newNode = new Node('d');
		newNode.appendToTail('b');
		newNode.appendToTail('c');
		newNode.appendToTail('a');
		newNode.appendToTail('c');
		newNode.appendToTail('d');
		newNode.appendToTail('a');
		newNode.appendToTail('d');
		newNode.appendToTail('d');
		newNode.appendToTail('d');

	    //removeDuplicate(newNode);
	    removeDulicateByHashTable(newNode);
	    newNode.printNodes();
        
	}
	// O(n^2) time, O(1) space, no buffer allowed
	public static void removeDuplicate(Node head) {
		Node ln = head;
		Node ln2;
		while(ln!=null){
			ln2 = ln;
			while(ln2.next!=null){
				if(ln.c == ln2.next.c){
					ln2.next = ln2.next.next;
				}
				else{
					ln2 = ln2.next;
				}
			}
			ln = ln.next;
		}
	}
	// hashtable method, O(n) time complexity,
	public static void removeDulicateByHashTable(Node ln) {
		//!!! 
		Node previous = null;
		Hashtable<Character, Boolean> tbl = new Hashtable<Character, Boolean>();
		while(ln!=null){
			if(tbl.containsKey(ln.c)){
				previous.next = ln.next;
			}
			else{
				tbl.put(ln.c, true);
				previous = ln;
			}
			ln = ln.next;
		}
	}
}

class Node{
	char c;
	Node next = null;
	
	public Node(char character){
		this.c = character;
	}
	public void appendToTail(char ch){
		Node newNode = new Node(ch);
		Node n = this;
		while(n.next!=null){
			n = n.next;
		}
		n.next = newNode;
	}
	
	public void printNodes(){
		Node n = this;
		while(n!=null){
			System.out.print(n.c + " ");
			n = n.next;
		} 
	}
	
}
