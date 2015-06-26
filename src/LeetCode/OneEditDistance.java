package LeetCode;

public class OneEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneEditDistance ins = new OneEditDistance();
		String s = "ab";
		String t = "abc";
		System.out.println(ins.isOneEditDistance(s, t)? "Y" : "N");
	}
	public boolean isOneEditDistance(String s, String t) {
        if(s == null ||t == null) {
            return false;
        }
        int sLen = s.length();
        int tLen = t.length();
        if(Math.abs(sLen-tLen) > 1) {
        	return false;
        }
        int diff = 0;
        if(sLen == tLen) {
        	for(int index=0; index<sLen; index++) {
        		if(diff > 1) {
        			return false;
        		}
        		if(s.charAt(index) != t.charAt(index)) {
        			diff++;
        		}
        	}
        	return diff == 1;
        }
        else {
        	int sIndex = 0;
        	int tIndex = 0;
        	while(sIndex < sLen && tIndex < tLen) {
        		if(diff > 1) {
        			return false;
        		}
        		if(s.charAt(sIndex) != t.charAt(tIndex)) {
        			diff++;
        			if(sLen > tLen) {
        				sIndex++;
        			}
        			else {
        				tIndex++;
        			}
        		}
        		else {
        			sIndex++;
        			tIndex++;
        		}
        	}
        	return true;
        }
        
    }
}
