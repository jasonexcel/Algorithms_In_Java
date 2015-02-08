/**
 * Implement int sqrt(int x).

Compute and return the square root of x.
 */
package LeetCode;

/**
 * @author Shaun
 *
 */
public class SqrtX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SqrtX ins = new SqrtX();
		int res = ins.sqrt(7);
		System.out.print(res);
	}
    public int sqrt(int x) {
        if(x <= 0){
        	return 0;
        }
        int min = 1;
        int max = x/2+1;
        while(min<=max){
        	int mid = (min+max)/2;
        	//use division not multiplication
        	if(x/mid>mid){
        		//!!!
        		if(x/(mid+1)<(mid+1)){
        			return mid;
        		}
        		else{
        			min = mid + 1;
        		}
        	}
        	else if(x/mid<mid){
        		max = mid - 1;
        	}
        	else{
        		return mid;//!!!
        	}
        }
        return max;
    }
    
    //newton method: equation a[n+1]=(a[n]+x/a[n])/2
    public int sqrtII(int x) {
        if (x == 0) return 0;
        double lastY = 0;
        double y = 1;
        while (y != lastY)
        {
            lastY = y;
            y = (y + x / y) / 2;
        }
        return (int)(y);
    }
}
