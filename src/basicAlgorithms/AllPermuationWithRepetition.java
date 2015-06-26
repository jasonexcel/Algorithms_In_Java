/**

 * 
 */

package basicAlgorithms;
import java.util.*;
/**
 * @author Shaun
 *
 */
public class AllPermuationWithRepetition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = {'a', 'b', 'c'};
		List<ArrayList<Character>> results = new ArrayList<ArrayList<Character>>();
		List<Character> res = new ArrayList<Character>();
		int k = 3; // length
		boolean[] used = new boolean[arr.length];
		permutationHelper(results, res, arr, 0, used, k);
		for(List<Character> list : results) {
			for(char c : list) {
				System.out.print(c + " ");				
			}
			System.out.println();
		}
		System.out.println(results.size());
	}

	private static void permutationHelper(List<ArrayList<Character>> results, List<Character> res, char[] arr, int cur, boolean[] used, int k) {
		if(res.size() == k) {
			results.add(new ArrayList<Character>(res));
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(i>0 && arr[i] == arr[i-1] && !used[i-1]) {
				continue;
			}
			else if(!used[i]){
				res.add(arr[i]);
				used[i] = true;
				permutationHelper(results, res, arr, i, used, k);
				res.remove(res.size()-1);
				used[i] = false;
			}
		}
	}
}
