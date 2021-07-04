
/**
 * This class creates a new public object FahrenheitTemperature. 
 * @author Katie Lowen
 */
public class FahrenheitTemperature extends AbstractTemperature {
  private double temperatureFahrenheit;
  
  /**
   * This method constructs a temperature object in Fahrenheit. 
   * @param tempF takes a double in fahrenheit.
   * @throws IllegalArgumentException is thrown if the temperature is below absolute zero. 
   */
  public FahrenheitTemperature(double tempF) throws IllegalArgumentException {
    super(AbstractTemperature.fahrenheitToKelvin(tempF));
   
    
    this.temperatureFahrenheit = tempF;
    
    if (this.inCelsius() <= ABS_ZERO_C) {
      throw new IllegalArgumentException("Temperature must be above Abs Zero!");
    }
  }

  /**
   * This method converts a temperature from Celsius to Fahrenheit.
   * @param tempC a temperature object in Celsius. 
   * @param convertFromC a boolean. 
   * @throws IllegalArgumentException is thrown if convertFromC is not true. 
   */
  public FahrenheitTemperature(double tempC, boolean convertFromC) throws IllegalArgumentException {
    super(tempC - ABS_ZERO_C);
    if (!convertFromC) {
      throw new IllegalArgumentException("Second input should be true");
    }
    
    this.temperatureFahrenheit = (tempC * (9.0 / 5.0)) + 32.0;
  }
  
  @Override
  public double inCelsius() {
    double tempInCelsius = (this.temperatureFahrenheit - 32.0) * (5.0 / 9.0);
    return tempInCelsius;
  }
  
  
  
  @Override
  public double inFahrenheit() {
    
    return this.temperatureFahrenheit;
  }

  
  @Override
  public double inKelvin() {
    double tempInKelvin = ((this.inCelsius()) - ABS_ZERO_C);
    return tempInKelvin;
  }

  @Override
  public Temperature add(Temperature t) {
    return new FahrenheitTemperature(this.temperatureFahrenheit + t.inFahrenheit());
  }
  
  /**
   * This method creates a string representation of a Fahrenheit temperature. 
   */
  @Override
  public String toString() {
    String s = String.format("%.1f° Fahrenheit", this.temperatureFahrenheit);
    return s;
  }

}
