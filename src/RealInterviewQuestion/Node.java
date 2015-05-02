package RealInterviewQuestion;

import java.util.ArrayList;
import java.util.List;

interface CompactTreeBuilder<T> {
 
    /**
     * Given a root of a tree. The tree may be of any depth and width,
     * i.e. each node may have any number of child nodes.
     * This method should transform a tree in such a way
     * that each node (except probably one) would either have N or 0 children
     * (and one node may have a number of children between 0 and N).
     *
     * Algorithm may transform given tree in any way with only condition:
     * if node A was an ascendant of node B in a source tree
     * node B may not be an ascendant of a node A in a result tree (they may become siblings though).
     *
     * E.g.
     *
     * source:        compact(A, 2)     compact(A, 1)             compact(A, 100)
     *
     * A               A                 A                         A
     *  |               |                 |_B                       |_B
     *  |_B             |_B                  |_C                    |
     *     |            |  |                    |_D                 |_C
     *     |            |  |_D                     |_E              |
     *     |            |  |                          |_F           |_D
     *     |_C          |  |_E                           |_G        |
     *     | |_D        |    |_H                            |_H     |_E
     *     |    |_F     |                                           |
     *     |            |_C                                         |_F
     *     |_E            |                                         |
     *       |_G          |_F                                       |_G
     *       |            |                                         |
     *       |_H          |_G                                       |_H
     *
     *
     *  in an example for compact(A,2) above node E is an exception node:
     *  it has 1 child while any other node has either 2 or 0 children
     */
    //Node<T> compact(Node<T> root, int N);
    
}
 
class Node<T> implements CompactTreeBuilder<T> {
 
    /*private final T data;
 
    private final List<Node<T>> children;
 
 
    public Node(T data, List<Node<T>> children) {
        this.data = data;
        this.children = children;
    }
 
    public T getData() {
        return data;
    }
 
    public List<Node<T>> getChildren() {
        return children;
    }

    @Override
    Node<T> compact(Node<T> root, int N) {
        if(root == null || N < 1) {
            return root;
        }
        List<T> valList = new ArrayList<T>();
        preorderTraversal(root, valList);
        if(valList == null && valList.size() > 0 ) {
            buildCompleteNaryTree(valList, N);
        }
        
    }

    private void preorderTraversal(Node<T> root, List<T> res) {
        if(root == null){
            return;
        }
        res.add(root.data);
        for(Node<T> elem : root.getChildren()) {
        	preorderTraversal(elem, res);
        }        
    } 

    private Node<T> buildCompleteNaryTree(List<T> list, int N) {
        Node<T> node = null;// = new Node<T>();
        if(list == null || list.size() == 0) {
            return node;
        }
        for(int i=0; i<list.size(); i++) {
            insertIntoNaryTree(list.get(i), N, node);
        }
    }

    private void insertIntoNaryTree(T data, int N, Node<T> node) {
    	Node<T> temp = new Node<T>(data, new ArrayList<Node<T>>());
    	if(node == null) {
    		node = temp;
    	}
    	else {
    		List<Node<T>> list = node.getChildren();
    		if(list.size() < N) {
    			list.add(temp);
    		}
    		else {
    			
    		}
    	}
    }

    Node<T> compact(Node<T> root, int N) {
        if(root == null || N < 1) {
            return root;
        }
        //Queue<Node<T>> queue = new Queue<Node<T>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        // l1 - length of nodes in current level; l2 - length of nodes in next level
        int l1 = 1, l2 = 0;
        while(!q.isEmpty()){
            Node<T> node = q.poll();
            if(node.getChildren().size())
            result.add(node.val);
            l1--;
            if(node.left != null){
                q.add(node.left);
                l2++;
            }
            if(node.right != null){
                q.add(node.right);
                l2++;
            }
            if(l1 == 0){
                l1 = l2;
                l2 = 0;
                results.add(new ArrayList<Integer>(result));
                result = new ArrayList<Integer>();
            }
        }
    }*/
}