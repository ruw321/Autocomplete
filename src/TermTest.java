
import java.util.Arrays;


/**
 * 
 * @author Wang
 * @version 2018.12.02
 */
public class TermTest extends student.TestCase {

    private Term term5;
    private Term term6;
    //private String term;
    private String term1; 
    //private String term2;
    //private Long weight;
    //private long weight1;
    
    /**
     * setup
     */
    public void setUp() {
        //term = "yes";
        term1 = "No";
        //weight = new Long(7878);
        //weight1 = 4181988; 
        
        term5 = new Term(term1, 7878);
        term6 = new Term(term1, 7878);
      
    }
    
    /**
     * test for comparator
     */
    public void testByReverseWeightOrder() {
        Term[] arrayofTerms = { new Term("yes", 1), new Term("no", 2) };
        Arrays.sort(arrayofTerms, Term.byReverseWeightOrder());
        assertNotNull(arrayofTerms); 
        assertEquals("no", arrayofTerms[0].getTerm());

        Term[] arrayofTerms1 = { new Term("yes", 2), new Term("no", 1) };
        Arrays.sort(arrayofTerms1, Term.byReverseWeightOrder());
        assertNotNull(arrayofTerms1);
        assertEquals("yes", arrayofTerms1[0].getTerm());

        Term[] arrayofTerms2 = { new Term("yes", 1), new Term("no", 1) };
        Arrays.sort(arrayofTerms2, Term.byReverseWeightOrder());
        assertNotNull(arrayofTerms2);
        assertEquals("yes", arrayofTerms2[0].getTerm());
        
        term5.setTerm(term1);
//        assertEquals(0, term5.getWeight().compareTo(term5.getWeight()));
//        term6.setWeight(weight1);
//        assertEquals(-1, term5.getWeight().compareTo(term6.getWeight()));
//        assertEquals(1, term6.getWeight().compareTo(term5.getWeight()));
//        term5.setTerm(term1); 
                      
    }
    
    /**
     * test for byPrefixOrder
     */
    public void testByPrefixOrder() {
        
        
        //same prefix
        Term[] arrayofTerms = { new Term("yesyu", 11), new Term("yessss", 11)};
        Arrays.sort(arrayofTerms, Term.byPrefixOrder(3));
        assertNotNull(arrayofTerms);
        assertEquals("yesyu", arrayofTerms[0].getTerm());
        
        //r = first term's length
        Term[] arrayofTerms9 = { new Term("yesaa", 11), new Term("yes", 11)};
        Arrays.sort(arrayofTerms9, Term.byPrefixOrder(5));
        assertNotNull(arrayofTerms9);
        assertEquals("yesaa", arrayofTerms9[0].getTerm());
        
        //r greater than the first term's length
        Term[] arrayofTermsfinal = { new Term("yesaa", 11), new Term("yes", 11)};
        Arrays.sort(arrayofTermsfinal, Term.byPrefixOrder(6));
        assertNotNull(arrayofTermsfinal);
        assertEquals("yesaa", arrayofTermsfinal[0].getTerm());
        
        //r = second word's length
        Term[] arrayofTerms10 = { new Term("yesaa", 11), new Term("yes", 11)};
        Arrays.sort(arrayofTerms10, Term.byPrefixOrder(3));
        assertNotNull(arrayofTerms10);
        assertEquals("yesaa", arrayofTerms10[0].getTerm());
        
        //r greater than the second words length
        Term[] arrayofTermsha = { new Term("yesaa", 11), new Term("yes", 11)};
        Arrays.sort(arrayofTermsha, Term.byPrefixOrder(4));
        assertNotNull(arrayofTermsha);
        assertEquals("yesaa", arrayofTermsha[0].getTerm());
        
        //r greater than a but smaller than b 
        Term[] arrayofTermsame = { new Term("yesa", 11), new Term("yessss", 11)};
        Arrays.sort(arrayofTermsame, Term.byPrefixOrder(5));
        assertNotNull(arrayofTermsame);
        assertEquals("yesa", arrayofTermsame[0].getTerm());
        
        
        term5.setWeight(1231);
        // -1 prefix
        Term[] arrayofTerms1 = { new Term("abzd", 11), new Term("abcd", 11) };
        Arrays.sort(arrayofTerms1, Term.byPrefixOrder(3));
        assertNotNull(arrayofTerms1);
        assertEquals("abcd", arrayofTerms1[0].getTerm());

        // 1 prefix
        Term[] arrayofTerms2 = { new Term("abcd", 11), new Term("abzd", 11) };
        Arrays.sort(arrayofTerms2, Term.byPrefixOrder(3));
        assertNotNull(arrayofTerms2);
        assertEquals("abcd", arrayofTerms2[0].getTerm());
        
        
        assertEquals(0, term5.compareTo(term5));
        term5.setTerm("AAA");
        assertEquals(-1, term5.compareTo(term6));
        assertEquals(1, term6.compareTo(term5));
        
        Exception e = null;
        try {
            Arrays.sort(arrayofTerms2, Term.byPrefixOrder(-1));
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalArgumentException);
        
        
        
    }
    
    /**
     * test for tostring
     */
    public void testToString() {
        assertEquals("7878\tNo", term5.toString());
        assertEquals(7878, term5.getWeight(), 0.01);
    }
    
  
    /**
     * test for constructors exception
     */
    public void testException() {

        Exception e = null;
        try { 
            term5 = new Term(null, 89);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalArgumentException);
       
    
        Exception e1 = null;
        try {
            term5 = new Term("yes", -1);
        }
        catch (Exception exception) { 
            e1 = exception;
        }
        assertNotNull(e1);
        assertTrue(e1 instanceof IllegalArgumentException);
        
    }
}
