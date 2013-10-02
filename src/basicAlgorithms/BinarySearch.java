package basicAlgorithms;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrayList = {1, 3, 4, 7, 8, 12, 13, 58};
		int val = 58;
		System.out.print(binary_search(arrayList, 0, 4, val));
	}
	
	public static int search(int[] list, int head, int tail, int value) {
		if (head >= tail) {
			if (list[(head + tail)/2] == value)
				return (head+tail)/2;	
			else return -head-1;
		}
	
		else if (list[(head + tail)/2] < value) {
			return search(list, (head + tail)/2 +1, tail, value);
		}
		else  if (list[(head + tail)/2] > value)
			return search(list, head, (head + tail)/2 - 1, value);
		else 
			return (head+tail)/2;

	}
	
	public static   int binary_search(int A[],  int imin, int imax, int key)
    {
        while (imax > imin)
        {
                int imid = (imin + imax) / 2;
                if (A[imid] < key)
                    imin = imid + 1;
                else
                    imax = imid - 1;
        }
        if((imax == imin) && (A[imin] == key))
             return imin;
        else
             return -1;
    }
}
