package cs5004.animator.model;

public class MoveAnimation implements Animation {
  
  private Shape shape;
  private int startTime;
  private int endTime; 
  private double startX;
  private double startY;
  private double endX;
  private double endY;
  private double currentX;
  private double currentY;
  
  

  /**
   * 
   * @param shape
   * @param startTime
   * @param endTime
   * @param startX
   * @param startY
   * @param endX
   * @param endY
   * @throws IllegalArgumentException
   */
  public MoveAnimation(Shape shape, int startTime, int endTime, double startX, double startY,
      double endX, double endY) throws IllegalArgumentException {
    if (startTime > endTime) {
      throw new IllegalArgumentException("Start time must be less than end time");  
    }

    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;   
    this.currentX = startX;
    this.currentY = startY;
    
    
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
    String start = String.format("(%.0f, %.0f)", this.startX, this.startY);
    String end = String.format("(%.0f, %.0f)", this.endX, this.endY);
    String timing = String.format(" from time t=%d to t=%d",  this.startTime, this.endTime);
    
    return name + " moves from " + start + " to " + end + timing;
   
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
      
      if (this.startX != this.endX) {
      
        //add instance of rect vs ellipse 
      
    
        String svgType = "<animate attributeType=\"xml\"";
        String svgStartTime = " begin=\"" + this.startTime + "ms\"";
        String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
        String svgAttributeName = " attributeName=\"x\""; 
        String svgXStart = " from=\"" + (int) this.startX + "\"";
        String svgXEnd = " to=\"" + (int) this.endX + "\"";
        String svgColor = " fill=\"freeze\" />" ;
      
        svg = descriptor + svgType + svgStartTime + svgDuration  
          + svgAttributeName + svgXStart + svgXEnd + svgColor;
   
      }
    
      if (this.startY != this.endY) {
        String svgType = "<animate attributeType=\"xml\"";
        String svgStartTime = " begin=\"" + this.startTime + "ms\"";
        String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
        String svgAttributeName = " attributeName=\"y\""; 
        String svgYStart = " from=\"" + (int) this.startY + "\"";
        String svgYEnd = " to=\"" + (int) this.endY + "\"";
        String svgColor = " fill=\"freeze\" />" ;
        
        svg = descriptor + svgType + svgStartTime + svgDuration  
            + svgAttributeName + svgYStart + svgYEnd + svgColor;
      }   
    }
    
    if (this.shape.getType() == "Ellipse") {
      if (this.startX != this.endX) {
      
        String svgType = "<animate attributeType=\"xml\"";
        String svgStartTime = " begin=\"" + this.startTime + "ms\"";
        String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
        String svgAttributeName = " attributeName=\""
            + "cx\""; 
        String svgXStart = " from=\"" + (int) this.startX + "\"";
        String svgXEnd = " to=\"" + (int) this.endX + "\"";
        String svgColor = " fill=\"remove\" />" ;
  
        svg = descriptor + svgType + svgStartTime + svgDuration  
          + svgAttributeName + svgXStart + svgXEnd + svgColor;
 
      }
  
      if (this.startY != this.endY) {
        String svgType = "<animate attributeType=\"xml\"";
        String svgStartTime = " begin=\"" + this.startTime + "ms\"";
        String svgDuration = " dur=\"" + (this.endTime - this.startTime) + "ms\"";
        String svgAttributeName = " attributeName=\"cy\""; 
        String svgYStart = " from=\"" + (int) this.startY + "\"";
        String svgYEnd = " to=\"" + (int) this.endY + "\"";
        String svgColor = " fill=\"remove\" />" ;
      
        svg = descriptor + svgType + svgStartTime + svgDuration  
          + svgAttributeName + svgYStart + svgYEnd + svgColor;
      }
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

  public double getStartX() {
    return this.startX;
  }
  
  public double getStartY() {
    return this.startY;
  }
  
  public double getEndX() {
    return this.endX;
  }
  
  public double getEndY() {
    return this.endY;
  }
  


  @Override
  public String getTypeAnimation() {
    
    return "Move";
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
