package basicAlgorithms;

public class HornerRule {

	/**
	 * @param args
	 * http://en.wikipedia.org/wiki/Horner%27s_method
	 * 假设有n＋2个实数a0，a1，…，an,和x的序列，要对多项式Pn(x)= anxn＋an－１xn－１＋…＋a１x＋a０求值，直接方法是对每一项分别求值，
	 * 并把每一项求的值累加起来，这种方法十分低效，它需要进行n＋(n－1)＋…＋1＝n(n＋１)/2次乘法运算和n次加法运算。
	 * 有没有更高效的算法呢?答案是肯定的。通过如下变换我们可以得到一种快得多的算法，
	 * 即Pn(x)= anxn ＋an－１xn－１＋…＋a１x＋a０＝((…(((anx ＋an－１)x＋an－２)x+ an－3)…)x＋a1)x＋a０，这种求值的安排我们称为霍纳法则。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4};
		int n = 4;
		int x = 3;
		System.out.println(HornerMethod(a, n, x));
		int bi = 2;
		System.out.println(HornerMethod(a, n, bi));
		int de = 10;
		System.out.println(HornerMethod(a, n, de));
		
		
	}
	
	public static long HornerMethod(int[] a, int n, int x) {
		long res = 0;
		for(int i=n-1; i>=0; i--) {
			res = res * x + a[i];
		}
		return res;
	}
}
