/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: 
 * get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
package LeetCode;

import java.util.HashMap;

/**
 * http://www.cnblogs.com/springfor/p/3869393.html
 *
 */
public class LRUCache {
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;
	
	public LRUCache(int capacity) {
	    this.capacity = capacity;
	    len = 0;
	}
	
	public int get(int key) {
	    if (map.containsKey(key)) {
	        DoubleLinkedListNode latest = map.get(key);
	        removeNode(latest);
	        setHead(latest); //last visit, so set as head
	        return latest.val;
	    } else {
	        return -1;
	    }
	}
	//o(1) time complexity to remove any node for double linked list
	public void removeNode(DoubleLinkedListNode node) {
	    DoubleLinkedListNode cur = node;
	    DoubleLinkedListNode pre = cur.pre;
	    DoubleLinkedListNode post = cur.next;
	
	    if (pre != null) {
	        pre.next = post;
	    } 
	    else {
	        head = post;
	    }
	
	    if (post != null) {
	        post.pre = pre;
	    } 
	    else {
	        end = pre;
	    }
	}
	//put current node as head
	public void setHead(DoubleLinkedListNode node) {
	    node.next = head;
	    node.pre = null;
	    if (head != null) {
	        head.pre = node;
	    }
	
	    head = node;
	    if (end == null) {
	        end = node;
	    }
	}
	
	public void set(int key, int value) {
	    if (map.containsKey(key)) {
	        DoubleLinkedListNode oldNode = map.get(key);
	        oldNode.val = value;
	        removeNode(oldNode);
	        setHead(oldNode);
	    }
	    else {
	        DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
	        if (len < capacity) {
	            setHead(newNode);
	            map.put(key, newNode);
	            len++;
	        } 
	        else {
	            map.remove(end.key); //remove from map
	            end = end.pre; // set new end
	            if (end != null) {
	                end.next = null;
	            }
	
	            setHead(newNode);
	            map.put(key, newNode); //add into hash map
	        }
	    }
	}
}
	
class DoubleLinkedListNode {
	public int val;
	public int key;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode next;
	
	public DoubleLinkedListNode(int key, int value) {
	    val = value;
	    this.key = key;
	}
}
