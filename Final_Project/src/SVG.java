package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AnimationVisual;

public class SVG implements AnimationView {
  
  private Appendable out;


  
  public SVG(Appendable out) {
    this.out = out;


  }
  

  



  @Override
  public void displayText(String str) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("displayText is not supported");
   
    
  }
  
  @Override
  public void displaySVG(String str) {
    try {
      out.append(str);
      
      if(out instanceof FileWriter) {      
        this.writeToFile("testSVG2.txt", str);
      
      }
      
     
    } catch (IOException e) {
      throw new IllegalStateException("SVG output is not available.");
    } 
    
    
    
  }
    
    
  

  @Override
  public void displayVisual(AnimationVisual model) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("displayVisual is not supported");
    
  }
  
  
  private void writeToFile(String fileName, String s) throws IOException {
    File file = new File(fileName);
    file.createNewFile();
   
    FileWriter myWriter = new FileWriter(fileName);
    myWriter.write(s);
    myWriter.close();
  }



}
