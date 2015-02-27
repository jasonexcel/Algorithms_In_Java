/**
 * 
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shaun
 *
 */


//Definition for undirected graph.
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};


public class CloneGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// BFS, time complexity o(n), space complexity o(n)
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	    if(node==null)
	        return null;
	    LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
	    map.put(node,copy);
	    queue.offer(node);
	    while(!queue.isEmpty())
	    {
	        UndirectedGraphNode cur = queue.poll();
	        for(int i=0;i<cur.neighbors.size();i++)
	        {
	        	// check for visited or not, if visited, do not add into queue
	            if(!map.containsKey(cur.neighbors.get(i)))
	            {
	                copy = new UndirectedGraphNode(cur.neighbors.get(i).label);
	                map.put(cur.neighbors.get(i),copy);
	                queue.offer(cur.neighbors.get(i));
	            }
	            //always build the neighbors for clone graph node
	            map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));
	        }
	    }
	    return map.get(node);
	}
	// my dfs solution
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
		if(node == null) {
			return null;
		}
		Stack<UndirectedGraphNode> s = new Stack<UndirectedGraphNode>();
		s.push(node);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		map.put(node, new UndirectedGraphNode(node.label));
		while(!s.isEmpty()) {
			UndirectedGraphNode cur = s.pop();
			for(int i=0; i<cur.neighbors.size(); i++) {
				UndirectedGraphNode temp = cur.neighbors.get(i);
				if(!map.containsKey(temp)) {
					s.push(temp);
					map.put(temp, new UndirectedGraphNode(temp.label));
				}
				UndirectedGraphNode copy = map.get(temp); //!
				map.get(cur).neighbors.add(copy); //!!! add the copy not new node here
			}
		}
		return map.get(node);		
	}
	// recursive method
	public UndirectedGraphNode cloneGraphRecursion(UndirectedGraphNode node) {
	    if(node == null)
	        return null;
	    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
	    map.put(node,copy);
	    helper(node,map);
	    return copy;
	}
	private void helper(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map)
	{
	    for(int i=0;i<node.neighbors.size();i++)
	    { 
	        UndirectedGraphNode cur = node.neighbors.get(i);
	        if(!map.containsKey(cur))
	        {
	            UndirectedGraphNode copy = new UndirectedGraphNode(cur.label);
	            map.put(cur,copy);
	            helper(cur,map);
	        }
	        map.get(node).neighbors.add(map.get(cur));
	    }
	}
}
