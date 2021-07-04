package cs5004.animator.model;

/**
 * This class creates a new ResizeHeightAnimation Object. 
 * @author Katie Lowen
 *
 */
public class ResizeHeightAnimation implements Animation {
  private Shape shape;
  private int startTime;
  private int endTime;
  private double startHeight;
  private double endHeight;
  
  
  /**
   * This method creates a new ResizeHeightAnimation Object.
   * @param shape is the shape from the AbstractShape class which is for the animation class. 
   * @param startTime the start time of the ResizeHeightAnimation Object as an int. 
   * @param endTime the end time of the ResizeHeightAnimation Object as an int. 
   * @param startHeight the start height of the ResizeHeightAnimation Object as an double.
   * @param endHeight the end height of the ResizeHeightAnimation Object as an double.
   * @throws IllegalArgumentException is thrown if the start time is less 
   *     than the end time, or the start height is negative, 
   *     or the end height is negative. 
   *     
   */
  public ResizeHeightAnimation(Shape shape, int startTime, int endTime, 
      double startHeight, double endHeight) throws IllegalArgumentException {
    if (startTime > endTime) {
      throw new IllegalArgumentException("Start time must be less than end time");  
    }
    if ((startHeight < 0) || (endHeight) < 0) {
      throw new IllegalArgumentException("Height must be a positive value");
    }
    
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startHeight = startHeight;
    this.endHeight = endHeight;
    
  }

  @Override
  public int getStartTime() {
    
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    
    return this.startTime;
  }
  
  @Override 
  public String toString() {
    String name = this.shape.getName();
    String startHeight = String.format("%.0f", this.startHeight);
    String endHeight = String.format("%.0f", this.endHeight);
    String timing = String.format(" from time t=%d to t=%d",  this.startTime, this.endTime);
    
    return name + " changes height from " + startHeight + " to " + endHeight + timing;
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
     String svgAttributeName = " attributeName=\"height\""; 
     String svgStartHeight = " from=\"" + (int) this.startHeight + "\"";
     String svgEndHeight = " to=\"" + (int) this.endHeight + "\"";
     String svgColor = " fill=\"freeze\" />" ;
      
     svg = descriptor + svgType + svgStartTime + svgDuration  
          + svgAttributeName + svgStartHeight + svgEndHeight + svgColor;
    }   
  
    if (this.shape.getType() == "Ellipse") {
      String svgType = "<animate attributeType=\"xml\"";
      String svgStartTime = " begin=\"" + this.startTime + "ms\"";
      String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
      String svgAttributeName = " attributeName=\"ry\""; 
      String svgStartHeight = " from=\"" + (int) this.startHeight + "\"";
      String svgEndHeight = " to=\"" + (int) this.endHeight + "\"";
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
    
    return "ChangeHeight";
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
    return this.startHeight;
  }

  @Override
  public double getEndHeight() {
    // TODO Auto-generated method stub
    return this.endHeight;
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
