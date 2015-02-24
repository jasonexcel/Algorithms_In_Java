/**
 * 
 */
package basicAlgorithms;

/**
 * @author sjia
 *
 */
public class EstimatePi {
	public static void main(String[] args){
		int repeatation = 1000000000;
		EstimatePi ins = new EstimatePi();
		double res = ins.estimate(repeatation, 100);
		System.out.println(res);
		//System.out.println(ins.estimate(repeatation, 100));
	}
	
	public double estimate(int repeatation, int totalSeconds){
		if(repeatation <0 || totalSeconds <0){
			return 0.0;
		}
		int sum = 0;
		double x, y;
		int i = 0;
		while(i< repeatation){
			x = Math.random();
			y = Math.random();
			if(x*x + y*y < 1){
				sum++;
			}
			i++;
		}
		return (double)sum/repeatation*4;
	}
}
