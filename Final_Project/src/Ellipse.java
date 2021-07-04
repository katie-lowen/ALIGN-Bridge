package cs5004.animator.model;
import java.awt.Color;

/**
 * Creates a new Ellipse Object.
 * @author Katie Lowen
 *
 */
public class Ellipse implements Shape, Comparable<Shape>{
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
   * Creates a new Ellipse Object. 
   * @param x horizontal coordinate for the center point. 
   * @param y vertical coordinate for the center point. 
   * @param width horizontal diameter of the ellipse.
   * @param height vertical diameter of the ellipse. 
   * @param color color as an Enum of the Ellipse Object.
   * @param timeAppears int representation of the time the object appears on screen. 
   * @param timeDisappears int representation of the time the object appears on screen. 
   * @param speed int representation of the speed of an Object. 
   * @param rest is the rest of the List of Shape objects. 
   */
  public Ellipse(String name, double x, double y, double width, double height, Color color, int timeAppears,
      int timeDisappears, int speed) {
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
    String objectName = "ellipse " + this.objectName;
    String dimensions = String.format(" with center at (%.0f, %.0f), radius %.0f and %.0f", this.x, this.y, this.width, this.height);
    
    str += colorDescription + objectName + dimensions;
    
    return str;
    
  }
  
  public String toStringTime() {
   String objectName = this.objectName;
   String time = String.format(" appears at time "
       + "t=%d and disappears at time t=%d", this.timeAppears,this.timeDisappears);
   String str = objectName + time;
   return str;
  }

  
  /**
   * Creates a toString representation of an Ellipse Object.
   * @return a String representation of an Ellipse Object. 
   */
  public String toString() {
    String str = "";
    String title = "Name: " + this.objectName + "\n";
    String type = "Type: ellipse\n";
    String location = String.format("Center: (%.0f,%.0f), Width: %.0f, Height: %.0f,",
        this.x, this.y, this.width, this.height);
    String colorString = String.format(" Color: (%d,%d,%d)\n",
        this.color.getRed(), this.color.getGreen(), this.color.getBlue());
    String timeApp = String.format("Appears at t=%d\n", this.timeAppears);
    String timeDisap = String.format("Disappears at t=%d", this.timeDisappears);
    
    str = title + type + location + colorString + timeApp + timeDisap; 
      
    return str;

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
  public String getName() {
    
    return this.objectName;
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
    
    String svgName = "<ellipse id=\"" + this.getName() + "\"";
    String svgX = " cx=\"" + this.getX() + "\"";
    String svgY = " cy=\"" + this.getY() + "\"";
    String svgWidth = " rx=\"" + this.getWidth() + "\"";
    String svgHeight = " ry=\"" + this.getHeight() + "\"";
    String svgColor = " fill=\"" + this.getColor();
    String svgVisibility = " visibility=\"visible\" >";
    
    
    
    String svg = descriptor + svgName + svgX + svgY + 
        svgWidth + svgHeight + svgColor + svgVisibility;
    
    return svg;
  }



  @Override
  public String getType() {
    
    return "Ellipse";
  }



  @Override
  public Color getNumberColor() {
    
    return this.color;
  }
  
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
    
    return this.currentWidth;
  }


  @Override
  public double getCurrentHeight() {
    
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

