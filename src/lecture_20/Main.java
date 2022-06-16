package lecture_20;

import lecture_20.entity.Car;
import lecture_20.services.CarService;
import lecture_20.services.CarServiceImpl;
import lecture_20.services.CarValidatorImpl;
import lecture_20.services.InitService;

import java.sql.*;
import java.util.List;

import static lecture_20.entity.Car.Brand.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost/postgres?user=postgres&password=alesya");

        if(connection==null){
            System.out.println("Connection is null. Program will be stopped.");
            System.exit(0);
        }

        InitService initService = new InitService(connection);
        initService.init();

        Car car = new Car("000001se", VOLVO, 5);
        Car car2 = new Car("000002by", RENAULT, 6);
        Car car4 = new Car("010101by", VOLVO, 10);

        Car car3 = new Car(0,"22222by", AUDI, 1);

        CarService carService = new CarServiceImpl(connection, new CarValidatorImpl());
        carService.save(car);
        carService.save(car2);
        carService.save(car4);

        Car car1 = carService.get(0);
        System.out.println(car1);

        List<Car> all = carService.getAll();
        System.out.println(all);


        List<Car> byBrand = carService.getByBrand(RENAULT);
        System.out.println(byBrand);

        carService.delete(1);
        List<Car> all1 = carService.getAll();
        System.out.println(all1);

        carService.update(car3);
        List<Car> all2 = carService.getAll();
        System.out.println(all2);

        connection.close();

    }
}
