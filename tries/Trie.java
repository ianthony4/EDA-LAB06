package trie;

public class Trie implements TDATries{
  public TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.isEndWord = true;
  }

  public boolean search(String word) {
    return false;
  }

  public void replace(){

  }
}
