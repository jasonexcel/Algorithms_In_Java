package LeetCode;

/**
 * Created by Shaun on 9/3/2016.
 *
 * Input:    "ab", [read(1),read(2)]
 * Expected:    ["a","b"]
 *
 *
 * keys:
 * 1. class variable;
 * 2. keep reading remaining char from buf4 from the current index
 */


public class ReadNCharactersGivenRead4II {

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] buf4 = new char[4];
    int indexOfRead4 = 0;
    int buf4Size = 0;
    public int read(char[] buf, int n) {
        boolean eof = false;
        int i = 0;
        while(i < n && !eof) {
            if(buf4Size == 0){
                buf4Size = read4(buf4);
                indexOfRead4 = 0;
                eof = buf4Size < 4;
            }

            int copySize = Math.min(buf4Size, n - i);

            while(copySize > 0) {
                buf[i++] = buf4[indexOfRead4++];
                copySize--;
                buf4Size--;
            }

        }
        return i;
    }



    //--------------------
    public int readGuru(char[] buf, int n) {
        int i = 0;
        while (i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buff4))))
            buf[i++] = buff4[i4++];
        return i;
    }
    char[] buff4 = new char[4];
    int i4 = 0, n4 = 0;

    int read4(char[] buf){
        //fake return
        return 4;
    }
}
