package RealInterviewQuestion;
import java.util.*;


public class LinkedListDeepIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
 class DeepIterator implements Iterator<Integer> {
	private Stack<Iterator> iteratorStack = new Stack<Iterator>();
	private Integer top = null;

	public DeepIterator(Iterable iterable){
		this.iteratorStack.push(iterable.iterator());
	}

	@Override
	public boolean hasNext() {
		if(this.top != null) return true;

		while(!this.iteratorStack.isEmpty()) {
			Iterator tmpIterator = this.iteratorStack.peek();

			if(tmpIterator.hasNext()){
				Object tmp = tmpIterator.next();
				if(tmp instanceof Integer){
					this.top = (Integer) tmp;
					return true;
				} else if(tmp instanceof Iterable){
					this.iteratorStack.push(((Iterable) tmp).iterator());
				} else {
					throw new RuntimeException("Unsupported data type. ");
				}
			} else {
				this.iteratorStack.pop();
			}
		}
		return false;
	}

	@Override
	public Integer next() throws NoSuchElementException {
		if(hasNext()){
			Integer tmp = this.top;
			this.top = null;
			return tmp;
		}

		throw new NoSuchElementException();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("This is not supported right now.");
	}
 }
 
 class DeepIteratorII implements Iterator<Object>{

	    private Stack<Object> stack;

	    public DeepIteratorII(List<Object> list) {
	        stack = new Stack<Object>();
	        stack.push(list);
	        advanceToNext();
	    }

	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    public Object next() {
	        if (!hasNext())
	            throw new RuntimeException("no next");

	        int result = (Integer) stack.pop();
	        advanceToNext();
	        
	        return result;
	    }

	    //@SuppressWarnings("unchecked")
	    // !!! go deep into the list, until find the next integer or stack is empty
	    // at the same time, open the list, reversely push element into stack
	    private void advanceToNext() {
	        while (!stack.isEmpty() && !(stack.peek() instanceof Integer)) {
	        	// not empty, top element is not integer
	            Object obj = stack.pop();
	            if (obj == null)
	                continue;

	            @SuppressWarnings("unchecked")
				List<Object> cur = (List<Object>) obj;
	            // reversely push element in the list into the stack
	            for (int i = cur.size() - 1; i >= 0; i--)
	                stack.push(cur.get(i));
	        }
	    }

	    
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		// use dfs method instead of stack to get all elements
		private void dfs(List<Object> cur, List<Integer> res) {
	        if(cur.size() == 0) {
	            return;
	        }
	        for(Object item : cur) {
	        	if(item instanceof Integer) {
		        	res.add((Integer) item);
		        	
		        }
	        	else if(item instanceof List) {
	        		dfs((List<Object>) item, res);
	        	}
	        	else {
	        		throw new IllegalArgumentException();
	        	}
	        }
	    }
	}
 
 