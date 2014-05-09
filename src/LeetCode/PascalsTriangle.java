package LeetCode;
import java.util.ArrayList;
public class PascalsTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(3));
	}
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows<=0) return result;
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1); // first one
        result.add(array); // first row
        for(int i = 1; i<numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            // add first one in the row
            cur.add(1);
            ArrayList<Integer> pre = result.get(i-1);
            int curVal;
            for(int j = 1; j<i; j++){
                curVal = pre.get(j-1) + pre.get(j);
                cur.add(curVal);                
            }
            // add last one in the row
            cur.add(1);
            result.add(cur);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> generateII(int numRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
           if(numRows < 0){
            return null;
        }
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();

        int[][] val = new int[numRows][numRows];        
        for(int i=0; i<numRows; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            val[i][0] = 1;
            row.add(val[i][0]);
            for(int j=1; j<i+1; j++){
                val[i][j] = val[i-1][j-1] + val[i-1][j];
                row.add(val[i][j]);
            }
            pascal.add(row);

        }
        return pascal;
    }

}
