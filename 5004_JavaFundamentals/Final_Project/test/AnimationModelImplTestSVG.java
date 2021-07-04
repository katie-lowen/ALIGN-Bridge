package cs5004.animator.model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class AnimationModelImplTestSVG {

  @Test
  public void testChangeWidthSVG() {
  AnimationModel model = new AnimationModelImpl();
    
    Shape shape1 = new Rectangle("R", 200.0, 200.0, 50.0, 100.0, Color.RED, 1, 100, 1);
    
    model.addShape(shape1);
    
    String expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle R with corner at (200, 200), width 50 and height 100 -->\n"
        + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "</rect>" //ERROR HERE
        + "\n</svg>";
        
    String svgActual = model.toStringSVG();
    
//    System.out.println(model.toStringSVG());
    
    
//    assertEquals(expected, svgActual);
    
    Animation width = new ResizeWidthAnimation(shape1, 200, 7000, 5.0, 100.0);
    
    model.addAnimation(width);
    
    
    svgActual = model.toStringSVG();
    
    expected = "<svg width=\"700\" height=\"500\" version=\"1.1\"\n"
        + "     xmlns=\"http://www.w3.org/2000/svg\"> \n"
        + "<!--Create rgb(255,0,0) rectangle R with corner at (200, 200), width 50 and height 100 -->\n"
        + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" fill=\"rgb(255,0,0)\" visibility=\"visible\" >\n"
        + "</rect>\n"
        + "<!--R changes width from 5 to 100 from time t=200 to t=7000 -->\n"
        + "<animate attributeType=\"xml\" begin=\"200ms\" dur=\"6800ms\" attributeName=\"width\" from=\"5\" to=\"100\" fill=\"freeze\" />\n"
        + "</rect>\n"
        + "</svg>";
    
   
//    System.out.println(model.toStringSVG());
//    System.out.println("\nHERE\n");
    
//    assertEquals(expected, svgActual);
    
    
    Shape shape2 = new Ellipse("E", 500.0, 100.0, 60.0, 30.0, Color.BLUE, 6, 100, 1);
    
    model.addShape(shape2);
    
    Animation width2 = new ResizeWidthAnimation(shape2, 200, 7000, 4.0, 50.0);
    
    model.addAnimation(width2);
    
//    System.out.println(model.toStringSVG());
    
    Animation newColor = new ChangeColorAnimation(shape1, 1000, 5000, Color.RED, Color.GREEN);
    
    model.addAnimation(newColor);
    
    System.out.println(model.toStringSVG());
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
  }
}
