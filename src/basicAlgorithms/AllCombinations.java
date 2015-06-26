package basicAlgorithms;

import java.util.*;

public class AllCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = {"a", "b", "c"};
		
		// recursive method
		List<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		List<String> res = new ArrayList<String>();
		combHelper(results, res, 0, arr);
		
		
		// iterative method
		List<ArrayList<String>> resultsII = new ArrayList<ArrayList<String>>();
		ArrayList<String> resII = new ArrayList<String>();
		resultsII.add(resII);
		for(int i=0; i<arr.length; i++) {
			//List<ArrayList<String>> temp2 = new ArrayList<ArrayList<String>>(resultsII);
			int len = resultsII.size();
			for(int j=0; j<len; j++) {
				ArrayList<String> temp = new ArrayList<String>(resultsII.get(j));
				temp.add(arr[i]);
				resultsII.add(temp);
			}
		}
		resultsII.remove(0); // remove empty one at index 0
		// print them
		System.out.println(results.size()+" groups");
		for(ArrayList<String> list : results) {
			for(String str : list) {
				if(str == null || str.length() == 0) {
					System.out.print(" null, ");
				}
				else {
					System.out.print(str+", ");
				}
			}
			System.out.println();
		}
		
		System.out.println(resultsII.size()+" groups");
		for(ArrayList<String> list : resultsII) {
			for(String str : list) {
				if(str == null || str.length() == 0) {
					System.out.print(" null, ");
				}
				else {
					System.out.print(str+", ");
				}
			}
			System.out.println();
		}
	}
	
	
	public static List<ArrayList<String>>  recursiveComb(String[] arr) {
		List<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		List<String> res = new ArrayList<String>();
		combHelper(results, res, 0, arr);
		return results;
	}
	private static void combHelper(List<ArrayList<String>> results, List<String> res, int step, String[] arr) {
		for(int i=step; i<arr.length; i++) {
			res.add(arr[i]);
			step++;
			combHelper(results, res, step, arr);
			res.remove(res.size()-1);
		}
		ArrayList<String> temp = new ArrayList<String>(res);
		if(temp.size() > 0) {
			results.add(temp);
		}		
		return;
	}

}
