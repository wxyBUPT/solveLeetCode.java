package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 11/8/16.
 Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */
public class WordDictionary {

    WordNode root = new WordNode(' ');

    // Adds a word into the data structure.
    public void addWord(String word) {
        WordNode curr = root;
        for(Character c:word.toCharArray()){
            if(curr.leafs[c-'a'] == null){
                curr.leafs[c-'a'] = new WordNode(c);
            }
            curr = curr.leafs[c-'a'];
        }
        curr.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root,word);
    }

    boolean search(WordNode node,String word){
        if(word.length()==0)return node.isWord;
        if(word.charAt(0) == '.') {
            for (int i = 0; i < 26; i++)
                if (node.leafs[i] != null && search(node.leafs[i], word.substring(1))) return true;
            return false;
        }

        return node.leafs[word.charAt(0)-'a'] != null && search(node.leafs[word.charAt(0)-'a'],word.substring(1));
    }

    public static void main(String[] args){
        WordDictionary wd = new WordDictionary();
        wd.addWord("ab");
        boolean res = wd.search("a.");
        System.out.println(res);
    }

}

class WordNode{

    Character val;
    WordNode[] leafs;
    boolean isWord;

    public WordNode(Character c){
        this.val = c;
        leafs = new WordNode[26];
        isWord = false;
    }
}

