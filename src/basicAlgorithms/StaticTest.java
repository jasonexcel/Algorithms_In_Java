package basicAlgorithms;

public class StaticTest {
	 
	static class A {
		static void method(){
			System.out.println("A:method()");
		}
	}
	
	static class B extends A{
		static void method(){
			System.out.println("B:method()");
		}
	}
	
	public static void main(String[] args) {
		// test1
		test1(new A());
		A a = new A();
		if(a instanceof A) {
			System.out.println('a');
		}
		test1(new B());
		// test2(new A());
		test2(new B());
		
		// these are always predictable.
		A.method();
		B.method();
	}
	
	// Here is a nasty way to get yourself into a lot
	// of trouble down the line. Imagine what would
	// happen if you invoked a function this way,
	// and some time in the future someone changed
	// the type signature of your function from A to B.
	
	public static void test1(A a){
		a.method(); // always outputs "A:method()"
	}
	
	public static void test2(B b){
		b.method(); // always outputs "B:method()"
	}
	
}

