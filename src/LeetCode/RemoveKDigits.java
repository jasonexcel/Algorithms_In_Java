package LeetCode;

/**
 * Created by Shaun on 11/26/2016.
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "143219";
        int k = 2;
        System.out.println(new RemoveKDigits().removeKdigits(num, k));
    }
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        // String(char value[], int offset, int count), digits - idx is the count
        return idx == digits? "0": new String(stk, idx, digits - idx);//
    }
}
