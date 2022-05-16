package lecture_7.Implementation;

import lecture_7.Temperature.Converter;

public class ConvertToKelvins implements Converter {
    @Override
    public void convertTemperature(int valueInCelsius) {
        System.out.printf("Entered temperature %d in Kelvins is %d",valueInCelsius,valueInCelsius+273);
    }
}
