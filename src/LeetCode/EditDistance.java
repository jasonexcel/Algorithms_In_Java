/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

 * http://www.cnblogs.com/springfor/p/3896167.html
 * 1. x==y，那么不用做任何编辑操作，所以dp[i][j] = dp[i-1][j-1]

2. x != y

   (1) 在word1插入y， 那么dp[i][j] = dp[i][j-1] + 1

   (2) 在word1删除x， 那么dp[i][j] = dp[i-1][j] + 1

   (3) 把word1中的x用y来替换，那么dp[i][j] = dp[i-1][j-1] + 1

 最少的步骤就是取这三个中的最小值。

最后返回 dp[word1.length+1][word2.length+1] 即可。
 * http://blog.csdn.net/linhuanmars/article/details/24213795 
 */
package LeetCode;

/**
 * @author Shaun
 * 
 */
public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//my solution
	//O(m*n) time complexity, O(n^2) space
	public int minDistance(String word1, String word2){
		int rowSize = word1.length();
		int colSize = word2.length();
		if(rowSize == 0){
			return colSize;
		}
		if(colSize == 0){
			return rowSize;
		}
		int res[][] = new int[rowSize+1][colSize+1];
		for(int i=0; i<=rowSize; i++){
			res[i][0] = i;
		}
		for(int j=0; j<=colSize; j++){
			res[0][j] = j;
		}
		for(int i=1; i<=rowSize; i++){
			for(int j=1; j<=colSize; j++){
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					res[i][j] = res[i-1][j-1];
				}
				else{
					int addLetterToWord1 = res[i][j-1] + 1;
					int deleteFromWord1 = res[i-1][j] + 1;
					int replaceLetterInWord1 = res[i-1][j-1] + 1;
					int temp = addLetterToWord1 < deleteFromWord1 ? addLetterToWord1 : deleteFromWord1;					
					res[i][j] = temp < replaceLetterInWord1 ? temp : replaceLetterInWord1;
				}
			}
		}
		return res[rowSize][colSize];
	}
	//O(m*n) time complexity, O(n) space
	public int minDistance1D(String word1, String word2) {
		if (word1.length() == 0){
			return word2.length();
		}
		if (word2.length() == 0){
			return word1.length();
		}
		
		//find the min to save space
		String minWord = word1.length() > word2.length() ? word2 : word1;
		String maxWord = word1.length() > word2.length() ? word1 : word2;
		int[] res = new int[minWord.length() + 1];
		for (int i = 0; i <= minWord.length(); i++) {
			//initialization
			res[i] = i;
		}
		for (int i = 0; i < maxWord.length(); i++) {
			int[] newRes = new int[minWord.length() + 1];
			//newRes is the next row of res
			newRes[0] = i + 1;
			for (int j = 0; j < minWord.length(); j++) {
				if (minWord.charAt(j) == maxWord.charAt(i)) {
					newRes[j + 1] = res[j];
				} else {
					newRes[j + 1] = Math.min(res[j],
							Math.min(res[j + 1], newRes[j])) + 1;
				}
			}
			//res are assigned newRes results
			res = newRes;
		}
		return res[minWord.length()];
	}
}
