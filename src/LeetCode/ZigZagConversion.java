package LeetCode;

public class ZigZagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// my solution, time complexity : O(len), space: O(1)
	public String convert(String s, int nRows) {
        if(s == null || s.length() == 0) {
            return s;
        }
        if(nRows < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i=0; i<len; i+=2*nRows-2) {
            sb.append(s.charAt(i));
        }
        
        for(int row=1; row<nRows-1; row++) {
            //assume first column for current row is evenColumn, 0-based counting
            boolean oddColumn = false;
            for(int index=row; index<len;) {
                sb.append(s.charAt(index));
                if(oddColumn) {
                    index += 2*row;
                    oddColumn = false;
                }
                else{
                    index += 2*(nRows-1-row);//move from  even column to odd column
                    oddColumn = true;
                }
            }
        }
        for(int i=nRows-1; i<len; i+=2*nRows-2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
	
    public String convertII(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null) return null;
        if(nRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        // minSize should not be zero
        int minSize = (nRows -1)*2;
        for(int i = 0; i<nRows; i++){
            int j = 0;
            if(i == 0){                
                while(minSize*j<s.length()){
                    sb.append(s.charAt(minSize*j));
                    j++;
                }
            }
            else if(i == nRows-1){
                j = 0;
                while(minSize*j + nRows-1<s.length()){
                    sb.append(s.charAt(minSize*j + nRows-1));
                    j++;
                }
            }
            else{
                j = 0;
                while(minSize*j + i < s.length()){
                    sb.append(s.charAt(minSize*j + i));
                    if(minSize*(j+1) - i < s.length()){
                        sb.append(s.charAt(minSize*(j+1)-i));
                    }
                    j++;
                }
            }            
        }
        
        return sb.toString();
    }
}
