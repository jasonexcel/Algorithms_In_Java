package RealInterviewQuestion;

class Node2{
	int val; // value
	public Node2 lNode; // left node
	public Node2 mNode; // middle node
	public Node2 rNode; // right node
	
	public boolean deleted;
	public Node2(int value){
		val = value;
	}
}

class TrinaryTree{
	private Node2 root;
	
	public TrinaryTree(){
		root = null;
	}
	
	// using iterative method
	public void insert(int value){
		Node2 temp = new Node2(value);
		if(root == null){
			root = temp;
		}
		else{
			Node2 cur = root;
			while(true){
				if(value < cur.val){
					if(cur.lNode == null){
						cur.lNode = temp;
						return;
					}
					cur = cur.lNode;
				}
				else if(value == cur.val){
					if(cur.mNode == null){
						cur.mNode = temp;
						return;
					}								
					cur = cur.mNode;					
				}
				else{
					if(cur.rNode == null){
						cur.rNode = temp;
						return;
					}
					cur = cur.rNode;					
				}				
			}			
		}
	}
	
	public void delete(int value){
		deleteValue(root, value);
	}
	
	private Node2 deleteValue(Node2 node, int value){
		if(node == null) {
			return null;
		}
		if(value < node.val){
			node.lNode = deleteValue(node.lNode, value);
		}
		else if(value > node.val){
			node.rNode = deleteValue(node.rNode, value);
		}
		else if(node.mNode != null){
			node.mNode = deleteValue(node.mNode, value);
		}
		else if(node.lNode == null){
			node = node.rNode;
		}
		else if(node.rNode == null){
			node = node.lNode;
		}
		else{
			// find the node with minimum value in the right children  
			Node2 min = minNode(node.rNode);
			node.val = min.val;
			node.rNode = deleteValue(node.rNode, min.val);
		}		
		return node;
		
	}
	
	public void display(){
		displayTree(root);
	}	
	
	private Node2 minNode(Node2 node){
		
		while(node != null){
			if(node.lNode != null){
				node = node.lNode;
			}
		}
		return node;
	}	
	
	private void displayTree(Node2 node){
		if(node != null){			
			displayTree(node.lNode);
			System.out.print(node.val + ", ");
			displayTree(node.mNode);
			displayTree(node.rNode);
		}
	}
}

public class TrinaryTreeDemo{
	public static void main(String[] args){
		int[] arr = {5,4,9,5,7,2,2, 8, 3, 13, 7, 10, 6, 14, 1, 4};
		TrinaryTree tt = new TrinaryTree();
		for(int i=0; i<arr.length; i++){
			tt.insert(arr[i]);
		}
		
		tt.display();
		System.out.println("\n");
		int[] del = {6, 3};
		for(int i=0; i<del.length; i++){
			tt.delete(del[i]);
		}
		tt.display();		
	}
}
