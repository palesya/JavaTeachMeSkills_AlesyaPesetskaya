package homework_20;

import homework_20.entity.Chocolate;
import homework_20.services.ChocolateServiceImpl;
import homework_20.services.ChocolateValidatorImpl;
import homework_20.services.InitService;
import homework_20.services.PrintServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static homework_20.entity.Chocolate.Brand.*;
import static homework_20.entity.Queries.GET_ID;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost/postgres?user=postgres&password=alesya");
        } catch (SQLException e) {
            System.out.println("Connection is null. Program will be stopped.");
            System.exit(0);
        }

        InitService initService = new InitService(connection);
        initService.init();

        List<Chocolate> chocolates = Arrays.asList(
                new Chocolate("M&Ms", MARS, 50),
                new Chocolate("KitKat", NESTLE, 41),
                new Chocolate("Nuts", NESTLE, 50),
                new Chocolate("Oreo", MILKA, 100),
                new Chocolate("Alpine", MILKA, 270));

        Chocolate chocolateForUpdate = new Chocolate(0, "Updated", MILKA, 111);

        PrintServiceImpl printService = new PrintServiceImpl();

        ChocolateServiceImpl chocolateService = new ChocolateServiceImpl(connection, new ChocolateValidatorImpl());
        for (Chocolate el : chocolates) {
            chocolateService.save(el);
        }

        System.out.println("All saved chocolates:");
        printService.getAllAndPrint(chocolateService);

        Chocolate chocolate = chocolateService.get(0);
        System.out.println("Get chocolate by id = " + chocolate.getId() + ":\n" + chocolate+"\n");

        List<Chocolate> byBrand = chocolateService.getByBrand(NESTLE);
        System.out.println("Get chocolate by brand = " + byBrand.get(0).getBrand());
        printService.print(byBrand);

        chocolateService.update(chocolateForUpdate);
        System.out.println("All saved chocolates after updated with id = " + chocolateForUpdate.getId() + ":");
        printService.getAllAndPrint(chocolateService);

        int idForDelete = 0;
        chocolateService.delete(idForDelete);
        System.out.println("All saved chocolates after removed chocolate with id = " + idForDelete + ":");
        printService.getAllAndPrint(chocolateService);


    }


}
