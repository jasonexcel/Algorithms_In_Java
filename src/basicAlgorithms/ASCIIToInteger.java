package basicAlgorithms;
/*
 * 1. 这个字符串是否是空的。
2. 这个字符串是否有非法字符（非0-9之间的字符）。
3.这个数是正数或者是负数的情况（第一个字符是否为+，-）。
4. 是否存在溢出的情况（这个比较难考虑到）。*/
public class ASCIIToInteger {
	public static long atoi(String str) throws Exception {
		
		boolean negative = false;
		long value = 0;
		
		if (str == null || str.equals("")) {
			throw new Exception("null string or the string has no character!");
		} 
		
		for (int i = 0; i < str.length(); i++) {
			if (i == 0 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
				if (str.charAt(0) == '-') {
					negative = true;				
				}
			} else {
				if (str.charAt(i) >= '0' && '9' >= str.charAt(i)) {
					value = value * 10 + (str.charAt(i) - '0');
					if (value > Integer.MAX_VALUE) {
						throw new Exception("OUT OF INTEGER RANGE");
					}
				} else {
					throw new NumberFormatException("not an integer");
				}
			}
		}
		return negative == true ? value * -1 : value; 			
	}

}
