package LeetCode;

public class UniquePath {

	/**
	 * @param args
	 */
	public static int MAX =101;
    int[][] cache = new int[MAX][MAX];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePath up = new UniquePath();
		System.out.println(up.uniquePaths(100,2));

	}
        public int uniquePaths(int m, int n) {
            // Start typing your Java solution below
            // DO NOT write main() function
            if(m<=0 || n<=0) return 0;
            if(m == 1 && n == 1) return 1;
            if(cache[m][n] != 0)         return cache[m][n];
            cache[m][n] = uniquePaths(m-1,n) + uniquePaths(m,n-1);

            return cache[m][n];
        }
        // Dynamic programming approach
        public int uniquePaths2(int m, int n) {
            // Start typing your Java solution below
            // DO NOT write main() function
            int[][] mat = new int[m+1][n+1];
            // important
            mat[0][1] = 1;

            for(int i =1; i<=m; i++)
                for(int j = 1; j<=n; j++){
                    mat[i][j] = mat[i-1][j] + mat[i][j-1];
                }
                
                return mat[m][n];
        }
		// math methods, need to consider the overflow of long integer
		 public int uniquePaths3(int m, int n) {
			// IMPORTANT: Please reset any member data you declared, as
			// the same Solution instance will be reused for each test case.
			if(m==1 || n==1){
				return 1;
			}
			int greater = m>n ? m : n;
			int less = m<n ? m : n;
			// math equation: val = (m+n-2)!/(m-1)!*(n-1)!)
			long val = calFactorial(greater-1, m+n-2)/calFactorial(1, less-1);
			return (int)val;
		}
		private long calFactorial(int lower, int upper){
			long val = 1;
			for(int i=lower+1; i<=upper; i++){
				val *= i;
			}
			return val;
		}
}
