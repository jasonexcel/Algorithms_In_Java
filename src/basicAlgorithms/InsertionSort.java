package basicAlgorithms;

public class InsertionSort {
	public static void main(String[] args) {
		Comparable[] array = {3, 7, 2, 5, 1};
		sort(array);
		for(Comparable e:array) {
			System.out.print(e + ", ");
		}
	}
	
	public static void sort(Comparable[] array) {
		int len = array.length;
		for (int i = 1; i < len; i++) {
			Comparable value = array[i];
			int pos = i;
			while(pos>0 && value.compareTo(array[pos-1])<0) {
					array[pos] = array[pos-1];
					pos--;
			}
			array[pos]=value;
			
		}
	}
}