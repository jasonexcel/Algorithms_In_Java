package RandomPractice;

import org.junit.Before;
import org.junit.Test;

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
        assertEquals(ins.getLongestpalindromeInString(""), 0);
        assertEquals(ins.getLongestpalindromeInString("1"), 1);
        assertEquals(ins.getLongestpalindromeInString("aba"), 3);
        assertEquals(ins.getLongestpalindromeInString("dabafg"), 3);
        assertEquals(ins.getLongestpalindromeInString("aabbaddc"), 4);
    }

    @Test
    public void getLongestPalindromeSubstring_success() throws Exception {
        assertEquals(ins.getLongestPalindromeSubstring("aa"), "aa");
        assertEquals(ins.getLongestPalindromeSubstring("aab"), "aa");
        assertEquals(ins.getLongestPalindromeSubstring("daafb"), "aa");
        assertEquals(ins.getLongestPalindromeSubstring("dabcba"), "abcba");
    }
}