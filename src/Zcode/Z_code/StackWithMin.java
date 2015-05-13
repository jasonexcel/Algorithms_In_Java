package Zcode.Z_code;
import java.util.*;

/**
 * @param args
 * 实现一个数据结构包含三个功能，push， pop， getmin，time complexity均要为O(1)， 不可以调用API，自己实现了double linkedlist，而且要求只用一个list
 */

public class StackWithMin<T> extends MyStack<T> implements Comparable<T>{

	MyStack<T> ms;
	public StackWithMin() {
		ms = new MyStack<T>();
	}
	
	public void push(T val) {
		Comparator<T> comp = new Comparator<T>() {
			@Override
			public int compare(T n1, T n2) {
				return n1.hashCode() - n2.hashCode();
			}
		};	
		// demo only
		if(val.hashCode() <= min().hashCode()) {
			ms.push(val);
		}
		super.push(val);
	}
	
	public T pop() {
		T val = super.pop();
		if(val == min()) {
			ms.pop();
		}
		return val;
	}
	
	public T min() {
		if(ms.empty()) {
			throw new IllegalArgumentException();
		}
		else {
			return ms.peek();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class MyStack<T> {
	LinkedList<T> nodes;
	//T element;
	int size;
	
	public MyStack() {
		this.nodes = new LinkedList<T>();
		this.size = 0;
	}
	public void push(T ele) {
		this.nodes.addFirst(ele);
		size++;		
	}
	
	public T pop() {
		if(size > 0) {
			size--;
			return nodes.poll();
		}
		throw new IllegalArgumentException();
	}
	
	public T peek() {
		return nodes.peek();
	}
	public boolean empty() {		
		return size == 0;
	}
}
