import java.util.NoSuchElementException;

/**
 * This class represents a Rectangle. Rectangle has a x and y coordinate that represents 
 * the lower left corner and has a width and height. All of these are integers. 
 * @author Katie Lowen
 *
 */
public class Rectangle {
  private int x;
  private int y;
  private int width;
  private int height;
  
  /**
   * Constructs a rectangle object with the given location of its lower-left
   * corner and dimensions.
   * @param x x coordinate of the lower-left corner of this rectangle
   * @param y y coordinate of the lower-left corner of this rectangle
   * @param width  width of this rectangle
   * @param height height of this rectangle
   */
  public Rectangle(int x, int y, int width, int height) throws IllegalArgumentException {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    
    if ((width < 0) || (height < 0)) {
      throw new IllegalArgumentException("Width or Height cannot be a negative number");
    }
    
  }
  
  /**
   * This method determines if two rectangles overlap. We do this by determining if the x and y 
   * coordinates are within the other rectangle.
   * @param other is the other Rectangle object created to see if our two rectangles overlap.
   * @return returns a boolean expression of true or false if the two rectangles overlap.
   */
  public boolean overlap(Rectangle other) {
    //this method checks to see if the width coordinates of our rectangle overlaps with the x 
    //coordinate of our other rectangle (and same with height)
    
    int widthCoordinatesMain = this.x + this.width;
    int heightCoordinatesMain = this.y + this.height;
    int widthCoordinatesOther = other.x + other.width;
    int heightCoordinatesOther = other.y + other.height;
    
    if ((this.x >= widthCoordinatesOther) || (other.x >= widthCoordinatesMain)) {
      return false;
    }
    else if ((other.y >= heightCoordinatesMain) || (this.y >= heightCoordinatesOther)) {
      return false;
    }
    else if  ((this.x == widthCoordinatesOther) || (other.x == widthCoordinatesMain))  {
      return false;
    }
    return !((this.y == heightCoordinatesOther) || (other.y == heightCoordinatesMain));

  }

  /**
   * This method determines if two rectangles intersect. 
   * We do this by determining if the x and y coordinates are within the other 
   * rectangle and if so, return the size of the new Rectangle.
   * @param other is the other Rectangle object created to see if our two rectangles intersect.
   * @return returns a new Rectangle if the two rectangles overlap that represents the intersection.
   */
  public Rectangle intersect(Rectangle other) throws NoSuchElementException {
    
    //returns a rectangle object that represents the overlapping areas
    int widthCoordinatesMain = this.x + this.width;
    int heightCoordinatesMain = this.y + this.height;
    int widthCoordinatesOther = other.x + other.width;
    int heightCoordinatesOther = other.y + other.height;
    
    if ((!this.overlap(other))) {
      throw new NoSuchElementException("These rectangles do not overlap!");
    }
    
    if (other.x >= this.x & other.y >= this.y) {
      // if rectangle other is on the top right 
        
      int newX = other.x;
      int newY = other.y;
      int newWidth = Math.min(widthCoordinatesOther, widthCoordinatesMain) - other.x;
      int newHeight = Math.min(heightCoordinatesOther, heightCoordinatesMain) - other.y;
        
      return new Rectangle(newX, newY, newWidth, newHeight);
        
    }
         
    //if rectangle other is on the bottom right
    else if (other.x >= this.x & this.y >= other.y) {
        
      int newX = other.x;
      int newY = this.y;
      int newWidth = (Math.min(widthCoordinatesOther, widthCoordinatesMain) - other.x);
      int newHeight = (Math.min(heightCoordinatesOther, heightCoordinatesMain) - this.y);
      
      return new Rectangle(newX, newY, newWidth, newHeight);
        
    }
           
    //if rectangle is bottom left
      
    else if (this.x >= other.x & this.y >= other.y) {
        
      int newX = this.x;
      int newY = this.y;
      int newWidth =  Math.min(widthCoordinatesOther, widthCoordinatesMain) - this.x;
      int newHeight = Math.min(heightCoordinatesOther, heightCoordinatesMain) - this.y;
        
      return new Rectangle(newX, newY, newWidth, newHeight);
        
    }
      
    //if rectangle is top left
      
    else if (this.x >= other.x & other.y >= this.y) {
      int newX = this.x;
      int newY = other.y;
      int newWidth = Math.min(widthCoordinatesOther, widthCoordinatesMain) - this.x;
      int newHeight = Math.min(heightCoordinatesOther, heightCoordinatesMain) - other.y;
        
      return new Rectangle(newX, newY, newWidth, newHeight);
    }
    else {
      return new Rectangle(0, 0, 0, 0);
    }      
        
  }
  
  /**
   * This method creates a new rectangle object that represents the union of two
   * rectangles. The union is the smallest representation of a rectangle that contains both
   * rectangles. 
   * @param other the second rectangle object that is used to create the union. 
   * @return new Rectangle object that represents the union of the two rectangles. 
   */
  public Rectangle union(Rectangle other) {
    
    int widthCoordinatesMain = this.x + this.width;
    int heightCoordinatesMain = this.y + this.height;
    int widthCoordinatesOther = other.x + other.width;
    int heightCoordinatesOther = other.y + other.height;

    
    
    int newX = Math.min(this.x, other.x);
    int newY = Math.min(this.y, other.y);
    int newWidth = Math.abs(newX) + Math.abs(Math.max(widthCoordinatesMain, widthCoordinatesOther));
    int newHeight = Math.abs(newY) 
        + Math.abs(Math.max(heightCoordinatesMain, heightCoordinatesOther));
    
    Rectangle unionRectangle = new Rectangle(newX, newY, newWidth, newHeight);
    return unionRectangle;
  }
   
  /**
   * This returns the string representation of a Rectangle. It returns a string  
   * in the form "x: ,y: ,w: ,h: ".
   * @return returns a string representation of the Rectangle object.
   */
  public String toString() {
    String s = "x:" + this.x + ", y:" + this.y + ", w:" + this.width +  ", h:" + this.height;
    return s;
  }
}


 


