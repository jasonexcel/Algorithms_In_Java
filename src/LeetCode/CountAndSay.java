package LeetCode;

public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countAndSay(2);
		countAndSayII(2);
	}
	public static String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		StringBuilder sb = new StringBuilder();
        sb.append('1');
        for(int i=1; i<n;i++){
            StringBuilder s2 = new StringBuilder();
            int j = 0,k = 0;
            for( ; j<sb.length(); j++){
                
                if (sb.charAt(j) == sb.charAt(k)){
                    continue;
                }
                
                if(sb.charAt(j) != sb.charAt(k)){
                    int count = j-k;
                    if(count<10){
                        s2.append(count);
                        s2.append(sb.charAt(k));
                    }
                    k = j;                    
                }
            }  
            s2.append(j-k);
            s2.append(sb.charAt(k));
            sb = new StringBuilder(s2.toString());
        }
        return sb.toString(); 
    }
	public static String countAndSayII(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		StringBuilder sb = new StringBuilder();
        sb.append(1);
        for(int i = 1; i < n; i++){
        	StringBuilder s2 = new StringBuilder();
        	int count = 1;
        	char cur = sb.charAt(0);
        	for(int j = 1; j < sb.length(); j++){
        		if(sb.charAt(j) == cur){
        			count++;
        			continue;
        		}
        		else{
        			s2.append(count);
        			s2.append(cur);
        			cur = sb.charAt(j);
        			count = 1;
        		}
        	}
        	s2.append(count);
        	s2.append(sb.charAt(sb.length()-1));
        	sb = s2;
        }
        return sb.toString();
    }
}
