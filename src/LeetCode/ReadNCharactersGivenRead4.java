package LeetCode;

/**
 * Created by Shaun on 9/3/2016.
 *
 * keys:
 * 1. end of file
 * 2. no more than n characters
 */
public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        boolean eof = false;
        int i = 0;
        char[] buf4 = new char[4];

        while(i < n && !eof) {
            int buf4Size = read4(buf4);
            int indexOfRead4 = 0;
            eof = buf4Size < 4;

            int copySize = Math.min(buf4Size, n - i);
            while(copySize > 0) {
                buf[i++] = buf4[indexOfRead4++];
                copySize--;
            }
        }
        return i;
    }

    int read4(char[] buf){
        //fake return
        return 4;
    }
}
