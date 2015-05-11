/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String[] args) {
		GenerateParentheses ins = new GenerateParentheses();
		ins.generateParenthesis(2);
	}
	// np problem, catalan number C(n) = C(n, 2n)/(n+1)
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
		// !!!
		if (leftNum < pairs) {
			sb.append("(");
			generateStringDFS(pairs, leftNum + 1, rightNum, sb, results);
			sb.deleteCharAt(sb.length() - 1);
		}
		// !!!
		if (leftNum > rightNum) {
			sb.append(")");
			generateStringDFS(pairs, leftNum, rightNum + 1, sb, results);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	// another dfs, the order of the last two if statement is replaceable
	private void helper(int n, int left, int right, List<String> res, StringBuilder sb) {
        if(left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if(left > right) {
            sb.append(')');
            helper(n, left, right+1, res, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(left < n) {
            sb.append('(');
            helper(n, left+1, right, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
