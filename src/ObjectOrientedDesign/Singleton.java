package ObjectOrientedDesign;

// private constructor; constant instance; static get method
//thread safe
public class Singleton {
	//holder, lazy loading
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}
	
	//constructor
	private Singleton() {};
	
	//get method
	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}

//thread safe
class AmericaPresidentII {
	private static final AmericaPresidentII thePresident = new AmericaPresidentII();

	private AmericaPresidentII() {
		
	}

	public static AmericaPresidentII getPresident() {
		return thePresident;
	}
}