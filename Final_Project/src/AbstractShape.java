//import java.awt.Color;
//
///**
// * This class represents a new public object AbstractShape.
// * @author Katie Lowen
// *
// */
//public abstract class AbstractShape {
//  protected double x;
//  protected double y;
//  protected double width;
//  protected double height;
//  protected Color color;
//  protected int timeAppears;
//  protected int timeDisappears;
//  protected int speed;
//  protected static int numbering = 1;
//  protected String name;
//  protected Shape restOfList;
//   
//  /**
//   * Creates a new Abstract Shape Object. 
//   * @param x is the x coordinate for the location of the object as a double. 
//   * @param y is the y coordinate for the location of the object as a double. 
//   * @param width is the width of the object as a double.  
//   * @param height is the height of the object as a double. 
//   * @param color is the color of the object represented as an Enum. 
//   * @param timeAppears time the object appears on screen as an int. 
//   * @param timeDisappears time the object disappears on screen as an int. 
//   * @param speed the speed of the object as an int. 
//   * @throws IllegalArgumentException is thrown when height, width, 
//   *     timeApp, timeDisapp, or speed is negative or if timeApp is after timeDisapp.  
//   */
//  public AbstractShape(double x, double y, double width, double height, 
//      Color color, int timeAppears,
//      int timeDisappears, int speed, AbstractShape restOfList) throws IllegalArgumentException {
//    if ((this.height < 0) || (this.width < 0)) { 
//      throw new IllegalArgumentException("Height and width cannot be a negative number");
//    }
//    if ((this.timeAppears < 0) || (this.timeDisappears < 0)) {
//      throw new IllegalArgumentException("Time must be a positive number");
//    }
//   
//    if (this.timeDisappears < this.timeAppears) {
//      throw new IllegalArgumentException("timeAppears must be before timeDisappears");
//    }
//     
//    if (this.speed < 0) {
//      throw new IllegalArgumentException("Speed cannot be a negative value");
//    }
//     
//    this.x = x;
//    this.y = y;
//    this.color = color;
//    this.width = width;
//    this.height = height;
//    this.timeAppears = timeAppears;
//    this.timeDisappears = timeDisappears;
//    this.speed = speed;
//    this.restOfList = restOfList;
//    
//  }
//  
////  public AbstractShape(AbstractShape newShape, AbstractShape rest) {
////    this.x = newShape.x;
////    this.y = newShape.y;
////    this.color = newShape.color;
////    this.width = newShape.width;
////    this.height = newShape.height;
////    this.timeAppears = newShape.timeAppears;
////    this.timeDisappears = newShape.timeDisappears;
////    this.speed = newShape.speed;
////    this.restOfList = newShape.restOfList;
////    
////  }
//  
////  @Override
//  public String getName() {
//    String str = "";
//    str = String.format("Shape%d",numbering);
//    numbering++;
//    
//    return str;
//    
//  }
//  
////  @Override
//  public String getLocation() {
//    String location = String.format("(%d, %d)", this.x, this.y);
//    return location;
//  }



  
  




