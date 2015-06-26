package basicAlgorithms;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

 enum Suit {
	CLUBS, HEARTS, SPADES, DIAMONDS
}; 
 
public class Algo1 implements Inter {
	
	public static <E> void printArray( E[] inputArray )
	   {
	      // Display array elements              
	         for ( E element : inputArray ){        
	            System.out.printf( "%s ", element );
	         }
	         System.out.println();
	         
	    }
	
	public static void main(String[] args) {
		
		
		// without reflection
		Algo1 foo = new Algo1();
		foo.lengthOfLastWord("foo");
		 
		// with reflection
		Object foo2;
		try {
			foo2 = Class.forName("complete.classpath.and.Foo").newInstance();
			Method m;
			m = foo2.getClass().getDeclaredMethod("hello", new Class<?>[0]);
			m.invoke(foo2);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	
		
		Suit st = Suit.CLUBS;
		int a = 3;
		char b = '2';
		int c = a + b;
		char d = (char) (a + b);
		
		
		int abc = 3;
		int cba = - abc;
		System.out.println(cba);
		//Algo1 a = new Algo1();
		int[] inputArray = null; 
		Integer test = 3;
		if(test instanceof Integer) {
       	 System.out.println("yes");
        }
        else {
       	 System.out.println("no");
        }
		
		boolean t[] = new boolean[25];

		int[] a2 = {3,5};
	}
	public int lengthOfLastWord(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
		int i;
        int total = s.length();
        for(i = 0; i<total; i++){
        	if(s.charAt(total-i-1) == ' '){
        		break;
        	}
        }
        return i; 
    }
	
	 public int atoi(String str) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        // invalid
	    	int val = 0;
	    	boolean hasDigit = false;
	    	boolean hasSign = false;
	    	boolean isNegative = false;
	    	for(int i=0; i<str.length(); i++){
	    		char c = str.charAt(i);
	    		if( c==' '){
	    			if(!hasDigit){
	    				continue;	
	    			}
	    			else{
	    				return val;
	    			}
	    		}
	    		if((c=='+' || c=='-')&&hasSign){
	    			return 0;
	    		}
	    		if(c=='+'){
	    			hasSign = true;
	    		}
	    		if(c=='-'){
	    			hasSign = true;
	    			isNegative = true;
	    		}
	    		if(c>='0'&&c<='9'){
	    			val = val*10 + c - '0'; //to to
	    			hasDigit = true;
	    		}
	    		if((c<'0' || c>'9')&&hasDigit){
	    			if(isNegative){
	    				val = 0 - val;
	    			}
	    			return val;    			
	    		}
	    		else{
	    			return 0;
	    		}
	    	}
	    	if(isNegative){
	    		return 0 - val;
	    	}
	    	return val;
	        //
	    }
	 
	 public enum Planet {
		    MERCURY (3.303e+23, 2.4397e6),
		    VENUS   (4.869e+24, 6.0518e6),
		    EARTH   (5.976e+24, 6.37814e6),
		    MARS    (6.421e+23, 3.3972e6),
		    JUPITER (1.9e+27,   7.1492e7),
		    SATURN  (5.688e+26, 6.0268e7),
		    URANUS  (8.686e+25, 2.5559e7),
		    NEPTUNE (1.024e+26, 2.4746e7);

		    private final double mass;   // in kilograms
		    private final double radius; // in meters
		    Planet(double mass, double radius) {
		        this.mass = mass;
		        this.radius = radius;
		    }
		    private double mass() { return mass; }
		    private double radius() { return radius; }

		    // universal gravitational constant  (m3 kg-1 s-2)
		    public static final double G = 6.67300E-11;

		    double surfaceGravity() {
		        return G * mass / (radius * radius);
		    }
		    double surfaceWeight(double otherMass) {
		        return otherMass * surfaceGravity();
		    }
		    public static void main(String[] args) {
		        if (args.length != 1) {
		            System.err.println("Usage: java Planet <earth_weight>");
		            System.exit(-1);
		        }
		        double earthWeight = Double.parseDouble(args[0]);
		        double mass = earthWeight/EARTH.surfaceGravity();
		        for (Planet p : Planet.values())
		           System.out.printf("Your weight on %s is %f%n",
		                             p, p.surfaceWeight(mass));
		    }
		}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

