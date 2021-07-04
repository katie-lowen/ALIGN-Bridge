/**
 * This class represents an EmptyNode object. 
 * @author Katie Lowen
 */
public class EmptyNode implements Sentence {
  
  /**
   * This method creates a new EmptyNode object.
   */
  public EmptyNode() {
    //the empty node contains no data and no links
  }

  @Override
  public int getNumberOfWords() {
    return 0;
  }

  @Override
  public String longestWord() {
    return "";
  }

  @Override
  public Sentence clone() {
    
    return new EmptyNode();
  }
  
  @Override
  public String toString() {
    return "";
  }

  @Override
  public Sentence merge(Sentence other) {
    
    return other.clone();
  }

}
