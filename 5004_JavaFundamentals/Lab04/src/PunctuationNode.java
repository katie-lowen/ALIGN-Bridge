/**
 * This class creates a new PunctuationNode object.
 * @author Katie Lowen
 *
 */
public class PunctuationNode implements Sentence {
  private Sentence rest;
  private char punctuation;
  
  /**
   * This method creates a PunctuationNode object. 
   * @param punctuation is a character that represents punctuation. 
   * @param rest is the rest of the Nodes that make up a sentence. 
   */
  public PunctuationNode(char punctuation, Sentence rest) {
    this.punctuation = punctuation;
    this.rest = rest;
  }
  

  @Override
  public int getNumberOfWords() {
    return this.rest.getNumberOfWords();
  }

  @Override
  public String longestWord() {
    return this.rest.longestWord();
  }

  @Override
  public Sentence clone() {
    return new PunctuationNode(this.punctuation, this.rest.clone());
  }
  
  @Override
  public String toString() {
    String s;

    if (this.rest instanceof EmptyNode) {
      s = "" + this.punctuation + this.rest.toString();
    } else {
      s = "" + this.punctuation + " " + this.rest.toString();
    }
    return s;
   
  }

  @Override
  public Sentence merge(Sentence other) {
    
    return new PunctuationNode(this.punctuation, this.rest.merge(other));
  }

}
