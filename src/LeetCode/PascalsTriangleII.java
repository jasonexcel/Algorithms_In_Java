package LeetCode;
import java.util.ArrayList;
public class PascalsTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []res = new int[rowIndex+1];
        res[0]=1;
        if(rowIndex==0) return getList(res);
        for(int j=1;j<rowIndex+1;j++){
            for(int i=j-1;i>0;i--){
                res[i]=res[i]+res[i-1];
            }
            res[j]=1;
        }
        return getList(res);
    }
    
    public ArrayList<Integer> getList(int[] nums){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            res.add(nums[i]);
        }
        return res;
    }
}
