package RealInterviewQuestion;

/**
 * 给一个wordlist，和两个word，返回这两个word最近的距离
eg: list = [one,two,three,four,one] 要找one和two最近的距离，那么返回1

ctci chapter 18.5
 */
import java.util.List;

public class MinDistance {
	public static int minDistance(List<String> list, String A, String B) {
        int minDist = Integer.MAX_VALUE;
        int lastA = -1;     //last appearance of A
        int lastB = -1;     //last appearance of B. more info on 1point3acres.com
        for(int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if(s.equals(A)) {
                        /* remember last A's position */
                        if(lastB != -1) {
                                minDist = Math.min(minDist, i - lastB);
                        }
                        lastA = i;
                } else if(s.equals(B)) {
                        /* remember last A's position */
                        if(lastA != -1) {
                                minDist = Math.min(minDist, i - lastA);
                        }
                        lastB = i;
                }
         }
        return minDist;
	}
}
