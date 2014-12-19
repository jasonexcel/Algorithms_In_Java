/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaun
 * 
 */
public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// my solution
	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if (n < 0) {
			return res;
		}
		int[] arr = new int[(int) Math.pow(2, n)];
		arr[0] = 0;
		res.add(0);
		for (int i = 1; i <= n; i++) {
			int s = (int) Math.pow(2, i - 1);
			int e = (int) Math.pow(2, i) - 1;
			for (int j = s; j <= e; j++) {
				// s is also the increment
				arr[j] = arr[e - j] + s;
				res.add(arr[j]);
			}
		}
		return res;
	}

	public ArrayList<Integer> grayCodeII(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n < 0)
			return res;
		if (n == 0) {
			res.add(0);
			return res;
		}
		res.add(0);
		res.add(1);
		for (int i = 2; i <= n; i++) {
			int size = res.size();
			for (int j = size - 1; j >= 0; j--) {
				res.add(res.get(j) + (1 << (i - 1)));
			}
		}
		return res;
	}
}
