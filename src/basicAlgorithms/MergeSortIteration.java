package basicAlgorithms;

import java.util.Arrays;

public class MergeSortIteration {
	public static int min(int a, int b) {
		if (a <= b)
			return a;
		else
			return b;
	}

	public static void merge(double[] a, int iLeft, int iMiddle, int iRight,
			double[] tmp) {
		int i, j, k;

		i = iLeft;
		j = iMiddle;
		k = iLeft;

		while (i < iMiddle || j < iRight) {
			if (i < iMiddle && j < iRight) { // Both array have elements
				if (a[i] < a[j])
					tmp[k++] = a[i++];
				else
					tmp[k++] = a[j++];
			} else if (i == iMiddle)
				tmp[k++] = a[j++]; // a is empty
			else if (j == iRight)
				tmp[k++] = a[i++]; // b is empty
		}
	}

	public static void sort(double[] a, double[] tmp) {
		int width;

		for (width = 1; width < a.length; width = 2 * width) {

			// Combine sections of array a of width "width"

			int i;

			for (i = 0; i < a.length; i = i + 2 * width) {
				int left, middle, right;

				left = i;
				middle = min(i + width, a.length); //!!! to avoid non-existing members
				right = min(i + 2 * width, a.length); //!!!

				merge(a, left, middle, right, tmp); //pass tmp to the merge method to reduce garbage 
			}

			for (i = 0; i < a.length; i++)
				a[i] = tmp[i]; // Copy tmp to a for next iteration

			System.out.println("After 1 iter: " + Arrays.toString(a));
		}

	}
}