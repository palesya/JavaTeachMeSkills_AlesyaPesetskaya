package lecture_7.Implementation;

import lecture_7.Temperature.Converter;

public class ConvertToFahrenheit implements Converter {
    @Override
    public void convertTemperature(int valueInCelsius) {
        System.out.printf("Entered temperature %d in Fahrenheit is %d",valueInCelsius,valueInCelsius*9/5+32);
    }
}
