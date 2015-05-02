package RealInterviewQuestion;

import java.util.concurrent.atomic.AtomicInteger;

//Atomic Integer is thread safe.

public class IntIdentifierGenerator {
	private static final AtomicInteger atInt = new AtomicInteger(1);
	
	private IntIdentifierGenerator() {}
	
	public int getInt() {
		return atInt.getAndIncrement();
	}
}
