/**
 * implement strStr().

Returns the index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.
 */
package LeetCode;

/**
 * @author Shaun
 *
 */
public class ImplementStrStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = " This is a test Test.";
		String needle = " test ";
		ImplementStrStr ins = new ImplementStrStr();
		System.out.println(ins.strStr(haystack, needle));
	}
	//my solution, O(m*n), O(1) space
	public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        if(hLen < nLen){
        	return -1;
        }
        if(nLen == 0 || hLen == 0){
        	return 0;
        } 
        for(int i=0; i<hLen; i++){
        	//compare the length here, important, otherwise the time limit may exceed 
        	if(hLen - i < nLen){
        		break;
        	}
        	if(haystack.charAt(i) != needle.charAt(0)){
        		continue;
        	}
        	else if(matchHN(haystack.substring(i+1), needle.substring(1))){
        			return i;
        		}

        }       
        return -1;
        
    }
    private boolean matchHN(String h, String n){
    	if(n == null){
    		return true;
    	}
    	else if(h == null){
    		return false;
    	}
    	int hLen = h.length();
    	int nLen = n.length();
    	if(hLen < nLen){
    		return false;
    	}
    	for(int i=0; i<nLen; i++){
    		if(h.charAt(i) != n.charAt(i)){
    			return false;
    		}
    	}
    	return true;
    }
    
    //simplified, but return string here
    public String strStrII(String haystack, String needle) {
        if(haystack==null || needle == null || needle.length()==0)
            return haystack;
        if(needle.length()>haystack.length())
            return null;
        for(int i=0;i<=haystack.length()-needle.length();i++)
        {
            boolean successFlag = true;
            for(int j=0;j<needle.length();j++)
            {
                if(haystack.charAt(i+j)!=needle.charAt(j))
                {
                    successFlag = false;
                    break;
                }
            }
            if(successFlag)
                return haystack.substring(i);
        }
        return null;
    }
}
