/**
 * This class represents a public WordNode.
 * @author Katie Lowen
 */
public class WordNode implements Sentence {
  private String word;
  private Sentence rest;

  /**
   * This method creates a new WordNode object.
   * @param word is the string representation of a word.
   * @param rest is the rest of the Sentence. 
   */
  public WordNode(String word, Sentence rest) {
    this.word = word;
    this.rest = rest;
  }
  
  @Override
  public int getNumberOfWords() {
    return this.rest.getNumberOfWords() + 1;
  }
  
  @Override
  public String longestWord() {
    String s = this.rest.longestWord();
    
    if (this.word.length() > s.length()) {
      return this.word;
    }
    
    else {
      return s;
    }
  }

  @Override
  public Sentence clone() {
    return new WordNode(this.word, this.rest.clone());
    
  }
  
  @Override
  public String toString() {
    
    String s = this.word;
    
    if (this.rest instanceof WordNode) {
      s = s + " " + this.rest.toString();
    } 
    else if (this.rest instanceof EmptyNode) {
      s = s + "." + this.rest.toString();
    }
    else {
      s = s + this.rest.toString();
    }
    
    return s;
  }

  @Override
  public Sentence merge(Sentence other) {
    
    return new WordNode(this.word, this.rest.merge(other));
  }

}
