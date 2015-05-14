/**
 * 
 */
package Zcode.Z_code;

/**
 * @author sjia
 *Generate Unique Integer，要求 scalable
 * implements API return unique Integer Identifier，对return的结果要求就是integer, unique
 * 
 * --
 * 用 UUID 结合 client IP、timestamp 以及 
thread ID，类似这样

def generate_unique_integer():
    return uuid() << 96 + ip << 64 + timestamp << 32 + thread_id
 */
public class UniqueIDGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
