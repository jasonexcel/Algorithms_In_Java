package LeetCode;

public class ZigZagConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String convert(String s, int nRows) {
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
