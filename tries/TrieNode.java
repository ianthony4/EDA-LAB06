package trie;

public class TrieNode {
    public char value;
    public TrieNode[] children;
    public TrieNode[] siblings;
    public boolean isEndWord;

    public TrieNode() {
      this('$');
    }

    public TrieNode(char value) {
        this.value = value;
        this.children = null;
        this.siblings = null;
        this.value = value;
        this.isEndWord = false;
    }
}
