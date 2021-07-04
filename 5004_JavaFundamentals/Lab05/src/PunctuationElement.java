/**
 * This class creates a new Puctuation Element Object. 
 * @author Katie Lowen
 *
 */
public class PunctuationElement implements SentenceElement {
  
  private char punctuation;

  /**
   * Creates a new punctuation element object.
   * @param c is the punctuation in the punctuation element object. 
   */
  public PunctuationElement(char c) {
    this.punctuation = c;
    
  }
  
  /**
   * Returns a string representation of a punctuation element. 
   */
  public String toString() {
    return "" + this.punctuation;
  }

  @Override
  public int isPunctuation() {
    
    return 1;
  }

  @Override
  public int isWord() {
    
    return 0;
  }
  
  @Override
  public SentenceElement clone() {
    return new PunctuationElement(this.punctuation);
  }
  
  public int getLength() {
    return 0;
  }

  @Override
  public SentenceElement duplicate() {
    
    return new PunctuationElement(this.punctuation);
  }

  @Override
  public SentenceElement translateToPigLatin() {
    
    return new PunctuationElement(this.punctuation);
  }
  
}
