package RealInterviewQuestion;

public class ConvertStringToLong {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long i = 0;
		try {
			i = stringToLong("-9223372036854775806");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("wrong");
			e.printStackTrace();
		}
		System.out.println(i);
		if (i == -123){
			// success
		}
		else{
			// failure
		}
	}

	private static long stringToLong(String s) throws Exception{
		/* code goes here to convert a string to a long*/
		if(s == null) {
			throw new Exception("null string");
		}
		s = trimString(s);
		if(s == null){
			throw new Exception("white space string");
		}
		int len = s.length();
		boolean valid = true;
		boolean pos = true;
		long result = 0;
		for(int i=0; i<len; i++){
			char c = s.charAt(i);
			if( i == 0){
				if(c == '-'){
					pos = false;
				}
				else if(c<'0' || c > '9'){
					valid = false;
				}
				else{
					result = (c - '0');
				}
			}
			else if(c<'0' || c > '9'){
				valid = false;
			}
			else{
				// considering the edge case: result is equal to the min value of long type 
				if(result == 0 - Long.MIN_VALUE/10 && c - '0' == 0 - Long.MIN_VALUE % 10 && pos == false){
					return Long.MIN_VALUE;
				}
				result = result*10 + c - '0';
				if(result<0){
					throw new Exception("the value is out of range");
				}
			}		
		}
		if(valid == false){
			throw new Exception("parsed invalid string");
		}
		else if(pos == false){
			return 0-result;
		}
		return result;
	}
	
	private static String trimString(String original){
		int head, tail;
		int len = original.length();
		StringBuilder sb = new StringBuilder();
		int i, j; // defined here instead of inner loop
		for(i = 0; i < len; i++){
			char c = original.charAt(i);				
			if(c != ' ') {
				break;
			}
		}
		if(i == len) {
			return null;
		}
		head = i;

		for(j = original.length()-1; j>=head; j--){
			char c = original.charAt(j);
			if(c != ' '){
				break;
			}				
		}
		tail = j;
		for(int k = head; k<=tail; k++){
			sb.append(original.charAt(k));
		}
		return sb.toString();
}
}
