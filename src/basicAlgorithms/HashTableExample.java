/**
 * 
 */
package basicAlgorithms;
import java.util.Collection;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Shaun
 *
 */
class HashTableExample {

	/**
	 * @param args
	 */
	
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  Hashtable<String, Integer> numbers
		     = new Hashtable<String, Integer>();
		   numbers.put("one", 1);
		   numbers.put("two", 2);
		   numbers.put("three", 3);
		   numbers.get("one");
		   numbers.containsKey("three");
		   numbers.containsValue(2);
		   numbers.containsValue("2");
		   numbers.size();
		   
 		   Collection v = numbers.values();
 		   
 		   HashMap<Integer, String> str = new HashMap<Integer, String>();
 		   str.put(1, "number1");
 		   str.put(2, "number2");
 		  str.put(3, "number2");
 		  for (Integer set : str.keySet()){
 			  
 		  }
 		  for (Map.Entry <Integer, String> entry : str.entrySet()){
 			  entry.getValue();
 			  entry.getKey();
 		  }
 		  for (String strVal : str.values()){
 			  
 		  }
 		  Set set = str.entrySet();
 		   System.out.println(str.get(2));
 	}
}
