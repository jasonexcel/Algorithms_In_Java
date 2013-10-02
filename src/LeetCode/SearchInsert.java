package LeetCode;

public class SearchInsert {
	public static void main(String[] args) {
		int[] A = {1,3};
		System.out.println( searchInsert(A, 2));
	}
	public static int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a = 0, b = A.length -1;
        while(a<=b) {
            int mid = (a+b)/2;
            if(A[mid] > target) {
                b = mid-1;
                continue;
            }
            else if(A[mid] < target) {
                a = mid+1;
                continue;
            }
            else{
                return mid;
            }
        }
        return a;
    }

}
