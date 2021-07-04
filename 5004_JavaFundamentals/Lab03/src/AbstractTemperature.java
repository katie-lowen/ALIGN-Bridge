

/**
 * Abstract class for temperature.
 * @author katie lowen
 *
 */
public abstract class AbstractTemperature implements Temperature {
  
  protected double tempK;

  AbstractTemperature(double tempK) throws IllegalArgumentException {
    
    
    if (this.tempK < 0) {
      throw new IllegalArgumentException("Temperature must be above 0 Kelvin");
    }
    this.tempK = tempK;
    
  }
  
  @Override
  public double inCelsius() {
    return this.tempK + Temperature.ABS_ZERO_C;
  }
  
  @Override
  public double inFahrenheit() {
    return (this.tempK + Temperature.ABS_ZERO_C) * (9.0 / 5.0) + 32;
  }
  
  /**
   * This method compares compares two temperatures in Kelvin.
   * @returns an integer value. 0 if equal, 1 if greater than, -1 if less than. 
   */
 
  @Override
  public int compareTo(Temperature other) {
    
    double difference = this.inKelvin() - other.inKelvin();
    double tolerance = 0.005;
    
    if (difference > tolerance) {
      return 1;
    }
    
    if (difference < -tolerance) {
      return -1;
    }
    
    return 0;
  }

  /**
   * This method converts Celsius to Fahrenheit. 
   * @param tempC is a double Celsius temperature.
   * @return returns a double temperature in Fahrenheit. 
   */
  public static double celsiusToFahrenheit(double tempC) {
    return tempC * (9.0 / 5.0) + 32;
  }
  
  /**
   * This method converts Fahrenheit to Celsius.
   * @param tempF double temperature in Fahrenheit. 
   * @return double in Celsius. 
   */
  public static double fahrenheitToCelsius(double tempF) {
    return (tempF - 32.0) * (5.0 / 9.0);
  }
  
  /**
   * This method converts Celsius to Kelvin.
   * @param tempC double temperature in Celsius. 
   * @return double in Kevlin. 
   */
  public static double celsiusToKelvin(double tempC) {
    return tempC - Temperature.ABS_ZERO_C;
  }
  
  /**
   * This method converts Fahrenheit to Kelvin.
   * @param tempF double temperature in Fahrenheit. 
   * @return double in Kelvin. 
   */
  public static double fahrenheitToKelvin(double tempF) {
    return AbstractTemperature.celsiusToKelvin(AbstractTemperature.fahrenheitToCelsius(tempF));
  }
  
  /**
   * This method provides a string representation of a temperature in Fahrenheit. 
   * Returns the string representation as .1f °Fahrenheit to one decimal place. 
   */
  public String toString() {
    return String.format("%.1f °Fahrenheit", this.inFahrenheit());
  }
}


