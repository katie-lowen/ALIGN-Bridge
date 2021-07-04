import static java.lang.Math.PI;
import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

/**
 * This class represents a 3D Vector. A 3D Vector has an x,y,and z value. 
 * @author Katie Lowen
 */
public class Vector3D {
  /**
   *This class represents a 3D vector. A vector has the following attributes: x,
   *    y, z, magnitude, addition of two vectors, multiplying a vector by a constant
   *    dot product, angle between two vectors.
   */
  private double x;
  private double y;
  private double z;
  

  /**
   * Constructs a Vector 3D object and initializes it to the given z, y, z,
   *     magnitude, normalizing vector, multiplying vector, dot product, and angle.
   * 
   * @param x the x value of this vector.
   * @param y the y value of this vector.
   * @param z the z value of this vector.
   */
  public Vector3D(double x, double y, double z) {
    // Constructor to instantiate a Vector3D

    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Get the x value of this Vector.
   * 
   * @return the x value of this Vector as a double.
   */
  public double getX() {
    // method returns x value of the Vector

    return this.x;
  }

  /**
   * Get the y value of this Vector.
   * 
   * @return the y value of this Vector.
   */
  public double getY() {
    // method returns the y value of the Vector

    return this.y;
  }

  /**
   * Get the z value of this Vector.
   * 
   * @return the z value of this Vector.
   */
  public double getZ() {
    // method returns the z value of the Vector

    return this.z;
  }

  /**
   * This method formats the vector as a string. The method will present as (x,y,z) to two
   *   decimal places.
   * @return String representation of the vector.
   */
  public String toString() {
    // method returns the string information of the Vector

    return String.format("(%.2f,%.2f,%.2f)", this.x, this.y, this.z);
  }

  /**
   * This method calculates the magnitude of a Vector 3D by using the provided formula.
   *    The result of this method is represented as a double.
   * @return returns the magnitude of this Vector as a double.
   */
  public double getMagnitude() {
    // method returns the magnitude

    // first find the squared values of our x,y,z
    double xSquared = this.x * this.x;
    double ySquared = this.y * this.y;
    double zSquared = this.z * this.z;

    // next find the sum of the squared values
    double sumOfValues = xSquared + ySquared + zSquared;

    // use Math class to calculate the square root of these values

    double magnitude = sqrt(sumOfValues);

    return magnitude;
  }

  /**
   * This method normalizes the vector by dividing the x,y,z values by the vectors.
   *     This function returns a new Vector3D with the x,y,z values as
   *     the new normalized values, where x,y,z are doubles with two decimal places. 
   *     The method throws an IllegalArgumentException if the magnitude of the vector is zero,
   *     because we will have a zero division error.
   * @return new 3D Vector with the z,y,z values of the normalized vector (x,y,z).
   */
  public Vector3D normalize() throws IllegalArgumentException {
    // normalizing vector is dividing x, y, z by the magnitude
    // throws illegal argument exception if the magnitude is zero
    
    double magnitude = getMagnitude();

    if (magnitude == 0) {
      throw new IllegalArgumentException("Magnitude cannot be zero");
    }
    double xNormalized = this.x / magnitude;
    double yNormalized = this.y / magnitude;
    double zNormalized = this.z / magnitude;
  
    // return statement in (x,y,z) format

    return new Vector3D(xNormalized,yNormalized,zNormalized);
  }

  /**
   * This method adds two Vector3D objects together to return a new Vector3D
   *     with the x,y,z values of the added vectors.
   * 
   * @param otherVector is the second vector object we are adding together with
   *     the original vector
   * @return The sum of our two vectors adds the x values together, the y values
   *     together, and the z values together and returns a new Vector3D
   *     (x,y,z) where x,y,z are floats.
   */

  public Vector3D add(Vector3D otherVector) {
    // this method adds two vectors together
    // must create a second vector3d object

    double xAdd = this.x + otherVector.x;
    double yAdd = this.y + otherVector.y;
    double zAdd = this.z + otherVector.z;

    return new Vector3D(xAdd,yAdd,zAdd);
  }

  /**
   * This method calculates the vector if multiplied by a constant and returns the
   *     x,y,z values in a new Vector3D as (x,y,z).
   * @param constant is the constant the vector is multiplied by.
   * @return string representation of the multiplied values of (x,y,z) to two
   *     decimal places.
   */
  public Vector3D multiply(double constant) {
    // method returns a string representation of
    // multiplying the vector by a constant

    double xMultiply = this.x * constant;
    double yMultiply = this.y * constant;
    double zMultiply = this.z * constant;

    return new Vector3D(xMultiply, yMultiply, zMultiply);
  }
  
  /**
   * This method calculates and returns the dot product of two vectors. 
   *     For this calculation to occur, we must make a second Vector3D object.
   * @param otherVector creates a second Vector3D object.
   * @return returns the double value of the dotProduct of two vectors. 
   */
  public double dotProduct(Vector3D otherVector) {
    // requires creation of another vector object

    double xValue = this.x * otherVector.x;
    double yValue = this.y * otherVector.y;
    double zValue = this.z * otherVector.z;
    double dotProductResult = xValue + yValue + zValue;

    return dotProductResult;
  }

  /**
   * This method calculates and returns the angle between two Vector3D objects and
   *     returns a double in degrees.
   * 
   * @param secondVector We must create another vector to calculate the angles
   *     between these two vectors There is an illegalExceptionArgument
   *     thrown if either of the magnitudes for our two vectors
   *     are zero as there would be a zero division.
   * @return the double representation of the degrees between two vectors.
   */
  public double angleBetween(Vector3D secondVector) throws IllegalArgumentException {
    // requires creation of another vector object
    // first must find the dot product
    // illegal argument exceptions added to prevent zero division

    double dotProductResult = dotProduct(secondVector);

    double magnitudeVector = getMagnitude();

    if (magnitudeVector == 0) {
      throw new IllegalArgumentException("Magnitude cannot be zero!");
    }

    double magnitudeSecondVector = secondVector.getMagnitude();

    if (magnitudeSecondVector == 0) {
      throw new IllegalArgumentException("Magnitude cannot be zero!");
    }

    double cosVectors = (dotProductResult / (magnitudeVector * magnitudeSecondVector));
    double degrees = (180 * acos(cosVectors)) / PI;

    return degrees;
  }
}
