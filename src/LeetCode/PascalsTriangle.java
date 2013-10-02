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
            cur.add(1);
            ArrayList<Integer> pre = result.get(i-1);
            int curVal;
            for(int j = 1; j<i; j++){
                curVal = pre.get(j-1) + pre.get(j);
                cur.add(curVal);                
            }
            cur.add(1);
            result.add(cur);
        }
        return result;
    }

}
