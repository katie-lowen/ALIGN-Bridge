/**
 * This is interface represents a Sentence.
 * @author Katie Lowen
 *
 */

public interface Sentence {
  
  
  /**
   * Converts a sentence to PigLatin. 
   * This will take an English Sentence, and changes each word in the
   * sentence. If the word begins with a consonant, move the leading
   * consonant to the end and append 'ay' to the end. If the word begins
   * with a vowel, append 'way' to the end. It does this for all words
   * in the Sentence. 
   * @return 
   */
  public Sentence convertToPigLatin();
  
  /**
   * Returns the number of punctuation marks in a sentence. 
   * @return the number of punctuation marks, as an integer. 
   */
  public int getNumberOfPunctuation();
  
  
  /**
   * Finds and returns the number of words containing the letter 'z' in
   * a sentence.
   * @return number of 'z' in a sentence as an integer. 
   */
  public int getNumberOfZ();
  
  
  
  /**
   * Finds and returns the number of words in the Sentence. 
   * @return an integer representing the number of words in the sentence.
   */
  public int getNumberOfWords();
  
  
  /**
   * Finds and returns the longest word in the Sentence. 
   * @return the String containing the longest word in the sentence.
   */
  public String longestWord();
  
  
  /**
   * A String of the sentence where a space separates two words. There
   * is no space prior to a punctuation mark, and if there is 
   * no punctuation at the end of the Sentence, add a period but without
   * changing the Sentence itself. 
   * @return String of this Sentence. 
   */
  public String toString();
  
  
  /**
   * Returns a copy of this Sentence. 
   * @return a duplicate copy of this Sentence. 
   */
  public Sentence clone();
  
  
  /**
   * Merges this and the other Sentence. Does this by adding the other 
   * Sentence to the end of this Sentence. 
   * @param other the sentence to combine with this Sentence. 
   * @return  the combined Sentence object. 
   */
  public Sentence merge(Sentence other);
  
  /**
   * Adds a new Sentence Element.
   * @param se is the Sentence Element being added.
   */
  public void add(SentenceElement se);

}
