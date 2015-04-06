/**
 * http://www.programcreek.com/2013/02/java-design-pattern-iterator/
 */
package ObjectOrientedDesign;

interface IIterator {
	public boolean hasNext();
	public Object next();
}

interface IContainer {
	public IIterator createIterator();
}
public class RecordCollection implements IContainer {
	private String[] items = {"first", "second", "third"};	
	
	public IIterator createIterator() {
		RecordIterator iterator = new RecordIterator();
		return iterator;
	}
	
	private class RecordIterator implements IIterator{
		private int index;
		
		public boolean hasNext() {
			if(index < items.length) {
				return true;
			}
			return false;
		}

		public Object next() {
			if(this.hasNext()) {
				return items[index++];
			}
			return null;
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecordCollection collection = new RecordCollection();
		IIterator iterator = collection.createIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
