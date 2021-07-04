
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * This is the public class for SentenceImpl.
 * @author Katie Lowen
 *
 */
public class SentenceImpl implements Sentence {
  LinkedList<SentenceElement> l;
  
  /**
   * This method creates a new SentenceImpl Object. 
   */
  public SentenceImpl() {
    l = new LinkedList<SentenceElement>();
    
  }
  
  /**
   * Returns a string representation of a word element. 
   */
  public SentenceImpl(LinkedList<SentenceElement> inList) {
    this.l = inList;
  }
  
  /**
   * This method adds a SentenceElement to the SentenceImpl.
   * @param se is a SentenceElement Object.
   */
  @Override
  public void add(SentenceElement se) {
    l.add(se);
  }

  /**
   * This is the toString method for the SentenceImpl Object. 
   */
  public String toString() {
    //    ListIterator<SentenceElement> li = l.listIterator(0);
    //    
    //    SentenceElement se;
    //    String output;
    //    output = "";
    //    
    //    while (li.hasNext()) {
    //      se = li.next();
    //      output = output + "" + se.toString();
    //    }
    //    
    //    return output.trim();
    
    String output;
    return this.l.stream().map(s -> s.toString()).reduce("", String::concat).trim();
    //or this.l.stream().map(element -> element.toString()).reduce("",(a,b)->a+b).trim();
  }
      
      
  
  @Override
  public Sentence convertToPigLatin() {
    //    SentenceImpl pigLatin = new SentenceImpl();
    //    ListIterator<SentenceElement> li = l.listIterator(0);
    //    SentenceElement se;
    //    while (li.hasNext()) {
    //      se = li.next();
    //      pigLatin.add(se.translateToPigLatin());
    //    }
    //    return pigLatin;
        
    //    SentenceImpl pigLatin = new SentenceImpl();
    
    LinkedList<SentenceElement> list2 = this.l.stream()
        .map(element -> element.translateToPigLatin())
        .collect(Collectors.toCollection(LinkedList::new));
    SentenceImpl pigLatin = new SentenceImpl(list2);
    return pigLatin;
  }
    
    
    
    
    
    
    
 

  @Override
  public int getNumberOfPunctuation() {

    return this.l.stream().mapToInt(s -> s.isPunctuation()).sum();
    
    /*
    ListIterator<SentenceElement> li = l.listIterator(0);
    
    SentenceElement se;
    int output;
    output = 0;
    
    while(li.hasNext()) {
      se = li.next();
      output = output + se.isPunctuation();
    }
    
    return output;
  }
    */
    
  }
  

  @Override
  public int getNumberOfZ() {
    return (int) this.l.stream().filter(element -> element.toString().contains("z")
        || element.toString().contains("Z")).count();
  }
    

  

  @Override
  public int getNumberOfWords() {
    //    ListIterator<SentenceElement> li = l.listIterator(0);
    //    
    //    SentenceElement se;
    //    int output;
    //    output = 0;
    //    
    //    while(li.hasNext()) {
    //      se = li.next();
    //      output = output + se.isWord();
    //    }
        
    //    return output;
    return this.l.stream().mapToInt(s -> s.isWord()).sum();
    
  }

  @Override
  public String longestWord() {
    //    ListIterator<SentenceElement> li = l.listIterator(0);
    //    
    //    SentenceElement se;
    //    String output;
    //    output = "";
    //    
    //    while (li.hasNext()) {
    //      
    //      se = li.next();
    //      if (output.length() >= se.toString().trim().length()) {
    //        continue;
    //      } else {
    //        output = se.toString().trim();
    //      }
    //      
    //    }
    //    
    //    return output;
    
    //    int maxLength = this.l.stream().
    //mapToInt(element -> element.getLength()).reduce(0, Integer::max);
    //    if(maxLength == 0) {
    //      return "";
    //    }
    //    return this.l.stream().filter(element -> 
    //element.getLength() == maxLength).findFirst().get().toString().trim();
    //   or int maxLength = this.l.stream().mapToInt
    //(element -> element.getLength()).reduce(0,(a,b) -> a> b ? a : b);
    
    if (l.size() > 0) {
      //or return this.l.stream().reduce(new WordElement(""), 
      //SentenceElement::getBigger.toString().trim()
      return this.l.stream().reduce(new WordElement(""),
          (a,b) -> a.getLength() < b.getLength() ? b : a).toString().trim();
    
    }
    return "";
    
  }

  @Override
  public Sentence clone() {
    //    SentenceImpl s = new SentenceImpl();
    //    SentenceElement se = l.get(0);
    //    s.add(se);
    // 
    //    return s;
    
    
    LinkedList<SentenceElement> l2 = this.l.stream().map(element -> element.duplicate())
        .collect(Collectors.toCollection(LinkedList::new));
        
    SentenceImpl  s2 = new SentenceImpl(l2);
    
    return s2;

    //    return l2;
        
    //    SentenceImpl output = new SentenceImpl();
    //    ListIterator<SentenceElement> li = l.listIterator(0);
    //    
    //    SentenceElement se;
    //    while (li.hasNext()) {
    //      se = li.next();
    //      
    //      output.add(se.clone());
    //    }
    //    
    //    return output;
  }

  @Override
  public Sentence merge(Sentence other) {
    
    Sentence s2 = this.clone();
    Scanner s = new Scanner(other.toString());
    String token;
    
    while (s.hasNext()) {
      token = s.next();
      if ("abcdefghijklmnopqrstuvwxyz".contains(token.toLowerCase().substring(0, 0)) 
          & "abcdefghijklmnopqrstuvwxyz".contains(token.toLowerCase().substring(token.length()))) {
        s2.add(new WordElement(token));
        continue;  
      }
      while (!("abcdefghijklmnopqrstuvwxyz".contains(token.toLowerCase().substring(0, 0)))) {
        s2.add(new PunctuationElement(token.charAt(0)));
        token = token.substring(1);
      }
     
      LinkedList<Character> endingPunctuation = new LinkedList();

      while (!("abcdefghijklmnopqrstuvwxyz".contains(token.toLowerCase()
         .substring(token.length())))) {
        endingPunctuation.add(new Character(token.charAt(token.length())));
       
        //       s2.add(new PunctiationElement(token.charAt(token.length())));
        token = token.substring(0,  token.length() - 1);
      }
     
      if (!token.isEmpty()) {
        s2.add(new WordElement(token));
      }
     
      if (!endingPunctuation.isEmpty()) {
        for (int num : endingPunctuation) {
          s2.add(new PunctuationElement(endingPunctuation.getLast()));
          endingPunctuation.removeLast();
       
        }
      }
          
 

    
    }
    return s2;
  

  }
}















