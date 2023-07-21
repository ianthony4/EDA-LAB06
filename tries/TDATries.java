package tries;

public interface TDATries {
  // Inserta un elemento en el trie
  public void insert(String word);
  // Reemplaza un elemento del trie
  public void replace(String word, String newWord);
  // Busca un elemento en el trie
  public boolean search(String word);
}
