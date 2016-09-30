package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shaun on 9/29/2016.
 */
public class AlienDictionary {
    public static void main(String[] args) {
        AlienDictionary ins = new AlienDictionary();
        String[] words = { "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
       System.out.println(ins.alienOrder(words));
    }
    public String alienOrder(String[] words) {
        if(words == null || words.length < 1) {
            return "";
        } else if(words.length == 1) {
            return words[0];
        }
        // -1 - non-exist, 0 - unvisited, 1 - visiting, 2 - visited
        int[] status = new int[26];
        Arrays.fill(status, -1);
        List<Character>[] adjList = new ArrayList[26];
        if(!preprocess(adjList, words, status)) {
            return "";
        }

        List<Character> res = new ArrayList<>();
        for(int i=0; i<adjList.length; i++) {
            if(status[i] == 0) {
                if(getOrder(adjList, status, res, i)) {
                    return "";
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i=res.size()-1; i>=0; i--) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

    // return true if detecting cycle
    private boolean getOrder(List<Character>[] adjList, int[] status,
                             List<Character> res, int i) {
        status[i] = 1; //visiting
        for(int j=0; j<adjList[i].size(); j++) {
            char cur = adjList[i].get(j);
            if(status[cur - 'a'] == 1) {
                return true;
            }
            if(status[cur - 'a'] == 0) {
                if(getOrder(adjList, status, res, cur-'a')) {
                    return true;
                }
            }
        }
        status[i] = 2;
        res.add((char)('a' + i));
        return false;
    }

    private boolean preprocess(List<Character>[] res, String[] words, int[] status) {
        for(int i=0;i<res.length;i++) {
            res[i] = new ArrayList();
        }
        for(int i=0; i<words.length; i++) {
            String cur = words[i];
            for(int index=0; i<cur.length(); index++) {
                status[cur.charAt(index) - 'a'] = 0;
            }
            if(i > 0) {
                String pre = words[i-1];
                int minLen = Math.min(pre.length(), cur.length());
                int j;
                for(j=0; j<minLen; j++) {
                    if(pre.charAt(j) != cur.charAt(j)) {
                        res[pre.charAt(j) - 'a'].add(cur.charAt(j));
                        break;
                    }
                }
                if(j == minLen) {
                   return false;
                }
            }

        }
        return true;
    }
}
