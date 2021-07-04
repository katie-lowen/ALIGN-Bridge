import java.awt.Color;

public class ChangeSpeedAnimation implements Animation {
  private Shape shape;
  private int startTime;
  private int endTime;
  private int startSpeed;
  private int endSpeed;
  
  public ChangeSpeedAnimation(Shape shape, int startTime, int endTime, 
      int startSpeed, int endSpeed) throws IllegalArgumentException {
    if (startTime > endTime) {
      throw new IllegalArgumentException("Start time must be less than end time");   
      
    }
    
    this.shape = shape;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startSpeed = startSpeed;
    this.endSpeed = endSpeed;
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
    String str = "";
    String name = this.shape.getName();
    String speedChange = String.format(" changes speed from %d to %d",  this.startSpeed, this.endSpeed);
    String timing = String.format(" from time t=%d to t=%d",  this.startTime, this.endTime);
    str = name + speedChange + timing;
    
    
    return str;
  }


}
