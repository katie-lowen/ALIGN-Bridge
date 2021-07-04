package cs5004.animator.model;
import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

//import cs5004.animator.model.AnimationModel;
//import cs5004.animator.model.AnimationModelImpl;
import cs5004.animator.*;

public class AnimationModelImplTest {

  @Test
  public void testShapeList() {
    Shape shape1 = new Rectangle("R", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    Shape shape2 = new Ellipse("E", 500.0, 100.0, 60.0, 30.0, Color.BLUE, 6, 100, 1);
    
    Animation animation1 = new MoveAnimation(shape1, 10, 50, 200.0, 200.0, 300.0, 300.0);
    Animation animation2 = new MoveAnimation(shape2, 20, 70, 500.0, 100.0, 500.0, 400.0);
    Animation animation3 = new ChangeColorAnimation(shape2, 50, 80, Color.BLUE, Color.GREEN);
    Animation animation4 = new MoveAnimation(shape1, 70, 100, 300.0, 300.0, 200.0, 200.0);
    Animation animation5 = new ResizeWidthAnimation(shape1, 51, 70, 50.0, 25.0);
    
    AnimationModel model = new AnimationModelImpl();
    model.addShape(shape2);
    model.addShape(shape1);
    
    
    model.addAnimation(animation1);
    model.addAnimation(animation2);
    
    model.addAnimation(animation3);
    model.addAnimation(animation4);
    model.addAnimation(animation5);
    
    String expected = 
        "Create rgb(255,0,0) rectangle R with corner at (200, 200), width 50 and height 100\n" +
        "Create rgb(0,0,255) ellipse E with center at (500, 100), radius 60 and 30\n" + 
        
        
        "\nR appears at time t=1 and disappears at time t=100\n" +
        "E appears at time t=6 and disappears at time t=100\n" +
        "\nR moves from (200, 200) to (300, 300) from time t=10 to t=50\n" +
        "E moves from (500, 100) to (500, 400) from time t=20 to t=70\n" +
        "E changes from rgb(0,0,255) to rgb(0,255,0) from time t=50 to t=80\n" + 
        "R changes width from 50 to 25 from time t=51 to t=70\n"+
        "R moves from (300, 300) to (200, 200) from time t=70 to t=100\n"; 
        
        
    String actual = model.toString();
    
    assertEquals(expected, actual);
    
  }
  
  @Test
  public void testSVGStringShape() {
    
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("P", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle P with corner at "
        + "(200, 200), width 50 and height 100 -->\n"
        +"<rect id=\"P\" x=\"200\" y=\"200\" width=\"50\" "
        + "height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n</rect>\n</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    Shape shape2 = new Ellipse("E", 500.0, 100.0, 60.0, 30.0, Color.BLUE, 6, 100, 1);
    
    model.addShape(shape2);
    
    String expected2 = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle P with corner at "
        + "(200, 200), width 50 and height 100 -->\n"
        +"<rect id=\"P\" x=\"200\" y=\"200\" width=\"50\" "
        + "height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n</rect>\n" 
        + "<!--Create rgb(0,0,255) ellipse E with center at "
        + "(500, 100), radius 60 and 30 -->\n"
     +"<ellipse id=\"E\" cx=\"500\" cy=\"100\" rx=\"60\" "
     + "ry=\"30\" fill=\"rgb(0,0,255)\" visibility=\"visible\" >\n</ellipse>\n</svg>";
    
    String svgActual2 = model.toStringSVG();
    
//    System.out.println(model.toStringSVG());
    
    assertEquals(expected2, svgActual2);
       
    
  }
  
  @Test
  public void testSVGStringAddRec() {
    
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("P", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle P with corner at "
        + "(200, 200), width 50 and height 100 -->\n"
        +"<rect id=\"P\" x=\"200\" y=\"200\" width=\"50\" "
        + "height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n</rect>\n</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    Shape shape2 = new Rectangle("R", 50.0, 50.0, 50.0, 100.0, Color.BLUE, 1, 100, 1);
    
    model.addShape(shape2);
    
//    System.out.println(model.toStringSVG());
    
    
    
  
  }
    
    
    
    
  //ACTUALLY WORKING! 
  @Test
  public void testSVGStringChangeColor() {
    
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("P", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle P with corner at "
        + "(200, 200), width 50 and height 100 -->\n"
        +"<rect id=\"P\" x=\"200\" y=\"200\" width=\"50\" "
        + "height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        +"</rect>\n"
        + "</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    
    Animation newColor = new ChangeColorAnimation(shape1, 1000, 5000, Color.RED, Color.BLUE);
    model.addAnimation(newColor);
    
    String actual = model.toStringSVG();
    
    String expected2 = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle P with corner at (200, 200), width 50 and height 100 -->\n"
        + "<rect id=\"P\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "<!--P changes from rgb(255,0,0) to rgb(0,0,255) from time t=1000 to t=5000 -->\n"
        + "<animateColor attributeName=\"fill\" attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" />\n"
        + "</rect>\n"
        + "</svg>";
        
    
//    System.out.println(model.toStringSVG());
    assertEquals(expected2, actual);
    
    
    String svgActual2 = model.toStringSVG();
    
    
    
    assertEquals(expected2, svgActual2);
    
    
    
    
    
  }
  
  @Test
  public void testSVGStringChangeColorEllipse() {
    
    AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Ellipse("E", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) ellipse E with center at "
        + "(200, 200), radius 50 and 100 -->\n"
        +"<ellipse id=\"E\" cx=\"200\" cy=\"200\" rx=\"50\" ry=\"100\""
        + " fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n</ellipse>\n</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    
    Animation newColor = new ChangeColorAnimation(shape1, 1000, 5000, Color.RED, Color.BLUE);
    model.addAnimation(newColor);
    
    String actual = model.toStringSVG();
    
    String expected2 = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) ellipse E with center at "
        + "(200, 200), radius 50 and 100 -->\n"
        +"<ellipse id=\"E\" cx=\"200\" cy=\"200\" rx=\"50\" ry=\"100\""
        + " fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "<!--E changes from rgb(255,0,0) to rgb(0,0,255) from time t=1000 to t=5000 -->\n"
        + "<animateColor attributeName=\"fill\" attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" from=\"rgb(255,0,0)\" to=\"rgb(0,0,255)\" />\n"
        + "</ellipse>\n"
        + "</svg>";
        
    
//    System.out.println(model.toStringSVG());
    assertEquals(expected2, actual);
    
    
    String svgActual2 = model.toStringSVG();
    
    
    
    assertEquals(expected2, svgActual2);
      
    
    
  }
  
  //doesn't work for multiple because of closing brackets for the object
  @Test
  public void testMoveSVG() {
    
  AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Ellipse("E", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) ellipse E with center at "
        + "(200, 200), radius 50 and 100 -->\n"
        +"<ellipse id=\"E\" cx=\"200\" cy=\"200\" rx=\"50\" ry=\"100\""
        + " fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n</ellipse>\n</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    Animation move = new MoveAnimation(shape1, 200, 7000, 5.0, 100.0, 100.0, 200.0);
    
    model.addAnimation(move);
    
//    System.out.println(model.toStringSVG());
//    
    
    
  }
  
  //Change height works but the same issue with the </ellipse> error
  @Test
  public void testChangeHeightSVG() {
  AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Ellipse("E", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) ellipse E with center at "
        + "(200, 200), radius 50 and 100 -->\n"
        +"<ellipse id=\"E\" cx=\"200\" cy=\"200\" rx=\"50\" ry=\"100\""
        + " fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n</ellipse>\n</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    Animation height = new ResizeHeightAnimation(shape1, 200, 7000, 5.0, 100.0);
    
    model.addAnimation(height);
    
    
//    System.out.println(model.toStringSVG());
    
    expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) ellipse E with center at (200, 200), radius 50 and 100 -->\n"
        + "<ellipse id=\"E\" cx=\"200\" cy=\"200\" rx=\"50\" ry=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "<!--E changes height from 5 to 100 from time t=200 to t=7000 -->\n"
        + "<animate attributeType=\"xml\" begin=\"200ms\" dur=\"6800ms\" attributeName=\"ry\" from=\"5\" to=\"100\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
        + "</svg>";
 
    svgActual = model.toStringSVG();
    assertEquals(expected, svgActual);
  }
  
  @Test
  public void testChangeHeightSVGRect() {
  AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("R", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle R with corner at (200, 200), width 50 and height 100 -->\n"
        + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "</rect>" 
        + "\n</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    Animation height = new ResizeHeightAnimation(shape1, 200, 7000, 5.0, 100.0);
    
    model.addAnimation(height);
    
    
    svgActual = model.toStringSVG();
    
    expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle R with corner at (200, 200), width 50 and height 100 -->\n"
        + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        
        + "<!--R changes height from 5 to 100 from time t=200 to t=7000 -->\n"
        + "<animate attributeType=\"xml\" begin=\"200ms\" dur=\"6800ms\" attributeName=\"height\" from=\"5\" to=\"100\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "</svg>";
    
    assertEquals(expected, svgActual);
    
//    System.out.println(model.toStringSVG());
    
    
    
    
  
  }
  
  
  @Test
  public void testChangeWidthtSVG() {
  AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Ellipse("E", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) ellipse E with center at "
        + "(200, 200), radius 50 and 100 -->\n"
        +"<ellipse id=\"E\" cx=\"200\" cy=\"200\" rx=\"50\" ry=\"100\""
        + " fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n</ellipse>\n</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    Animation width = new ResizeWidthAnimation(shape1, 200, 7000, 5.0, 100.0);
    
    model.addAnimation(width);
    
    
//    System.out.println(model.toStringSVG());
    
    expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) ellipse E with center at (200, 200), radius 50 and 100 -->\n"
        + "<ellipse id=\"E\" cx=\"200\" cy=\"200\" rx=\"50\" ry=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "<!--E changes width from 5 to 100 from time t=200 to t=7000 -->\n"
        + "<animate attributeType=\"xml\" begin=\"200ms\" dur=\"6800ms\" attributeName=\"rx\" from=\"5\" to=\"100\" fill=\"freeze\" />\n"
        + "</ellipse>\n"
        + "</svg>";
 
    svgActual = model.toStringSVG();
    assertEquals(expected, svgActual);
  }
  
  @Test
  public void testChangeWidthSVGRect() {
  AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("R", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle R with corner at (200, 200), width 50 and height 100 -->\n"
        + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "</rect>" 
        + "\n</svg>";
        
    String svgActual = model.toStringSVG();
    
    assertEquals(expected, svgActual);
    
    Animation width = new ResizeWidthAnimation(shape1, 200, 7000, 5.0, 100.0);
    
    model.addAnimation(width);
    
    
    svgActual = model.toStringSVG();
    
    expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle R with corner at (200, 200), width 50 and height 100 -->\n"
        + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "<!--R changes width from 5 to 100 from time t=200 to t=7000 -->\n"
        + "<animate attributeType=\"xml\" begin=\"200ms\" dur=\"6800ms\" attributeName=\"width\" from=\"5\" to=\"100\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "</svg>";
    
    assertEquals(expected, svgActual);
    
//    System.out.println(model.toStringSVG());
    
    
  
  }
  
  
  
  

  

    
    
    
    
    
  
  

}
