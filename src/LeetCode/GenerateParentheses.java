package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> results = new ArrayList<String>();
		if (n <= 0) {
			return results;
		}
		StringBuilder sb = new StringBuilder();
		generateStringDFS(n, 0, 0, sb, results);
		return results;
	}

	private void generateStringDFS(int pairs, int leftNum, int rightNum,
			StringBuilder sb, List<String> results) {
		if (leftNum + rightNum == pairs * 2) {
			results.add(sb.toString());
			return;
		}
		if (leftNum < pairs) {
			sb.append("(");
			generateStringDFS(pairs, leftNum + 1, rightNum, sb, results);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (leftNum > rightNum) {
			sb.append(")");
			generateStringDFS(pairs, leftNum, rightNum + 1, sb, results);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
