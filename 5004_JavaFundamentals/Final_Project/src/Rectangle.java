package cs5004.animator.model;
import java.awt.Color;


/**
 * Creates a new AbstractShape Object.
 * @author Katie Lowen
 *
 */
public class Rectangle implements Shape{
  private double x;
  private double y;
  private double width;
  private double height;
  private Color color;
  private int timeAppears;
  private int timeDisappears;
  private int speed;
  private String objectName;
  
  private double currentX;
  private double currentY;
  private double currentWidth;
  private double currentHeight;
  private Color currentColor;

  /**
   * Creates a new Rectangle Object. 
   * @param x horizontal coordinate for the lower left corner point. 
   * @param y vertical coordinate for the lower left corner point. 
   * @param width horizontal length of the rectangle.
   * @param height vertical length of the rectangle. 
   * @param color color as an Enum of the Rectangle Object.
   * @param timeAppears int representation of the time the object appears on screen. 
   * @param timeDisappears int representation of the time the object appears on screen. 
   * @param speed int representation of the speed of an Object. 
   */
  public Rectangle(String name, double x, double y, double width, double height, Color color, 
      int timeAppears, int timeDisappears, int speed) {
    
    if ((height < 0) || (width < 0)) { 
      throw new IllegalArgumentException("Height and width cannot be a negative number");
    }
    if ((timeAppears < 0) || (timeDisappears < 0)) {
      throw new IllegalArgumentException("Time must be a positive number");
    }
   
    if (timeDisappears < timeAppears) {
      throw new IllegalArgumentException("timeAppears must be before timeDisappears");
    }
     
    if (speed < 0) {
      throw new IllegalArgumentException("Speed cannot be a negative value");
    }
     
    this.x = x;
    this.y = y;
    this.color = color;
    this.width = width;
    this.height = height;
    this.timeAppears = timeAppears;
    this.timeDisappears = timeDisappears;
    this.speed = speed;
    this.objectName = name;
    this.currentX = x;
    this.currentY = y;
    this.currentColor = color;
    this.currentWidth = width;
    this.currentHeight = height;
    
   
  }

  
  //change COLOR to the actual color
  public String toStringShape() {
    String str = "";
    str = "Create";
    String colorDescription = String.format(" rgb(%d,%d,%d) ", this.color.getRed(), 
        this.color.getGreen(), this.color.getBlue());
    String name = "rectangle " + this.objectName;
    String dimensions = String.format(" with corner at (%.0f, %.0f), width %.0f and height %.0f", this.x, this.y, this.width, this.height);
    
    str += colorDescription + name + dimensions;
    
    return str;
    
  }
  
  public String toStringTime() {
   String name = this.objectName;
   String time = String.format(" appears at time "
       + "t=%d and disappears at time t=%d", this.timeAppears,this.timeDisappears);
   String str = name + time;
   return str;
  }


  /**
   * Creates a String representation of a Rectangle Object.
   * @return string representation of a Rectangle Object. 
   */
  public String toString() {
    String str = "";
    String title = "Name: " + this.objectName + "\n";
    String type = "Type: rectangle\n";
    String location = String.format("Min corner: (%.0f,%.0f), Width: %.0f, Height: %.0f,",
         this.x, this.y, this.width, this.height);
    String colorString = String.format(" Color: (%d,%d,%d)\n", this.color.getRed(), 
        this.color.getGreen(), this.color.getBlue());
    String timeApp = String.format("appears at t=%d\n", this.timeAppears);
    String timeDisap = String.format("disappears at t=%d", this.timeDisappears);
    
    str = title + type + location + colorString + timeApp + timeDisap;
     
    return str;
    
  }


  @Override
  public String getName() {

    return this.objectName;    
    
  }


  @Override
  public String getLocation() {
    String location = String.format("(%d, %d)", this.x, this.y);
    return location;
  }



  @Override
  public int getStartTime() {
    
    return this.timeAppears;
  }




  
  @Override
  public int compareTo(Shape newShape) {
    
    return Integer.compare(this.getStartTime(), newShape.getStartTime());
  }
  

  public int getX() {
    return (int)this.x;
  }
  
  public int getY() {
    return (int)this.y;
  }


  @Override
  public int getWidth() {
   
    return (int)this.width;
  }


  @Override
  public int getHeight() {
    
    return (int)this.height;
  }


  @Override
  public String getColor() {
    String colorString = String.format("rgb(%d,%d,%d)\"", this.color.getRed(), 
        this.color.getGreen(), this.color.getBlue());
    
    return colorString;
  }


  @Override
  public String SVGString() {
    
    String descriptor = "<!--"+ this.toStringShape() + " -->\n";
    
    String svgName = "<rect id=\"" + this.getName() + "\"";
    String svgX = " x=\"" + this.getX() + "\"";
    String svgY = " y=\"" + this.getY() + "\"";
    String svgWidth = " width=\"" + this.getWidth() + "\"";
    String svgHeight = " height=\"" + this.getHeight() + "\"";
    String svgColor = " fill=\"" + this.getColor();
    String svgVisibility = " visibility=\"visible\" >";
    
    
    
    String svg = descriptor + svgName + svgX + svgY + 
        svgWidth + svgHeight + svgColor + svgVisibility;
    
    return svg;
  }


  @Override
  public String getType() {
    
    return "Rectangle";
  }


  @Override
  public Color getNumberColor() {
    
    return this.color;
  }
  
//  public void changeX(int newX) {
//    this.x = newX;
//  }


  @Override
  public double getCurrentX() {
    
    return this.currentX;
  }


  @Override
  public double getCurrentY() {
    // TODO Auto-generated method stub
    return this.currentY;
  }


  @Override
  public double getCurrentWidth() {
    // TODO Auto-generated method stub
    return this.currentWidth;
  }


  @Override
  public double getCurrentHeight() {
    // TODO Auto-generated method stub
    return this.currentHeight;
  }





  @Override
  public void setCurrentX(double newX) {
    this.currentX = newX;
    
  }


  @Override
  public void setCurrentY(double newY) {
    
    this.currentY = newY;
  }


  @Override
  public void setCurrentWidth(double newWidth) {
    this.currentWidth = newWidth;
    
  }


  @Override
  public void setCurrentHeight(double newHeight) {
   this.currentHeight = newHeight;
    
  }


  @Override
  public void setCurrentColor(Color newColor) {
    this.currentColor = newColor;
    
  }


  @Override
  public double getCurrentRed() {
    
    return this.currentColor.getRed();
  }


  @Override
  public double getCurrentGreen() {
    
    return this.currentColor.getGreen();
  }


  @Override
  public double getCurrentBlue() {
    
    return this.currentColor.getBlue();
  }


  @Override
  public Color getCurrentColor() {
    // TODO Auto-generated method stub
    return this.currentColor;
  }





//  @Override
//  public void setCurrentColor(double r, double g, double b) {
//    Color newCurrent = new Color((int)r,(int)g,(int)b);
//    this.currentColor = newCurrent;
//    
//  }
  









  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
  

}
