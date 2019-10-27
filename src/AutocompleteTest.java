import java.util.ArrayList;
import java.util.List;

/**
 * test for auto complete class
 * @author Wang
 * @version 2018.12.06
 */
public class AutocompleteTest extends student.TestCase {

    private Autocomplete auto;
    
    /**
     * initializing
     */
    public void setUp() {
        auto = new Autocomplete(); 
        
    }
    
    /**
     * test for add word
     */
    public void testAddWord() {
        auto.addWord("abc", 20); 
        assertEquals("abc", auto.root.references()[0].references()[1].
                references()[2].getTerm().getTerm()); 
        auto.addWord("abcd", 10); 
        assertEquals(2, auto.root.references()[0].references()[1].
                references()[2].getPrefixes());
        auto.addWord("yea", 20);    
        auto.addWord("12", 20);
    
    }
    
    /**
     * test for getsubtrie
     */
    public void testGetSubTrie() {
        auto.addWord("test", 99);
        auto.addWord("testing", 10);
        auto.addWord("apple", 112);
        //auto.addWord("abc", 15);
        assertEquals("test", auto.getSubTrie("test").getTerm().getTerm()); 
        assertEquals(1, auto.getSubTrie("app").getPrefixes());
        assertEquals(2, auto.getSubTrie("test").getPrefixes());
        assertEquals(3, auto.getSubTrie("").getPrefixes());
        assertNull(auto.getSubTrie("tes!t"));
        assertNull(auto.getSubTrie("tess!"));
    }
    
    /**
     * test for isletter
     */
    public void testIsLetter() {
        assertTrue(auto.isLetter("abcasda"));
        assertFalse(auto.isLetter("~ !:"));
        assertFalse(auto.isLetter("?"));
        assertTrue(auto.isLetter("A"));
        assertFalse(auto.isLetter("[`"));
        assertFalse(auto.isLetter("!"));
        assertFalse(auto.isLetter("/^"));
        assertFalse(auto.isLetter(null));
    }
    
    /**
     * test for count prefixes
     */
    public void testCountPrefixes() {
        
//        String s = new String();
//        Node node = auto.getSubTrie(s);
//        assertNull(node);
//        auto.countPrefixes(s);
        
        auto.addWord("test", 99);
        auto.addWord("testing", 10);
        auto.addWord("tester", 1);
        assertEquals(3, auto.countPrefixes("test"));
        assertEquals(0, auto.countPrefixes("yes"));
        assertEquals(0, auto.countPrefixes(null));
    } 
    
    /**
     * test for getSuggestions
     */
    public void testGetSuggestions() {
        List<Term> listofTerms = new ArrayList<Term>();
        assertEquals(listofTerms, auto.getSuggestions(""));
        auto.addWord("test", 99);
        auto.addWord("testing", 10);
        auto.addWord("tester", 1);
        
        listofTerms.add(new Term("test", 99));
        listofTerms.add(new Term("testing", 10));
        listofTerms.add(new Term("tester", 1));
        //List<Term> listofTerms = new ArrayList<Term>();
        //System.out.println(auto.getSuggestions("test").toString());
        assertEquals(listofTerms.toString(), 
                auto.getSuggestions("test").toString());
        assertEquals(3, auto.getSuggestions("test").size());
        assertEquals(3, auto.getSuggestions("").size());
        
        assertEquals("[]", auto.getSuggestions("!@").toString());
        
    } 
   
    
}
