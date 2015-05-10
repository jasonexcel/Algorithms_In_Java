package LeetCode;

class TrieNode {
    // Initialize your data structure here.
    public char val; // not needed
    public boolean isWord;
    public TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[26];
    }
    public TrieNode(char c) {
        this.val = c;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
    	System.out.print("root is null");
    	System.out.println(root == null);
        root = new TrieNode();
        System.out.print("root is ");
    	System.out.println(root == null);
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        if(word == null || word.length() == 0) {
            return;
        }
        for(int i=0; i<word.length(); i++) {
        	char c = word.charAt(i);
        	TrieNode temp = cur.children[c - 'a'];
        	if(temp == null) {
                cur.children[c-'a'] = new TrieNode(c);
                cur = cur.children[c-'a'];
        	}
        	else {
        		cur = temp;
        	}
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            TrieNode temp = cur.children[c - 'a'];
            if(temp == null) {
                return false;
            }
            cur = temp;
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) {
            return true;
        }

        TrieNode cur = root;
        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode temp = cur.children[c - 'a'];
            if(temp == null) {
                return false;
            }
            cur = temp;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	Trie t = new Trie();
    	String[] s = {"app", "apple", "beer", "add", "jam", "rental"};

    	for(String e : s) {
    		t.insert(e);
    	}
    	System.out.println(t.search("app"));
    	System.out.println(t.startsWith("app"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
