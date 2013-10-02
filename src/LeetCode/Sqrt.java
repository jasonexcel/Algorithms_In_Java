package LeetCode;

public class Sqrt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt2(2147395599)+" " + Math.sqrt(2147395599));
	}
	public static int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<=0) return 0;
        if(x == 1) return 1;
        int min = 1;
        int max = (int) (x>Math.sqrt(Integer.MAX_VALUE)? Math.sqrt(Integer.MAX_VALUE):x);
        int mid;
        while(min < max){
            mid = (min + max)/2;
            if(mid*mid>x){
                max = mid;
            }
            else if (min * mid == x || (mid+1)*(mid+1) > x){
                return mid;
            }
            else {
                min = mid+1;
            }
                
        }
        return (min+max)/2;
    }    
	public static int sqrt2(int x){
		if(x<=0) return 0;
        if(x == 1) return 1;

        double last = 1.0;
        while(true){
            double val = last/2 +x/last/2;
            if(Math.abs(val - last)<0.1)
                return (int) val;
            last = val;  
        }
	}

}
