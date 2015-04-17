package LeetCode;

public class ValidPalindrome2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome2 ins = new ValidPalindrome2();
		if(ins.isPalindrome("aa")) {
			System.out.println("true");
		}
	}
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while(start < end) {
            if(!isAlphanumeric(s.charAt(start))) {
                start++;
                continue;
            }
            if(!isAlphanumeric(s.charAt(end))) {
                end--;
                continue;
            }
            if(Math.abs((int)(s.charAt(start) - s.charAt(end))) != 0 || Math.abs((int)(s.charAt(start) - s.charAt(end))) != 26) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char letter) {
        if(('a' <= letter && letter <= 'z') || ('A' <= letter && letter <= 'Z') || ('0' <= letter && letter <= '9')) {
            return true;
        } 
        return false;
    }
}
