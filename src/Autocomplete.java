import java.util.ArrayList;
import java.util.List;

//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;

/**
 * 
 * @author Wang
 * @version 2018.12.03
 */

public class Autocomplete {
    //an auto completed word
    /**
     * an auto complete word
     */
    protected Term term;
    
    //a node in my trie
    /**
     * a node in my trie
     */
    protected Node root;
    
    //private Node[] references;
    
    
    // Initializes the data structure, created the root of the Trie.
    /**
     * initializes the data structure
     * constructor 
     */ 
    public Autocomplete() { 
        root = new Node();
        term = new Term("", 0);  
        //this.arr = new Node[26];
    }   

  
    
    //Adds a new word and its associated weight to the Trie - provide Big-O.
    /**
     * adds a new word and its associated weight 
     * @param word the word you wanna add
     * @param weight  the weight associated with thr word
     * worst case: O(n)
     */
    public void addWord(String word, int weight) {
        if (isLetter(word)) {
            word = word.toLowerCase();
            addwordHelper(word, weight, 0, root);
        }

    }
    
    
    /**
     * wrapper method for addWord
     * @param word the word to add
     * @param weight the associated weight
     * @param index the index of the references
     * @param node in the trie
     */ 
    public void addwordHelper(String word, int weight, int index, Node node) {
        if (index == word.length()) { //the last letter
            node.setTerm(new Term(word, weight));
            node.setWords(node.getWords() + 1);
            node.setPrefixes(node.getPrefixes() + 1);
            return;
        }
        
        char nextLetter = word.charAt(index);
        int charIndex = nextLetter - 'a';
        //getting the index of the current letter
        node.setPrefixes(node.getPrefixes() + 1);
         
        
        if (node.references()[charIndex] == null) {
            node.references()[charIndex] = new Node();
            //if null, add the letter to the node
        }
        
        addwordHelper(word, weight, index + 1, node.references()[charIndex]);
    }
    
    
        
        
        
//        
//        String str = word.substring(index, index + 1);
//        String s = root.getTerm().getQuery().substring(index, index + 1);
//        if (!s.equals(str)) {
//            root.getTerm().setQuery(str);
//            
//            root.getTerm().setWeight(weight);
//            return addwordHelper(word, weight, index+1);
//        }
//        else if (s.equals(str)) {
//            addwordHelper(word, weight, index+1);   
//            
//        }
//        return root;
    
   

    /**
     * to check if its a normal letter
     * @param word the word to test
     * @return true if its a letter
     */
    public boolean isLetter(String word) {
        //new char
        if (word == null) {
            return false;
        }
        char[] temp = word.toCharArray();
        for (char c : temp) {
            //check if its letters 
            if (!(c >= 65 && c <= 90) && !(c >= 97 && c <= 122) ) { 
                return false; //if its not in range 
            }
        }
        return true;
    }
    
    //Returns the root of the subTrie corresponding to the 
    //last character of the prefix - provide Big-O. 
    /**
     * 
     * @param prefix prefix you wanna find
     * @return subtrie
     * worse case: O(n)
     */
    public Node getSubTrie(String prefix) {

        if (isLetter(prefix)) {
            prefix = prefix.toLowerCase();
            return getsubtrieHelper(prefix, 0, root);
        }
        return null;

    }
    
    /**
     * helper method for subtrie
     * @param prefix the prefix wanna find
     * @param index index of the references
     * @param node node 
     * @return the node 
     */
    public Node getsubtrieHelper(String prefix, int index, Node node) {
        if (index == prefix.length()) {
            return node;
        }
        char nextLetter = prefix.charAt(index);
        int charIndex = nextLetter - 'a';
        if (node.references()[charIndex] == null) {
            return null;
        }
        else {
            node = node.references()[charIndex];
            
            return getsubtrieHelper(prefix, index + 1, node);
        }
        
    }
    
    // The method returns the number of words that start with prefix. 
    /**
     * 
     * @param prefix the prefix
     * @return number of prefixes
     */ 
    public int countPrefixes(String prefix) {

        if (prefix == null) {
            return 0;
        }

        root = this.getSubTrie(prefix);
        if (root != null) {
            return root.getPrefixes();
        }

        return 0;

    }
    
  


    // The method returns a List containing all the Terms objects
    //with query starting with prefix - provide Big-O. 
    /**
     * The method returns a List containing all the Terms objects
     * @param prefix the prefix
     * @return list 
     * Worse case: O(n^2)
     */
    public List<Term> getSuggestions(String prefix) {

        if (isLetter(prefix)) {
            prefix = prefix.toLowerCase();
            
            
            List<Term> retval = new ArrayList<Term>();
            if (this.getSubTrie(prefix) == null) {
                return retval;
            }
                
            else {
                
                retval = getsuggestionsHelper(this.getSubTrie(prefix));
                return retval;
            }
        }
        
        else {
            return new ArrayList<Term>();
        }

    }
    
    /**
     * 
     * @param node references
     * @return node
     */
    public List<Term> getsuggestionsHelper(Node node) {
        List<Term> retval = new ArrayList<Term>();
        if (node == null) {
            return retval;
        }
        if (node.getWords() > 0) {
            retval.add(node.getTerm());
            
        }
        int i = 25;
        while (i >= 0) {
            //char c = (char)( 97 + i); 
            List<Term> sth = getsuggestionsHelper(node.references()[i]);
            if (sth.size() == 0) {
                i--;
                continue;
            }
            for (int supernumber = 0; supernumber < sth.size(); 
                    supernumber++) {
                
                retval.add(sth.get(supernumber));
            }
            i--;
        }
        return retval;
    }
        
        
        
        
    

    
}
