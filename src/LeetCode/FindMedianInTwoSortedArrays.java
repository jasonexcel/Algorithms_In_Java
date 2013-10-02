package LeetCode;

public class FindMedianInTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayA = {};
		int[] arrayB = {2,5};
		System.out.println(findMedianSortedArrays(arrayA, arrayB));
		

	}
	
	public static double findMedianSortedArrays(int a[], int b[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int sizeA = a.length;
    	int sizeB = b.length;
        if (sizeA == 0 && sizeB == 0) {
            return 0.0;
        }
        else if(sizeA == 0) {
            return findMedianInArray(b);
        }
        else if (sizeB ==0) {
            return findMedianInArray(a);
        }
		double temp = 0.0;
		// even 
		if ((sizeA + sizeB)%2 == 0) {

			int indexA = 0;
			int indexB = 0;
			for(int i=0; i<=(sizeA+sizeB)/2; i++){
				if(a[indexA] < b[indexB]) {
					if(i == (sizeA + sizeB)/2 -1){
						temp+= a[indexA];	
					}
					if(i == (sizeA + sizeB)/2 ){
						temp+= a[indexA];	
					}
					indexA ++;
				
				}
				else{

					if(i == (sizeA + sizeB)/2 -1){
						temp+= b[indexB];
					}
					if(i == (sizeA + sizeB)/2 -1){
						temp+= b[indexB];	
					}
					indexB++;
					
				}
			}
			return temp/2;
		}
		// odd
		else {
			int indexA = 0;
			int indexB = 0;
			for(int i=0; i<=(sizeA+sizeB)/2 ; i++){
				if(a[indexA] < b[indexB]) {				
					if (i == (sizeA+sizeB)/2) {
						temp = a[indexA];
						break;
					}
					indexA++;
					
				}
				else{
					if (i == (sizeA+sizeB)/2) {
						temp = b[indexB];
						break;
					}			
					indexB++;
					
				}

			}
			return temp;
		}
        
    }
    
    private static double findMedianInArray(int[] c) {
        int sizeC = c.length;
        if (sizeC % 2 == 0) {
            return (c[sizeC/2-1] + c[sizeC/2])/2.0;
        }
        else{
            return c[sizeC/2];
        }
    }

}
