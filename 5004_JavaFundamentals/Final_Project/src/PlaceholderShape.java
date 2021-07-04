import java.awt.Color;

public class PlaceholderShape implements Shape {

  public PlaceholderShape() {
    return;
  }
  
  @Override
  public Shape addShape(Shape newShape) {       
   
    return newShape;
  }
  
  @Override
  public String toStringShape() {
    
    return "";
  }

  @Override
  public String toStringTime() {
    
    return "";
  }

  @Override
  public String getName() {
    
    return "";
  }

  @Override
  public String getLocation() {
    
    return "";
  }

  @Override
  public int getStartTime() {
    
    return 0;
  }
  
  public String toString() {
    return "";
  }







}
