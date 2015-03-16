package basicAlgorithms;

public class MergeThreeSortedArrays {
	public int[] Merges(int[] A, int[] B, int[] C) {
		int size = A.length + B.length + C.length;
		int[] res = new int[size];
		int tempSize = A.length + B.length;
		if(tempSize == 0) {
			return C;
		}
		int[] tempRes = new int[tempSize];
		tempRes = mergeTwoSortedArrays(A, B);
		res = mergeTwoSortedArrays(C, tempRes);
		return res;
	}

	private int[] mergeTwoSortedArrays(int[] Arr1, int[] Arr2) {
		if(Arr1.length == 0 && Arr2.length == 0) {
			return null;
		}
		int len1 = Arr1.length, len2 = Arr2.length;
		int[] result = new int[len1 + len2];
		int i =0,  j = 0;
		while(i < len1 && j < len2) {
			if(Arr1[i] > Arr2[j]){
				result[i+j] = Arr2[j];
				j++;
			}
			else {
				result[i+j] = Arr1[i];
				i++;
			}
		}
		while(i < len1) {
			result[i+j] = Arr1[i];
			i++;
		}
		while(j < len2) {
			result[i+j] = Arr2[j];
			j++;
		}
		return result;
	}
}