package crackingTheCodingInterveiw150;

public class CC1_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str = "Mr John Smith     ";
        int length = 13;
        char[] arr = str.toCharArray();
        replaceSpacesInPlace(arr, length);
        for (char item : arr)
        System.out.print(item);
	}
	public static void replaceSpacesInPlace(char[] arr, int length) {
		int spaceCount=0, newLength;
		for (int index=0; index<length; index++){
			if(arr[index] == ' ')
				spaceCount++;
		}
		newLength = length + spaceCount*2;
		// gotcha
		arr[newLength] = '\0';
		for (int index=length-1; index>=0; index--){
			if(arr[index] == ' '){
				arr[--newLength] = '0';
				arr[--newLength] = '2';
				arr[--newLength] = '%';
			}
			else
				arr[--newLength] = arr[index];		
	    }
		
	}

}
