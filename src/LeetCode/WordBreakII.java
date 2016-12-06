package LeetCode;

import java.util.*;

/**
 * Created by Shaun on 10/1/2016.
 */
public class WordBreakII {

    public class Solution {
        // DFS + cache
        // Preferred
        public List<String> wordBreak(String s, Set<String> wordDict) {
            // HashMap to store all the solutions in the DFS
            Map<String, List<String>> map = new HashMap<>();
            return dfs(s, wordDict, 0, map);
        }

        private List<String> dfs(String s, Set<String> dict, int start, Map<String, List<String>> map) {
            List<String> cur = new ArrayList<>();
            if(start == s.length()) {
                cur.add("");
            }

            for(int i=start; i<s.length(); i++) {
                String sub = s.substring(start, i+1);
                if(dict.contains(sub)) {
                    List<String> temp;
                    //try to use the cache value first
                    if(map.containsKey(s.substring(i+1))) {
                        temp = map.get(s.substring(i+1));
                    } else {
                        temp = dfs(s, dict, i+1, map);
                    }
                    if(temp.size() == 1 && temp.get(0) == "") {
                        //sub is the last word, no space behind
                        cur.add(sub);
                    } else {
                        // add all word breaks after we select current sub
                        for(String str : temp) {
                            cur.add(sub + ' ' + str);
                        }
                    }


                }
            }
            //current word breaks are all found, put them into map
            map.put(s.substring(start), cur);
            return cur;
        }
    }

    //-------------------- iterate dictionary
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
