
/**
 * This method creates a new SentenceElement Class.
 * @author Katie Lowen
 *
 */
public interface SentenceElement {
  
  /**
   * Returns 1 if the element is a PunctuationElement, and 0 if it is not. 
   * @return return 1 if it is a PunctuationElement, 0 if it is not. 
   */
  public int isPunctuation();
  
  
  /**
   * Returns 1 if the element is a WordElement, and 0 otherwise.
   * @return 1 if it is a WordElement, else 0.
   */
  public int isWord();
  
  /**
   * Creates and returns a clone of the SentenceElement.
   * @return clone of the SentenceElement.
   */
  public SentenceElement clone();
  
  /**
   * Gets the length of a SentenceElement as an integer.
   * @return length of the SentenceElement as an integer.
   */
  public int getLength();
  
  /**
   * This method creates a duplicate of the Sentence Element.
   * @return a new Sentence Element.
   */
  public SentenceElement duplicate();
  
  /**
   * This method converts a sentence element into the form of pig latin.
   * @return a sentence element in the form of pig latin. 
   */
  public SentenceElement translateToPigLatin();
  

}
