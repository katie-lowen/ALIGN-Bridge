import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for the Sentence Implementation.
 * @author Katie Lowen
 *
 */
public class SentenceImplTest {

  /**
   * This method tests the add method. 
   */
  @Test
  public void testAdd() {
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement("Hello"));
    
    String expected = "Hello";
    String actual = s.toString();
    assertEquals(expected, actual);
    
    
    s.add(new WordElement("World"));
    expected = "Hello World";
    actual = s.toString();
    
    assertEquals(expected, actual);
    
    s.add(new PunctuationElement('!'));
    
    expected = "Hello World!";
    actual = s.toString();
    
    assertEquals(expected, actual);  
    
   
  }
  
  /**
   * This method tests the getNumberOfPunctuation method. 
   */
  @Test
  public void testGetNumberOfPunctuation() {
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement("Hello"));
    
    int expected = 0;
    int actual = s.getNumberOfPunctuation();
    assertEquals(expected, actual);
    
    s.add(new PunctuationElement(','));
    expected = 1;
    actual = s.getNumberOfPunctuation();
    
    assertEquals(expected, actual);
    
    
    s.add(new WordElement("World"));
    expected = 1;
    actual = s.getNumberOfPunctuation();
    
    assertEquals(expected, actual);
    
    s.add(new PunctuationElement('!'));
    
    expected = 2;
    actual = s.getNumberOfPunctuation();
    
    assertEquals(expected, actual);
    
  }
  
  /**
   * Thisd method tests the getNumberOfWords method. 
   */
  @Test
  public void testGetNumberOfWords() {
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement("Hello"));
    
    int expected = 1;
    int actual = s.getNumberOfWords();
    assertEquals(expected, actual);
    
    s.add(new PunctuationElement(','));
    expected = 1;
    actual = s.getNumberOfWords();
    
    assertEquals(expected, actual);
    
    
    s.add(new WordElement("World"));
    expected = 2;
    actual = s.getNumberOfWords();
    
    assertEquals(expected, actual);
    
    s.add(new PunctuationElement('!'));
    
    expected = 2;
    actual = s.getNumberOfWords();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("It"));
    expected = 3;
    actual = s.getNumberOfWords();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("is"));
    expected = 4;
    actual = s.getNumberOfWords();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("a"));
    expected = 5;
    actual = s.getNumberOfWords();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("Party"));
    expected = 6;
    actual = s.getNumberOfWords();
    
    assertEquals(expected, actual);
    
  }
  
  /**
   * This method tests the getLongestWord method. 
   */
  @Test
  public void getLongestWord() {
    
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement(""));
    
    String expected = "";
    String actual = s.longestWord();
    assertEquals(expected, actual);
    
    s.add(new PunctuationElement(','));
    expected = "";
    actual = s.longestWord();
    
    assertEquals(expected, actual);
    
    
    s.add(new WordElement("Hi"));
    expected = "Hi";
    actual = s.longestWord();
    
    assertEquals(expected, actual);
    
    s.add(new PunctuationElement(','));
    expected = "Hi";
    actual = s.longestWord();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("my"));
    expected = "Hi";
    actual = s.longestWord();
    
    assertEquals(expected, actual);
 
    
    s.add(new WordElement("Zebra"));
    expected = "Zebra";
    actual = s.longestWord();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("Beautiful"));
    expected = "Beautiful";
    actual = s.longestWord();
    
    assertEquals(expected, actual);
      
    
  }
  
  /**
   * This method tests the getNumberOfZ method. 
   */
  @Test
  public void getNumberOfZTest() {
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement("Hello"));
    int expected = 0;
    int actual = s.getNumberOfZ();
    
    assertEquals(expected, actual);
    
    s.add(new PunctuationElement(','));
    
    assertEquals(expected, actual);
    
    
    s.add(new WordElement("Zebra"));
    
    expected = 1;
    actual = s.getNumberOfZ();
    assertEquals(expected, actual);
    
    
    s.add(new WordElement("at"));
    expected = 1;
    actual = s.getNumberOfZ();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("the"));
    expected = 1;
    actual = s.getNumberOfZ();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("zoo"));
    expected = 2;
    actual = s.getNumberOfZ();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("Zedd"));
    expected = 3;
    actual = s.getNumberOfZ();
    
    assertEquals(expected, actual);
    
    s.add(new WordElement("dazzle"));
    
    expected = 4;
    actual = s.getNumberOfZ();
    assertEquals(expected, actual);
        
    
    
  }
  
  /**
   * This method tests the clone() method.
   */
  @Test
  public void testSentenceClone() {
    
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement("Hello"));
    s.add(new PunctuationElement(','));
    s.add(new WordElement("Zebra"));
    s.add(new WordElement("at"));
    s.add(new WordElement("dazzle"));
    s.add(new PunctuationElement('.'));
    
    String expected = "Hello, Zebra at dazzle.";
    
    Sentence clone = s.clone();

    assertEquals(expected, clone.toString());
    
    assertEquals(s.toString(), clone.toString());
   

    
  }
  
  /**
   * Tests the clone method. 
   */
  @Test
  public void testClone2() {
      
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement("Hello"));
    
    Sentence s2 = s.clone();
    
    String expected = s.toString();
    String actual = s2.toString();
    assertEquals(expected, actual);
    
    s.add(new WordElement("World"));
    
    expected = s.toString();
    Sentence s3 = s.clone();
    actual = s3.toString();
    assertEquals(expected, actual);
        

        
      
  }
  
  /**
   * Tests the method convertToPigLatin.
   */
  @Test
  public void testPigLatin() {
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement("Hello"));
    s.add(new PunctuationElement(','));
    s.add(new WordElement("World"));
    s.add(new PunctuationElement('!'));
    
    Sentence s2 = s.convertToPigLatin();
    String expected = "elloHay, orldWay!";
    String actual = s2.toString();
    
    assertEquals(expected, actual);
    
    s = new SentenceImpl();
    s.add(new WordElement("I"));
    s.add(new WordElement("am"));
    s.add(new WordElement("here"));
    
    s2 = s.convertToPigLatin();
    
    expected = "Iway amway erehay";
    actual = s2.toString();
    assertEquals(expected, actual);
    
    Sentence s3 = s2.convertToPigLatin();
    
    expected = "Iwayway amwayway erehayway";
    actual = s3.toString();
    assertEquals(expected, actual);
    
    
    
    
    
    
    
    
  }
  
  /**
   * Tests the merge method. 
   */
  @Test
  public void testMerge() {
    SentenceImpl s = new SentenceImpl();
    s.add(new WordElement("Hello"));
    s.add(new PunctuationElement(','));
    
    SentenceImpl s2 = new SentenceImpl();
    
    s2.add(new WordElement("World"));
    s2.add(new PunctuationElement('!'));
    
    
    
    assertEquals("Hello, World!", s.merge(s2).toString());
    
    //test that the originals have not changed 
    
    assertEquals("Hello,", s.toString());
    
    assertEquals("World!", s2.toString());
    
    
    
    
  }
}
  
  
  
  
  
  
  
  
  
  
  
  


