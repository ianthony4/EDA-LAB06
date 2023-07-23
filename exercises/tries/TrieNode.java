class TrieNode {

    //verifica que es el fin de la palabra
    boolean isEndOfWord;

    TrieNode[] children;

    //constructor
    public TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }

}
