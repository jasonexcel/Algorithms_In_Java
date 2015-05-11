package Zcode.Z_code;

import java.util.*;

public class GenerateIfElsePairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		List<List<String>> list = generation(n);
		for(List<String> l : list) {
			for(String s : l) {
				System.out.print(s);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> generation(int n) {
		List<List<String>> results = new ArrayList<List<String>>();
		if(n < 1) {
			return results;
		}
		List<String> l = new ArrayList<String>();
		generateStringDFS(n, 0, 0, l, results);
		return results;
	}
	private static void generateStringDFS(int pairs, int leftNum, int rightNum,
			List<String> l, List<List<String>> results) {
		if (leftNum + rightNum == pairs * 2) {
			results.add(new ArrayList<String>(l));
			return;
		}
		// !!!
		if (leftNum < pairs) {
			l.add("IF");
			generateStringDFS(pairs, leftNum + 1, rightNum, l, results);
			l.remove(l.size() - 1);
		}
		// !!!
		if (leftNum > rightNum) {
			l.add("ELSE");
			generateStringDFS(pairs, leftNum, rightNum + 1, l, results);
			l.remove(l.size() - 1);
		}
	}
}
