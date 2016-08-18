package RandomPractice;

/**
 * Created by Shaun on 8/14/2016.
 */
public class LongestPalindromeSubstring {

    public static void main(String[] args) {

    }

    public int getLongestpalindromeInString(final String s) {
        if(s == null) {
            throw new NullPointerException("Illegal argument");
        }
        final int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }

        if (s.charAt(0) == s.charAt(len - 1)) {
            return getLongestpalindromeInString(s.substring(1, len - 1)) + 2;
        } else {
            return Integer.max(getLongestpalindromeInString(s.substring(0, len - 1)),
                    getLongestpalindromeInString(s.substring(1, len)));
        }
    }

    public String getLongestPalindromeSubstring(final String s) {
        if(s == null) {
            throw new NullPointerException("Illegal argument");
        }
        final int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }

        String maxPalindromicSubstring = "";

        for(int i = 0; i < 2 * len - 1; i++) {
            int left;
            int right;
            if(i % 2 == 0) {
                left = i / 2 - 1;
                right = i / 2 + 1;
            } else {
                left = i / 2;
                right = left + 1;
            }
            String tempPalindrome = findPalindromeFromCenter(s, left, right);
            if(tempPalindrome.length() > maxPalindromicSubstring.length()) {
                maxPalindromicSubstring = tempPalindrome;
            }
        }
        return maxPalindromicSubstring;
    }

    private String findPalindromeFromCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

}
