package LeetCode;
import java.util.ArrayList;
import java.util.List;
public class PascalsTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalsTriangleII ins = new PascalsTriangleII();
		ins.getRow(2);
		System.console();
	}
	public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0) {
            return new ArrayList<Integer> ();
        }
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        
        for(int r=1; r<=rowIndex; r++) {
        	List<Integer> res = new ArrayList<Integer>();
            res.add(1);
            for(int c=1; c<r; c++) {
                res.add(pre.get(c-1) + pre.get(c));
            }
            res.add(1);
            pre = res;
        }
        return pre;
    }
	
    public ArrayList<Integer> getRowII(int rowIndex) {
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
