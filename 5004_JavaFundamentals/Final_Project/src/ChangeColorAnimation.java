package cs5004.animator.model;
import java.awt.Color;

public class ChangeColorAnimation implements Animation {
  
  private Shape shape;
  private int startTime;
  private int endTime;
  private Color startColor;
  private Color endColor;
  
  
  /**
   * Creates a new ChangeColorAnimation Object which changes the color of a shape. 
   * @param shape an AbstractShape object. 
   * @param startTime the start time the changing color takes place as an int. 
   * @param endTime the end time the changing color takes place as an int. 
   * @param startColor the starting color in the animation as an Enum. 
   * @param endColor the ending color in the animation as an Enum. 
   * @throws IllegalArgumentException COMPLETE!!!!!!!!!!!!!!!!!
   */
  public ChangeColorAnimation(Shape shape, int startTime, int endTime, Color startColor, 
      Color endColor) throws IllegalArgumentException {
    if (startTime > endTime) {
      throw new IllegalArgumentException("Start time must be less than end time");  
    }

    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startColor = startColor;
    this.endColor = endColor;    
  }
   
  
  @Override
  public int getStartTime() {
    
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    
    return this.endTime;
  }


  @Override 
  public String toString() {
    String name = this.shape.getName();
    String timing = String.format(" from time t=%d to t=%d",  this.startTime, this.endTime);
    String startColorS = String.format("rgb(%d,%d,%d)", 
        this.startColor.getRed(), this.startColor.getGreen(), this.startColor.getBlue());
    String endColorS = String.format("rgb(%d,%d,%d)", 
        this.endColor.getRed(), this.endColor.getGreen(), this.endColor.getBlue());
    return name + " changes from " + startColorS + " to " + endColorS + timing;
  }


  @Override
  public int compareTo(Animation newAnimation) {
    
    return Integer.compare(this.getStartTime(), newAnimation.getStartTime());
  }


  @Override
  public String SVGString() {
    String startColorS = String.format("rgb(%d,%d,%d)", 
        this.startColor.getRed(), this.startColor.getGreen(), this.startColor.getBlue());
    String endColorS = String.format("rgb(%d,%d,%d)", 
        this.endColor.getRed(), this.endColor.getGreen(), this.endColor.getBlue());
    
    String descriptor = "<!--" + this.toString() + " -->\n";
    String svg = "";
    
    if (this.shape.getType() == "Rectangle") {
       
        String svgType = "<animateColor attributeName=\"fill\" attributeType=\"xml\"";
        String svgStartTime = " begin=\"" + this.startTime + "ms\"";
        String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
        String svgStartColor = " from=\"" + startColorS + "\"";
        String svgEndColor = " to=\"" +  endColorS + "\"";
        
        
        svg = descriptor + svgType + svgStartTime + svgDuration  
              + svgStartColor + svgEndColor + " />" ;
      }   
    
    
    if (this.shape.getType() == "Ellipse") {
      
      
        String svgType = "<animateColor attributeName=\"fill\" attributeType=\"xml\"";
        String svgStartTime = " begin=\"" + this.startTime + "ms\"";
        String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
        String svgStartColor = " from=\"" + startColorS + "\"";
        String svgEndColor = " to=\"" +  endColorS + "\"";
        
        
        svg = descriptor + svgType + svgStartTime + svgDuration  
             + svgStartColor + svgEndColor + " />";
      }


    return svg;
    
  }


  @Override
  public Shape getAnimationShape() {
    
    return this.shape;
  }


  //i.e. time = 2, animation start time = 1, animation end time = 6
  public boolean shapeOnScreen(int time) {
    
    if (this.getStartTime() <= time && this.getEndTime() >= time) {
      return true;
    }
    return false;
  }


  @Override
  public String getTypeAnimation() {
    
    return "ChangeColor";
  }


  @Override
  public double getStartX() {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public double getStartY() {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public double getEndX() {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public double getEndY() {
    // TODO Auto-generated method stub
    return 0;
  }




  @Override
  public double getStartWidth() {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public double getEndWidth() {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public double getStartHeight() {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public double getEndHeight() {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public double getStartRed() {
    
    return this.startColor.getRed();
  }


  @Override
  public double getStartGreen() {
    
    return this.startColor.getGreen();
  }


  @Override
  public double getStartBlue() {
    
    return this.startColor.getBlue();
  }


  @Override
  public double getEndRed() {
    
    return this.endColor.getRed();
  }


  @Override
  public double getEndGreen() {
    
    return this.endColor.getGreen();
  }


  @Override
  public double getEndBlue() {
    
    return this.endColor.getBlue();
  }


  @Override
  public double getStartColor() {
    // TODO Auto-generated method stub
    return this.startColor.getRGB();
  }


  @Override
  public double getEndColor() {
    // TODO Auto-generated method stub
    return this.endColor.getRGB();
  }
  




}
