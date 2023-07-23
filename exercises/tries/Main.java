public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String text = "Me gusta la manzana";
        System.out.println("Texto original : " + text);
        text = trie.replace(text, "manzana", "pera");
        System.out.println("Busqueda de 'manzana', remplazo por 'pera' : " + text);
        text = trie.replace(text, "vainilla", "guayaba");
        System.out.println("Busqueda de 'vainilla', remplazo por 'guayaba' : "+text + "(sin cambios|)");
        text = trie.replace(text, "pera", "fresa");
        System.out.println("Busqueda de 'pera' y remplezo por fresa : " + text);
    }

}