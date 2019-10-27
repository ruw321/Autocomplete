import java.util.Comparator;

/**
 * 
 * @author Wang
 * @version 2018.11.28
 */
public class Term implements Comparable<Term> {

    private String terms;  
    private long weight;

    /**Initializes a term with the given term string and weight.
     * 
     * @param term the term to add
     * @param weight the weight for the word
     */
    public Term(String term, long weight) {
        if (term == null) {
            throw new IllegalArgumentException();
        }
        if (weight < 0) {
            throw new IllegalArgumentException();
        }
        
        
        this.terms = term;
        this.weight = weight;
         
    } 
    
    
    
    /**
     * Compares the two terms in descending order by weight.
     * @return term in descending order 
     */
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            @Override 
            public int compare(Term a, Term b) {
                if (a.weight > b.weight) {
                    return -1; 
                }
                else if (a.weight < b.weight) {
                    return 1;
                } 
                return 0;
            }
        };
        
    }

    // 
    
     
    /**
     * Compares the two terms in lexicographic order but 
     * using only the first r characters of each term.
     * @param r index 
     * @return the compared list
     */
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) {
            throw new IllegalArgumentException();
        }
        
        return new Comparator<Term>() {
            @Override 
            public int compare(Term a, Term b) {
                int newr = r;
                if (r > a.terms.length() || r > b.terms.length()) {
                    
                    if (a.terms.length() > b.terms.length()) {
                        
                        newr = b.terms.length() - 1;
                    }
                    else {
                        newr = a.terms.length() - 1;
                    }
                }
                String c = a.terms.substring(0, newr);
                String d = b.terms.substring(0, newr);
                if (c.compareTo(d) > 0) {
                    return 1;
                }
                else if (c.compareTo(d) < 0) {
                    return -1;
                }
                return 0;
            }
        };
        
    }

    // Compares the two terms in lexicographic order by term.
    /**
     * Compares the two terms in lexicographic order by term.
     * @param that the term 
     * @return 0 if the same
     */
    public int compareTo(Term that) {
        if (this.terms.compareTo(that.terms) > 0) {
            return 1;
        }
        else if (this.terms.compareTo(that.terms) < 0) {
            return -1;
        }
        return 0;
        
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab character, followed by the term
    //(no space
    
    /**
     * Returns a string representation of this term in the following format:
     * @return string the string 
     */
    public String toString() {
       
        String s = this.getWeight() + "\t" + 
            this.getTerm();                    
        return s;
    }


    /**
     * get term
     * @return term
     */
    public String getTerm() {
        return terms;  
    }


    /**
     * setter for term
     * @param term the term
     */
    public void setTerm(String term) {
        this.terms = term;
    }
    
    /**
     * get weight
     * @return weight
     */
    public long getWeight() {
        return weight;
    }

    /**
     * setter for weight 
     * @param weight the weight
     */
    public void setWeight(long weight) {
        this.weight = weight;
    }

}