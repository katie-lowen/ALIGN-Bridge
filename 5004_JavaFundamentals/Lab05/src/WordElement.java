
/**
 * This class creates a new WordElement Object.
 * @author Katie Lowen
 *
 */
public class WordElement implements SentenceElement {

  public String word;

  /**
   * This method creates a new Word Element object. 
   * @param word is the word used to create a Word Element Object. 
   */
  public WordElement(String word) {
    this.word = word;
  }
  
  /**
   * Creates a string representation of a WordElement object.
   */
  public String toString() {
    return " " + word;
  }
  
  @Override
  public int isPunctuation() {
    
    return 0;
  }
  
  @Override
  public int isWord() {
    
    return 1;
  }
  
  @Override
  public SentenceElement clone() {
    return new WordElement(this.word);
  }
  
  
  public int getLength() {
    return this.word.length();
  }
  
  @Override
  public SentenceElement duplicate() {
    
    return new WordElement(this.word);
  }
  
  @Override
  public SentenceElement translateToPigLatin() {
    
    if ("aeiouyAEIOUY".contains(this.word.charAt(0) + "")) {
      return new WordElement(this.word + "way");
      
    }
    
    String translatedWord;
    translatedWord = this.word.substring(1) + this.word.charAt(0) + "ay";
    return new WordElement(translatedWord);
    
    //  if (this.word.charAt(0) == 'a' || this.word.charAt(0) == 'e' 
    //      || this.word.charAt(0) == 'i' || this.word.charAt(0) == 'i' 
    //      || this.word.charAt(0) == 'u' || this.word.charAt(0) =='y') {
    //    return new WordElement(this.word + "way");
    
    
    
    
  
  }




}
