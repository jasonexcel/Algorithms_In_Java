/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */
package LeetCode;

/**
 * 
 *
 */
public class MedianOfTwoSortedArrays {
	//O(m+n) time complexity, o(m+n) space complexity -- can be optimized to o(1) 
    public double findMedianSortedArrays(int A[], int B[]) {
        double res = 0;
        if((A == null || A.length == 0) && (B == null || B.length == 0)){
        	return 0;
        }
        
        int lenA = A.length, lenB = B.length;
        int[] arr = new int[(lenA+lenB)/2+1];

        int i=0, j=0;
        while(i+j<=(lenA+lenB)/2 && i<lenA && j<lenB){
        	if(A[i]>=B[j]){
                arr[i+j] = B[j];
        		j++;
        	}
        	else{
                arr[i+j] = A[i];
        		i++;
        	}
        }
        while(i+j<=(lenA+lenB)/2 && i<lenA){
        	arr[i+j] = A[i];
        	i++;
        }
        while(i+j<=(lenA+lenB)/2 && j<lenB){
        	arr[i+j] = B[j];
            j++;
        }
        if((lenA+lenB)%2 == 1){
            res = arr[(lenA+lenB)/2];
        }
        else{
        	res = (arr[(lenA+lenB)/2-1] + arr[(lenA+lenB)/2])/2.0;
        }
        return res;
    }
    
    // o(log((m+n)/2)) time complexity and space complexity
    public double findMedianSortedArraysII(int A[], int B[]) {
        if((A.length+B.length)%2==1){
        	//odd number, find the (k+1)th 
        	return helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1);
        }
        else{
        	//even, average kth and (k+1)th
        	return (helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2)  
                   +helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1))/2.0;
        }
    }
    // k represents the kth element of joint array, starting from 1
    private int helper(int A[], int B[], int aStart, int aEnd, int bStart, int bEnd, int k)
    {
        int m = aEnd-aStart+1; // m -- length of new A[] 
        int n = bEnd-bStart+1; // n -- length of new B[]
        if(m>n){
        	//swap A and B, to make sure m <= n
        	return helper(B,A,bStart,bEnd,aStart,aEnd,k);
        }
            
        if(m==0){
        	// new A[] is empty
        	return B[bStart+k-1];
        }
        if(k==1){
        	//return the sorted first one
        	return Math.min(A[aStart],B[bStart]);
        }
            
        int posA = Math.min(k/2,m);
        int posB = k-posA; // make sure posA + posB = K
        if(A[aStart+posA-1]==B[bStart+posB-1]){
        	return A[aStart+posA-1];
        }           
        else if(A[aStart+posA-1]<B[bStart+posB-1]){
        	//A[aStart+posA-1] is not included, but B[bStart+posB-1] is
        	return helper(A,B,aStart+posA,aEnd,bStart,bStart+posB-1,k-posA);
        }            
        else{
        	return helper(A,B,aStart,aStart+posA-1,bStart+posB,bEnd,k-posB);
        }
            
    }
}
