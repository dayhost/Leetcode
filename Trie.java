package Interview;
public class Trie {

    class TrieNode{
        public char c;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(char c){
            this.c = c;
        }
        public TrieNode(){
            
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.c = ' ';
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        if(chars.length<=0){
            return;
        }
        TrieNode tmp = root;
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            if(tmp.children[c-'a']==null){
                tmp.children[c-'a'] = new TrieNode(c);
            }
            tmp = tmp.children[c-'a'];
        }
        tmp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        if(chars.length<=0){
            return true;
        }
        TrieNode tmp = root;
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            if(tmp.children[c-'a']==null){
                return false;
            }
            tmp = tmp.children[c-'a'];
        }
        return tmp.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        if(chars.length<=0){
            return true;
        }
        TrieNode tmp = root;
        for(int i=0; i<chars.length; i++){
            char c = chars[i];
            if(tmp.children[c-'a']==null){
                return false;
            }
            tmp = tmp.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */