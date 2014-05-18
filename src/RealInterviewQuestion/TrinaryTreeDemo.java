package RealInterviewQuestion;

class Node{
	int val; // value
	public Node lNode; // left node
	public Node mNode; // middle node
	public Node rNode; // right node
	
	public boolean deleted;
	public Node(int value){
		val = value;
	}
}

class TrinaryTree{
	private Node root;
	
	public TrinaryTree(){
		root = null;
	}
	
	// using iterative method
	public void insert(int value){
		Node temp = new Node(value);
		if(root == null){
			root = temp;
		}
		else{
			Node cur = root;
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
	
	private Node deleteValue(Node node, int value){
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
			Node min = minNode(node.rNode);
			node.val = min.val;
			node.rNode = deleteValue(node.rNode, min.val);
		}		
		return node;
		
	}
	
	public void display(){
		displayTree(root);
	}	
	
	private Node minNode(Node node){
		
		while(node != null){
			if(node.lNode != null){
				node = node.lNode;
			}
		}
		return node;
	}	
	
	private void displayTree(Node node){
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
