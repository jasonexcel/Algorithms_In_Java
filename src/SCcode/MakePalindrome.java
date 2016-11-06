package SCcode;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Shaun on 10/8/2016.
 */
public class MakePalindrome {

    public static void main(String[] args) {
        MakePalindrome ins = new MakePalindrome();
        String str = "fdabacd";
        assertThat(ins.minChangeToPalindrome(str), is(2));
        System.out.println(ins.minChangeToPalindrome(str));
    }

    private int minChangeToPalindrome(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        int[][] dp = new int[len][len];
        for(int width=2; width<=len; width++) {
            for(int j=width-1; j<=len-1; j++) {
                int i = j - width + 1;
                if(str.charAt(i) == str.charAt(j)) {
                    if(i + 1 == j) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    int min = Math.min(dp[i+1][j-1], dp[i+1][j]);
                    min = Math.min(min, dp[i][j-1]);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[0][len-1];
    }

    private MakePalindrome ins;
    @Before
    public void setUp() throws Exception {
        ins = new MakePalindrome();
    }

    @Test
    private void testPalindrome() throws Exception {
        String str1 = "abc";
        assertThat(ins.minChangeToPalindrome(str1), is(1));
        String str2 = "abca";
        assertThat(ins.minChangeToPalindrome(str2), is(1));
        String str3 = "";
        assertThat(ins.minChangeToPalindrome(str3), is(0));
    }
}
