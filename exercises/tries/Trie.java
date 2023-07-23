public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insertar una palabra en el trie
    public void insert(String word) {
        //El metodo comienza con el nodo raiz del Trie, que se almacena en root.
        TrieNode current = root;
        //recorremos cada letra de la palabra
        for (int i = 0; i < word.length(); i++) {
            //convertir en minuscula
            char ch = Character.toLowerCase(word.charAt(i));
            //calcular el índice restando el valor ASCII de 'a'
            int index = ch - 'a'; 
            if (index < 0 || index >= 26) {
                //Ignorar caracteres que no sean letras del alfabeto inglés (ñ)
                continue; 
            }
            //Si el índice calculado es válido, el método verifica si hay un nodo hijo correspondiente
            //en la posición del índice actual en el arreglo children
            if (current.children[index] == null) {
                //Si el nodo no existe, crea un nuevo nodo en esa posición.
                current.children[index] = new TrieNode();
            }
            //actualizar el nodo actual
            current = current.children[index];
        }
        //Despues de recorrer toda la palabra
        //el último nodo en el camino representa el final de la palabra
        current.isEndOfWord = true;
    }

    // Buscar una palabra en el trie
    public boolean search(String word) {
        //obtener nodo raiz
        TrieNode current = root;
        //recorrer la palabra
        for (int i = 0; i < word.length(); i++) {
            //convertir a minuscula
            char ch = Character.toLowerCase(word.charAt(i));
            //calculo del indice
            int index = ch - 'a';
            if (index < 0 || index >= 26) {
                // char invalido, palabra no presente en el Trie
                return false; 
            }
            //verificar existencia del nodo
            if (current.children[index] == null) {
                return false;
            }
            //actualizar nodo actual
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    // Reemplazar palabras en un texto
    public String replace(String text, String srch, String replace) {
        //cada palabra del texto en un arreglo
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        //agregamos al trie la palabra a buscar
        this.insert(srch); 
        //recorremos en cada palabra
        for (String word : words) {
            if (search(word)) {
                // Reemplazar por la palabra deseada
                result.append(replace + " ");
            } else {
                // no se remplaza nada
                result.append(word).append(" ");
            }
        }
        return result.toString();
    }
}
