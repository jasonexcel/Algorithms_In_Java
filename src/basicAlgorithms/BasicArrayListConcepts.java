package basicAlgorithms;

import java.util.ArrayList;

public class BasicArrayListConcepts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strA = new String();
		String strB = new String();
		strB = "";
		String strC = "";
		
		ArrayList<String> a;
		ArrayList<String> b = new ArrayList<String>();
		ArrayList<String> c = new ArrayList<String>();
		c.add(null);
		ArrayList<String> d = new ArrayList<String>();
		d.add("test");
		
		//tests
		// a is initiated, need to initiated first
		String bNull = b == null ? "b is null" : "b isn't null";
		String bEmpty = b.isEmpty() ? "b is empty" : "b isn't empty";
		String bSize = Integer.toString(b.size());
		String cNull = c == null ? "c is null" : "c isn't null";
		String cEmpty = c.isEmpty() ? "c is empty" : "c isn't empty";
		String cSize = Integer.toString(c.size());
		String dSize = Integer.toString(d.size());
		
		System.out.println(bNull);
		System.out.println(bEmpty);
		System.out.println("b size: " + bSize);
		System.out.println(cNull);
		System.out.println(cEmpty);
		System.out.println("c size: " + cSize);
		System.out.println("d size: " + dSize);
		
		//results
//		b isn't null
//		b is empty
//		b size: 0
//		c isn't null
//		c isn't empty
//		c size: 1
//		d size: 1
	}

}
