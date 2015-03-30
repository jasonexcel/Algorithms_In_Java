package ObjectOrientedDesign;
//thread safe
public class AmericaPresident {
	private static final AmericaPresident thePresident = new AmericaPresident();
 
	private AmericaPresident() {
		
	}
 
	public static AmericaPresident getPresident() {
		return thePresident;
	}
}