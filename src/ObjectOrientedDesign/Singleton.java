package ObjectOrientedDesign;
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
