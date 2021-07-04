package cs5004.animator.model;

/**
 * This class creates a new ResizeWidthAnimation Object.
 * @author Katie Lowen
 *
 */
public class ResizeWidthAnimation implements Animation {
  private Shape shape;
  private int startTime;
  private int endTime;
  private double startWidth;
  private double endWidth;
  
  

  /**
   * This method creates a new ResizeHeightAnimation Object.
   * @param shape is the shape from the AbstractShape class which is for the animation class. 
   * @param startTime the start time of the ResizeHeightAnimation Object as an int. 
   * @param endTime the end time of the ResizeHeightAnimation Object as an int. 
   * @param startWidth the start height of the ResizeHeightAnimation Object as an double.
   * @param endWidth the end height of the ResizeHeightAnimation Object as an double.
   * @throws IllegalArgumentException is thrown if the start time is less 
   *     than the end time, or the start height is negative, 
   *     or the end height is negative.    
   */
  public ResizeWidthAnimation(Shape shape, int startTime, int endTime, 
      double startWidth, double endWidth) throws IllegalArgumentException {
    if (startTime > endTime) {
      throw new IllegalArgumentException("Start time must be less than end time");  
    }
    if ((startWidth < 0) || (endWidth) < 0) {
      throw new IllegalArgumentException("Width must be a positive value");
    }
    
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startWidth = startWidth;
    this.endWidth = endWidth;
    
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
    String startWidth = String.format("%.0f", this.startWidth);
    String endWidth = String.format("%.0f", this.endWidth);
    String timing = String.format(" from time t=%d to t=%d",  this.startTime, this.endTime);
    
    return name + " changes width from " + startWidth + " to " + endWidth + timing;

  }

  @Override
  public int compareTo(Animation newAnimation) {
    
    return Integer.compare(this.getStartTime(), newAnimation.getStartTime());
  }

  @Override
  public String SVGString() {
    String descriptor = "<!--" + this.toString() + " -->\n";
    
    String svg = "";
    
    if (this.shape.getType() == "Rectangle") {
     String svgType = "<animate attributeType=\"xml\"";
     String svgStartTime = " begin=\"" + this.startTime + "ms\"";
     String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
     String svgAttributeName = " attributeName=\"width\""; 
     String svgStartHeight = " from=\"" + (int) this.startWidth + "\"";
     String svgEndHeight = " to=\"" + (int) this.endWidth + "\"";
     String svgColor = " fill=\"freeze\" />" ;
      
     svg = descriptor + svgType + svgStartTime + svgDuration  
          + svgAttributeName + svgStartHeight + svgEndHeight + svgColor;
    }   
  
    if (this.shape.getType() == "Ellipse") {
      String svgType = "<animate attributeType=\"xml\"";
      String svgStartTime = " begin=\"" + this.startTime + "ms\"";
      String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
      String svgAttributeName = " attributeName=\"rx\""; 
      String svgStartHeight = " from=\"" + (int) this.startWidth + "\"";
      String svgEndHeight = " to=\"" + (int) this.endWidth + "\"";
      String svgColor = " fill=\"freeze\" />" ;
       
      svg = descriptor + svgType + svgStartTime + svgDuration  
           + svgAttributeName + svgStartHeight + svgEndHeight + svgColor;
      
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
    // TODO Auto-generated method stub
    return "ChangeWidth";
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
    return this.startWidth;
  }

  @Override
  public double getEndWidth() {
    // TODO Auto-generated method stub
    return this.endWidth;
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
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getStartGreen() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getStartBlue() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getEndRed() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getEndGreen() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getEndBlue() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getStartColor() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public double getEndColor() {
    // TODO Auto-generated method stub
    return 0;
  }


   
  
}
