//import java.util.HashMap;
//import java.util.Map;

/**
 * 
 * @author Wang
 * @version 2018.12.02
 */
public class Node {

   
    /**
     * term that contains term and weight
     */
    protected Term term;
    
    /**
     * number of words that match with a given string
     */
    private int words;
    
    /**
     * number of words that have same prefix of a given string
     */
    private int prefixes; 
    
    /**
     * references to its children (26)
     */
    private Node[] references;
    
    //private Map<Character, Node> children = new HashMap<>();
    
    
    /**
     * no arg constructor
     */ 
    public Node() {
        term = new Term("", 0);
        words = 0;
        prefixes = 0;
        references = new Node[26]; 
        for (int i = 0; i < 26; i++) {
            references[i] = null;
        } 
        
        
    }
    
    /**
     * argument constructor
     * @param word the word
     * @param weight and weight associated with the word
     */
    public Node(String word, long weight) {
        term = new Term(word, weight);
        this.words = 0;
        this.prefixes = 0;
        references = new Node[26];
        for (int i = 0; i < 26; i++) {
            references[i] = null; 
        } 
    }
 
    /**
     * getter for words 
     * @return words
     */
    public int getWords() {
        return words;
    }
    
    /**
     * getter for children???
     * @return children
     */
    public Node[] references() {
        return references;
    }
    
//    /**
//     * check if the node has the letter
//     * @param s
//     * @return
//     */
//    public boolean containsKey(String a) {
//        Node node = new Node(a, 0);
//        for(int i = 0; i < references.length; i++) {
//            if (this.children()[i].equals(node)) {
//                return true;
//            }
//        }
//        children.
//        return false;
//    }

    /**
     * setter for word
     * @param words number of words
     */
    public void setWords(int words) {
        this.words = words;
    }

    /**
     * getter for prefixes 
     * @return prefixes
     */
    public int getPrefixes() {
        return prefixes;
    }

    /**
     * setter for prefixes 
     * @param prefixes the prefix
     */
    public void setPrefixes(int prefixes) {
        this.prefixes = prefixes;
    }
    
    /**
     * getter for term
     * @return term
     */
    public Term getTerm() {
        return term;
    }
    
    /**
     * 
     * @param term the term
     */
    public void setTerm(Term term) {
        this.term = term;
    }
    
  
    
}
