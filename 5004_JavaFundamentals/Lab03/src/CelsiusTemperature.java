
/**
 * This class creates a new public object CelsiusTemperature. 
 * @author Katie Lowen
 */
public class CelsiusTemperature extends AbstractTemperature {
  private double temperatureCelsius;
  
  /**
   * This is the constructor for CelsiusTemperature object in Celsius degrees.
   * @param tempC is a temperature given in Celsius degrees.
   */
  public CelsiusTemperature(double tempC) {
    super(AbstractTemperature.celsiusToKelvin(tempC));
    this.temperatureCelsius = tempC;  
  }
  
  /**
   * This is a constructor for the public CelsiusTemperature class. This method takes 
   * a double temp in Fahrenheiht and a boolean value convertFromF.
   * @param tempF temperature in fahrenheit.
   * @param convertFromF boolean value.
   * @throws IllegalArgumentException is thrown if the temperature tempF is not in Fahrenheit.
   */
  public CelsiusTemperature(double tempF, boolean convertFromF) throws IllegalArgumentException {
    super((tempF - 32.0) * (5.0 / 9.0) - ABS_ZERO_C);
    
    if (!convertFromF) {
      throw new IllegalArgumentException("Second input should be true");
    }
    
    this.temperatureCelsius = (tempF - 32.0) * (5.0 / 9.0);
    
  }

  
  @Override
  public double inFahrenheit() {
    double fahrenheit = (this.temperatureCelsius * (9.0 / 5.0)) + 32;
    return fahrenheit;
  }

  @Override
  public double inKelvin() {
    double kelvin = this.temperatureCelsius - ABS_ZERO_C;
    return kelvin;
  }


  @Override
  public Temperature add(Temperature t) {
    return new CelsiusTemperature(this.temperatureCelsius + t.inCelsius());
  }
  
  /**
   * This method creates a string representation of a Celsius temperature. 
   */
  @Override
  public String toString() {
    String s = String.format("%.1f° Celsius", this.temperatureCelsius);
    return s;
  }


}
