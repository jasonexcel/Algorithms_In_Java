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
        if(x <= 0){
            return 0;
        }
        int min = 1;
        int max = x/2+1;
        while(min<=max){
            int mid = (min+max)/2;
            if(x/mid>mid){
                min = mid + 1;
            }
            else if(x/mid<mid){
                max = mid - 1;
            }
            else{
                return mid;
            }
        }
        return max;
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
