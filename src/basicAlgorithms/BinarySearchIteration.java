package basicAlgorithms;

public class BinarySearchIteration {
	public static void main(String[] args) {
		int[] arrayList = {3, 5, 7, 7, 12};
		int val = 2;
		int location = search(arrayList, val);
		System.out.println(location);
	}
	
	public static int search(int[] list, int key) {
		int begin = 0, end = list.length-1;
		while (begin <= end) {
			int mid = begin + (end - begin) / 2;
			if (list[mid] < key)
				begin = mid + 1;
			else if (list[mid] > key)
				end = mid - 1;
			else
				return mid;
		}
		return -begin-1;
	}
}
