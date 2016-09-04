package basicAlgorithms;

import java.util.ArrayList;
import java.util.List;

class CharTreeNode {
	char val;
	CharTreeNode left;
	CharTreeNode right;

	public CharTreeNode(char val) {
		this.val = val;
	}
}
public class BinaryTreeSerialization {
	public static void main(String[] args) {
		char[] arr = {'a', 'b', '#', '#', 'c',  '#', '#'};
		//char[] arr = {'a', 'b', 'c', '#', '#',  '#', 'd', '#', '#'};

		int[] index = {0};
		CharTreeNode root = DeserializeTree(arr, index);
		List<Character> list = new ArrayList<Character>();
		SerializeTree(root, list);
		for(char c : list) {
			System.out.print(c);
			System.out.print(' ');
		}
		
	}
	// from array to tree
	public static CharTreeNode DeserializeTree(char[] arr, int[] index) {
		int i = index[0];
		if(i >= arr.length) {
			return null;
		}
		if(arr[i] == '#') {
			return null;
		}
		CharTreeNode cur = new CharTreeNode(arr[i]);
		index[0]++;
		cur.left = DeserializeTree(arr, index);
		index[0]++;
		cur.right = DeserializeTree(arr, index);
		return cur;		
	}
	// from tree to arraylist
	public static void SerializeTree(CharTreeNode cur, List<Character> list) {
		if(cur == null) {
			list.add('#');
		}
		else {
			list.add(cur.val);
			SerializeTree(cur.left, list);
			SerializeTree(cur.right, list);
		}
	}
}
