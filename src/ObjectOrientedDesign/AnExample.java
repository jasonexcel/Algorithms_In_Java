/**
 * 
 */
package ObjectOrientedDesign;

/**
 * @author Shaun
 *
 */
 interface testInterface {
	public String getItem(int id); 
	public static final double PI = 3.14; // good way
	int r = 4; // bad way
	
}
public class AnExample extends Test implements testInterface{

	/**
	 * 
	 */
	public AnExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double piTest = testInterface.PI;
		double area = piTest * testInterface.r;
		System.out.println(area);
		System.console();
	}

	@Override
	public String getItem(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void testSignature() {
		// TODO Auto-generated method stub
		
	}

}

abstract class Test {
	abstract void testSignature();
}
