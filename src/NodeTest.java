/**
 * 
 * @author Wang
 * @version 2018.12.03
 */

public class NodeTest extends student.TestCase {
    private Node node;
    private Node node1;
 
    
    /**
     * setup
     */
    public void setUp() {
        node = new Node();
        node1 = new Node("yes", 121);
    }
     
    /** 
     * test the setters and getters
     */
    public void testNode() {
        Term term = new Term("yes", 1212);
        node.setPrefixes(10);
        assertEquals(10, node.getPrefixes());
        node.setWords(20);
        assertEquals(20, node.getWords());
        node.setTerm(term); 
        assertEquals(term, node.getTerm());
        node1.setPrefixes(10);
        node1.references();
    }
}
