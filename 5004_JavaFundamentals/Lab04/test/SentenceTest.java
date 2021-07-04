import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This is the junit test file for the Sentence object.
 * @author Katie Lowen
 *
 */
public class SentenceTest {

  
  /**
   * This method tests the getNumberOfWords method. 
   */
  @Test
  public void testGetNumberOfWords() {
    
    Sentence s = new EmptyNode();
    s = new PunctuationNode('.', s);
    s = new WordNode("World", s);
    s = new PunctuationNode(',', s);
    s = new WordNode("Hello", s);
    
    
    
    int expected = 2;
    int actual = s.getNumberOfWords();
    
    assertEquals(expected, actual);
   
  }
  
  /**
   * This method tests the longestWord method. 
   */
  @Test
  public void testLongestWord() {
    Sentence s = new EmptyNode();
    s = new PunctuationNode('.', s);
    s = new WordNode("World", s);
    s = new WordNode("Beautiful", s);
    s = new WordNode("Hello", s);
    
    String expected = "Beautiful";
    String actual = s.longestWord();
    
    assertEquals(expected, actual);
    
  }
  
  /**
   * This method tests the toString method. This Sentence 
   * ends in a period.
   */
  @Test
  public void testToString() {
    Sentence s = new EmptyNode();
    s = new PunctuationNode('!', s);
    s = new WordNode("World", s);
    s = new WordNode("Beautiful", s);
    s = new PunctuationNode(',', s);
    s = new WordNode("Hello", s);
    String expected = "Hello, Beautiful World!";
    String actual = s.toString();
    assertEquals(expected, actual);
    
  }
  
  /**
   * This method tests the toString method. If the Sentence has 
   * no ending punctuation, it should add a period. 
   */
  @Test
  public void testToString2() {
    Sentence s = new EmptyNode();
    s = new WordNode("World", s);
    s = new WordNode("Beautiful", s);
    s = new PunctuationNode(',', s);
    s = new WordNode("Hello", s);
    String expected = "Hello, Beautiful World.";
    String actual = s.toString();
    assertEquals(expected, actual);
    
  }
  
  /**
   * This method tests the toString method on an EmptyNode.
   */
  @Test
  public void testToString3() {
    Sentence s = new EmptyNode();
    String expected = "";
    String actual = s.toString();
    
    assertEquals(expected, actual);
  }
  
  /**
   * This method tests the clone method.
   */
  @Test 
  public void testClone() {
    Sentence s = new EmptyNode();
    s = new PunctuationNode('.', s);
    s = new WordNode("World", s);
    s = new WordNode("Beautiful", s);
    s = new WordNode("Hello", s);
    
    Sentence s2 = s.clone();
    
    assertEquals(s.toString(), s2.toString());
    
    String expected = "Hello Beautiful World.";
    assertEquals(expected, s2.toString());
    
  }
  
  /**
   * This method tests the clone method. If we continue to change a string, 
   * it should not change the cloned object. 
   */
  @Test 
  public void testClone2() {
    Sentence s = new EmptyNode();
    s = new PunctuationNode('.', s);
    s = new WordNode("World", s);
    s = new WordNode("Beautiful", s);
    s = new WordNode("Hello", s);
    
    Sentence s2 = s.clone();
    
    assertEquals(s.toString(), s2.toString());
    
    s = new WordNode("Morning", s);
    s = new WordNode("Good", s);
    
    assertEquals("Good Morning Hello Beautiful World.", s.toString());
    assertEquals("Hello Beautiful World.", s2.toString());
    
  }
  
  /**
   * This method tests the merge method. 
   */
  @Test
  public void testMerge() {
    
    Sentence s = new EmptyNode();
    s = new PunctuationNode('.', s);
    s = new WordNode("World", s);
    s = new WordNode("Beautiful", s);
    
    Sentence s2 = new EmptyNode(); 
    s2 = new WordNode("Hello", s2);
    String actual = s2.merge(s).toString();
   
    String expected = "Hello Beautiful World.";
   
    assertEquals(expected, actual);
    
    String old1 = "Hello.";
    String actualOld = s2.toString();
    
    assertEquals(old1, actualOld);
    
    String old2 = "Beautiful World.";
    String actualOld2 = s.toString();
    
    assertEquals(old2, actualOld2);
    
      
  }
  

  
  
  
  
  

  
}
