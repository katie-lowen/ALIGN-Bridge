package cs5004.animator.model;
import java.awt.Color;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


public class AnimationModelImpl implements AnimationModel, AnimationVisual {
  private List<Shape> shapeList; 
  private List<Animation> animationList; 
  private int time;
  private String timeline;
  private int dimensionWidth;
  private int dimensionHeight;
  private int dimensionX;
  private int dimensionY;
  
  public AnimationModelImpl() {
    this.shapeList = new ArrayList<Shape>();
    this.animationList = new ArrayList<Animation>();
    this.dimensionWidth = 700;
    this.dimensionHeight = 500;
  }
  

  @Override
  public void addShape(Shape newShape) {
    this.shapeList.add(newShape); 
    
    Collections.sort((shapeList));
    
  }
  
  @Override
  public void addAnimation(Animation newAnimation) {

    this.animationList.add(newAnimation);
    Collections.sort((animationList));
    
  }
  
  @Override
  public String toString() {

    
    String str = "";
    for (Shape shape : shapeList){
      str += shape.toStringShape() + "\n";
    }
    
    str += "\n";
    
    for (Shape shape : shapeList){
      str += shape.toStringTime() + "\n";
    }
    
    str += "\n";
    
    for (Animation animation : animationList){
      str += animation.toString() + "\n";
    }
    
    return str;
    
  }


  @Override
  public String toStringSVG() {
    String intro = "<svg width=\"" + this.getDimensionsWidth() + "\" height=\"" + this.getDimensionsHeight() + 
        "\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n";

    
    String str = "";
    for (Shape shape : shapeList){
      str += shape.SVGString() + "\n";
      for (Animation animation : animationList){
        if(shape == animation.getAnimationShape())
          str += animation.SVGString() + "\n";
      }
      if(shape.getType() == "Rectangle") {
        str += "</rect>\n";
      }
      if(shape.getType() == "Ellipse") {
        str += "</ellipse>\n";
      }
      
      
      }
    return  intro + str + "</svg>";
    
    }




  @Override
  public List<Animation> getAnimationList() {
    
    return this.animationList;
  }


  @Override
  public List<Shape> getShapeList() {
    
    return this.shapeList;
  }



  @Override
  public int getDimensionsX() {
    
    return this.dimensionX;
  }


  @Override
  public int getDimensionsY() {
    // TODO Auto-generated method stub
    return this.dimensionY;
  }


  @Override
  public int getDimensionsWidth() {
    // TODO Auto-generated method stub
    return this.dimensionWidth;
  }


  @Override
  public int getDimensionsHeight() {
    // TODO Auto-generated method stub
    return this.dimensionHeight;
  }


  @Override
  public void setDimensionsX(int x) {
    this.dimensionX = x;
    
  }


  @Override
  public void setDimensionsY(int y) {
    this.dimensionY = y;
    
  }


  @Override
  public void setDimensionsWidth(int width) {
    // TODO Auto-generated method stub
    
  }


  @Override
  public void setDimensionsHeight(int height) {
    this.dimensionHeight = height;
    
  }


  
  








    










}










