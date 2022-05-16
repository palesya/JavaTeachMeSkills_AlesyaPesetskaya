package lecture_7.Temperature;

import lecture_7.Implementation.ConvertToFahrenheit;
import lecture_7.Implementation.ConvertToKelvins;

import java.util.Scanner;

public class ConverterUsage {
    public static void main(String[] args) {
        Converter converter = null;
        System.out.println("Enter temperature in Celsius:");
        Scanner scanner=new Scanner(System.in);
        int temperatureInCelsius= scanner.nextInt();
        System.out.println("Enter 'KELVINS' to convert to KELVINS and 'FAHRENHEIT' to convert to FAHRENHEITS");
        String type=new Scanner(System.in).nextLine();
        switch (TemperatureType.valueOf(type)){
            case KELVINS:
                converter= new ConvertToKelvins();
                break;
            case FAHRENHEIT:
                converter= new ConvertToFahrenheit();
                break;
            default:
                break;
        }
        converter.convertTemperature(temperatureInCelsius);
    }
}
