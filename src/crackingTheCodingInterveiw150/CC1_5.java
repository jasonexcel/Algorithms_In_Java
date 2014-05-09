package crackingTheCodingInterveiw150;

public class CC1_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String str = getCompressedString("aabeeeeeee");                                                                                                        
        	 System.out.print(str);



	}             
	
	public static String getCompressedString(String str) {
		int size = countCompression(str);
		if(str.length()<= size)
			return str;
		char[] compressedString = new char[size];
		int count = 1;
		char last = str.charAt(0);
		int charIndex = 0;
		for (int index=1; index<str.length(); index++) { 
			if(last == str.charAt(index))
				count++;
			else{
				charIndex = setArray(last, count, compressedString, charIndex);
				count = 1;
				last = str.charAt(index);
			}
		}
		setArray(last, count, compressedString, charIndex);
		return String.valueOf(compressedString);
	}
	
	private static int countCompression(String str){
		int count = 1;
		int last=str.charAt(0);
		int size = 0;
		for(int i=1; i<str.length(); i++){
			if(str.charAt(i)==last){
				count++;
			}
			else{
				size += 1 + String.valueOf(count).length();
				count = 1;
				last = str.charAt(i);				
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	static int setArray(char last, int count, char[] compressedString, int charIndex){
		char[] numbers = String.valueOf(count).toCharArray();
		compressedString[charIndex++] = last; 
        for(char item : numbers) {
        	compressedString[charIndex++] = item;
        }
		
		return charIndex;
	}

}
