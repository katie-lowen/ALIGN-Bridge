
public class PlaceholderAnimation implements Animation{
  
  public PlaceholderAnimation() {
    return; 
  }

  @Override
  public int getStartTime() {
    
    return 0;
  }

  @Override
  public int getEndTime() {
    
    return 0;
  }

  @Override
  public Animation addAnimation(Animation newAnimation) {
    
    return newAnimation;
    
  }
  
  public String toString() {
    return "";
  }

}
