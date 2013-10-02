package LeetCode;

public class ValidNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3.35e+2";
		if(isNumber(s))
			System.out.println("true");
	}
	public static boolean isNumber(String s) {
		   if(s==null)
		        return false;
		    char[] sArr = s.trim().toCharArray();

		    if(sArr.length==0)
		        return false;
		    if(sArr.length==1&&!Character.isDigit(sArr[0]))
		        return false;

		    boolean decimalFound = false;
		    boolean eFound = false;
		    int end = sArr.length-1;
		    for(int i=0;i<=end;i++){        
		        char nextChar = i>=end?'x':sArr[i+1];
		        char prevChar = i<=0?'x':sArr[i-1];
		        switch(sArr[i]){
		        case '+':
		        case '-':
		            if(prevChar!='e'&&i!=0)
		                return false;
		            if(prevChar=='e'&&i==end)
		                return false;
		            if (i==0&&nextChar=='e')
		                return false;
		            break;
		        case '.':
		            if(decimalFound || eFound)
		                return false;
		            if(i>=end && i<=0)
		                return false;
		            if(!Character.isDigit(prevChar) && !Character.isDigit(nextChar))
		                return false;
		            decimalFound = true;
		            break;
		        case 'e':
		            if(eFound)
		                return false;
		            if(!Character.isDigit(prevChar) && !Character.isDigit(nextChar)
		                &&nextChar!='-'|| end==i || i==0){
		                        return false;                        
		            }
		            eFound = true;
		            break;
		        case ' ':
		            return false;
		        default:
		            if(!Character.isDigit(sArr[i]))
		                return false;
		        }

		    }
		    return true;
		}

}
