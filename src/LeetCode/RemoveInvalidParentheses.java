package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://discuss.leetcode.com/topic/30743/easiest-9ms-java-solution
 * Here I share my DFS or backtracking solution. It's 10X faster than optimized BFS.

 Limit max removal rmL and rmR for backtracking boundary.
 Otherwise it will exhaust all possible valid substrings, not shortest ones.
 Scan from left to right, avoiding invalid strs (on the fly) by checking num of open parens.
 If it's '(', either use it, or remove it.
 If it's ')', either use it, or remove it.
 Otherwise just append it.
 Lastly set StringBuilder to the last decision point.
 In each step, make sure:
 i does not exceed s.length().
 Max removal rmL rmR and num of open parens are non negative.
 De-duplicate by adding to a HashSet.
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int rmL = 0; // minimum number of '(' to be removed
        int rmR = 0; //minimum number of ')' to be removed
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                rmL++;
            }
            if(s.charAt(i) == ')') {
                if(rmL > 0) {
                    rmL--;
                }
                else {
                    rmR++;
                }
            }
        }

        // open: ( plus 1, ) minus 1 --- open means the open parentheses
        DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<>(res);
    }

    public void DFS(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
        if(i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        // open can not be negative
        if(i == s.length() || rmL < 0 || rmR < 0 || open < 0) {
            return;
        }

        char c = s.charAt(i);
        int len = sb.length();

        if(c == '(') {
            // remove it
            DFS(res, s, i + 1, rmL - 1, rmR, open, sb);
            // append it
            DFS(res, s, i + 1, rmL, rmR, open + 1, sb.append(c));

        } else if(c == ')') {
            // do not use it
            DFS(res, s, i + 1, rmL, rmR - 1, open, sb);
            // append it
            DFS(res, s, i + 1, rmL, rmR, open - 1, sb.append(c));

        } else {
            // other letter
            DFS(res, s, i + 1, rmL, rmR, open, sb.append(c));
        }

        sb.setLength(len);  // or sb.deleteCharAt(sb.length() - 1);
    }
}
