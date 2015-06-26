package Zcode.Z_code;


import java.util.Iterator;
import java.util.Stack;

/**
 * Input: A binary search tree, consisting of integers.  And a number k
Output: True if there are two nodes a and b in the tree, such that a.value + b.value = k
            False otherwise
             time: O(n), space: O(logn)
 * @author sjia
 *
 */
//http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
public class TwoSumBalancedBST {

	private Node root;

	private class Node {
		private int key;
		private Node left;
		private Node right;

		public Node(int key) {
			this.key = key;
			left = null;
			right = null;
		}

		public String toString() {
			return Integer.toString(key);
		}
	}

	public void put(int key) {
		root = insertNode(root, key);
	}

	private Node insertNode(Node n, int key) {
		if (n == null)
			n = new Node(key);
		if (key < n.key)
			n.left = insertNode(n.left, key);
		else if (key > n.key)
			n.right = insertNode(n.right, key);
		else
			n.key = key;
		return n;
	}

	private class InorderIterator implements Iterator<Node> {

		private Stack<Node> list;

		public InorderIterator(Node node) {
			list = new Stack<Node>();
			Node tNode = node;
			while (tNode != null) {
				list.push(tNode);
				tNode = tNode.left;
			}
		}

		@Override
		public boolean hasNext() {
			return list.size() != 0;
		}

		@Override
		public Node next() {
			assert (hasNext());
			Node tNode = list.pop();
			Node nNode = tNode.right;
			while (nNode != null) {
				list.push(nNode);
				nNode = nNode.left;
			}
			return tNode;
		}

		@Override
		public void remove() {
			// do nothing
		}

		public int peek() {
			assert (hasNext());
			return list.peek().key;
		}
	}

	private class ReverseInOrder implements Iterator<Node> {

		private Stack<Node> list;

		public ReverseInOrder(Node root) {
			list = new Stack<Node>();
			Node tNode = root;
			while (tNode != null) {
				list.push(tNode);
				tNode = tNode.right;
			}
		}

		@Override
		public boolean hasNext() {
			return list.size() != 0;
		}

		@Override
		public Node next() {
			assert (hasNext());
			Node tNode = list.pop();
			Node cNode = tNode.left;
			while (cNode != null) {
				list.push(cNode);
				cNode = cNode.right;
			}
			return tNode;
		}

		@Override
		public void remove() {
			// do nothing
		}

		public int peek() {
			assert (hasNext());
			return list.peek().key;
		}
	}

	public boolean isPairPresent(int target) {
		return isPairPresent(root, target); 
		//|| isPairPresent(root.left, target)
				//| isPairPresent(root.right, target);
	}

	private boolean isPairPresent(Node x, int target) {
		InorderIterator inOrder = new InorderIterator(x);
		ReverseInOrder rInOrder = new ReverseInOrder(x);
		while (inOrder.hasNext() && rInOrder.hasNext()) {
			int inOrderVal = inOrder.peek();
			int rInOrderVal = rInOrder.peek();
			if (inOrderVal >= rInOrderVal)
				break;
			int sum = inOrderVal + rInOrderVal;
			if (sum == target) {
				System.out.println("Pair:" + inOrderVal + "," + rInOrderVal);
				return true;
			} else if (sum < target)
				inOrder.next();
			else
				rInOrder.next();
		}
		return false;
	}

	public static void main(String[] args) {
		TwoSumBalancedBST tree = new TwoSumBalancedBST();
		tree.put(15);
		tree.put(10);
		tree.put(20);
		tree.put(8);
		tree.put(12);
		tree.put(16);
		tree.put(25);
		System.out.println("Is sum pair present:" + tree.isPairPresent(24));
	}
}