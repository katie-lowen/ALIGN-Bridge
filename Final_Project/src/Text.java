package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.model.AnimationVisual;

//outputs to an output location --> better to be flexible so it does not have to be system.out
//give it an appendable 
//appendible we will give it is system.out, but the constructor should take any appendable, not just system.out
//don't need an this.in like in the tictactoe, just the out
//need a method that the controller will call 
//interrface could just have "display" or text output, visual output, svg output and 
//have it throw exception for unsupported operation if the view version doesnt support a certain method

// just uses appendable out, since text is likely it will be a string, which just appends the string to out
//controller is wherrre the actual work happens

public class Text implements AnimationView {


  private Appendable out;
  
  public Text(Appendable out) {
    this.out = out;
  }
  
  @Override
  public void displayText(String str) { // model.toString always call the INTERFACE 
    try {
      out.append(str);
      
      if (out instanceof FileWriter) {
        this.writeToFile("textFile.txt", str);
      }
     
    } catch (IOException e) {
      throw new IllegalStateException("Text output is not available.");
    } 
    
  }

  @Override
  public void displaySVG(String str) throws UnsupportedOperationException{
    throw new UnsupportedOperationException("displaySVG is not supported");
    // TODO Auto-generated method stub
    
  }

  @Override
  public void displayVisual(AnimationVisual model) throws UnsupportedOperationException {
    throw new UnsupportedOperationException("displayVisual is not supported");
    // TODO Auto-generated method stub
    
  }
  
  private void writeToFile(String fileName, String s) throws IOException {
    File file = new File(fileName);
    file.createNewFile();
   
    FileWriter myWriter = new FileWriter(fileName);
    myWriter.write(s);
    myWriter.close();
  }
}
