package homework_8.Cars;

import homework_8.Cars.details.Engine;
import homework_8.Cars.professions.Driver;
import homework_8.Cars.vehicles.Car;
import homework_8.Cars.vehicles.Lorry;
import homework_8.Cars.vehicles.SportCar;

public class MainCar {
    public static void main(String[] args) {
        Engine engine=new Engine(200,"BMW");
        Driver driver=new Driver("Ivan Ivanov",12);
        Car car = new Car("Mercedes","C",1500,driver,engine);
        Lorry lorry=new Lorry("MAZ","A",4000,driver,engine,8000);
        SportCar sportCar =new SportCar("Lamborghini","E",1200,driver,engine,300);
        System.out.println(car);
        System.out.println(lorry);
        System.out.println(sportCar);
    }
}
