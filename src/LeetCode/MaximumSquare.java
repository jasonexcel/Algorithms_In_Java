package LeetCode;

/**
 * Created by Shaun on 9/24/2016.
 */
public class MaximumSquare {
    public static void main(String[] args) {
        MaximumSquare ins = new MaximumSquare();
        char[][] matrix = {{'1', '0', '1', '0'},{'1', '0', '1', '1',},{'1', '1', '1', '1'}};
        //char[][] matrix = {{'0', '1', '1'}, {'1', '1', '1'}};
        System.out.println(ins.maximalSquare(matrix));
    }
    //!!! dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
    public int maximalSquare(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }
}
