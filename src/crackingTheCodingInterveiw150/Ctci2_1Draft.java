package crackingTheCodingInterveiw150;
import java.util.*;
public class Ctci2_1Draft {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeClass node = new NodeClass('d');
		node.appendToTail('f');
		node.appendToTail('o');
		node.appendToTail('f');
		node.appendToTail('f');
		node.appendToTail('o');
		node.appendToTail('f');
		node.appendToTail('f');
		node.appendToTail('o');
		node.appendToTail('f');
				
		 removeDuplicates(node);
		node.printChars();

	}
	
	public static void removeDuplicates(NodeClass node){
		Hashtable<Character, Character> ht = new Hashtable<Character, Character>();
		NodeClass prev = null;
		
		while(node != null) {
			if(ht.containsKey(node.c)) {
				prev.next = node.next;
			}
			else {
				ht.put(node.c, node.c);
				prev = node;
			}

			node = node.next;
		}
	}
}

class NodeClass {
	char c;
	NodeClass next = null;
	public NodeClass(char c){
		this.c = c;
	}
	
	public void appendToTail(char newChar){
		NodeClass node = this;
		NodeClass endNode = new NodeClass(newChar);
		while(node.next != null){
			node = node.next;
		}
		node.next = endNode;
	}
	
	public void printChars(){
		NodeClass node = this;
		while(node != null){
			System.out.print(node.c + " ");
			node = node.next;
		}
	}
}
		
	
