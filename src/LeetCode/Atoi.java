package LeetCode;

public class Atoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int atoi(String s) {
        s = s.trim();
        long value = 0;
        boolean isPositive = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                if (s.charAt(i) == '-') {
                    isPositive = false;
                }
                continue;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9') 
            	break;
            
            value = 10 * value + s.charAt(i) - '0';
            
            if(value > Integer.MAX_VALUE && !isPositive) {
                    return  -1*Integer.MIN_VALUE;
                }
            if(value >=Integer.MAX_VALUE && isPositive) {
                    return Integer.MAX_VALUE;
                }
        }
        value = isPositive == true ? value : value * -1;

        return (int) value;
        
    }

}
