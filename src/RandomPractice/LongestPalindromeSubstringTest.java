package RandomPractice;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
/**
 * Created by Shaun on 8/14/2016.
 */
public class LongestPalindromeSubstringTest {
    private LongestPalindromeSubstring ins = new LongestPalindromeSubstring();
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getLongestpalindromeInString_successSimple() throws Exception {
        try {
            ins.getLongestpalindromeInString(null);
        } catch(NullPointerException e) {
            System.out.println(e);
        }
        assertThat(ins.getLongestpalindromeInString(""), is(0));
        assertEquals(0, ins.getLongestpalindromeInString(""));
        assertEquals(1, ins.getLongestpalindromeInString("1"));
        assertEquals(3, ins.getLongestpalindromeInString("aba"));
        assertEquals(3, ins.getLongestpalindromeInString("dabafg"));
        assertEquals(4, ins.getLongestpalindromeInString("aabbaddc"));
    }

    @Test
    public void getLongestPalindromeSubstring_success() throws Exception {
        assertEquals(ins.getLongestPalindromeSubstring("aa"), "aa");
        assertEquals(ins.getLongestPalindromeSubstring("aab"), "aa");
        assertEquals(ins.getLongestPalindromeSubstring("daafb"), "aa");
        assertEquals(ins.getLongestPalindromeSubstring("dabcba"), "abcba");
    }
}