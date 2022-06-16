package lecture_20.services;

import lecture_20.entity.Car;
import lecture_20.entity.TypeValid;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static lecture_20.entity.TypeValid.SAVE;

public class CarServiceImpl implements CarService {

    private Connection connection;
    private CarValidator validator;

    public static final String SAVE_CAR = "insert into cars (id, number,brand,age) values(?, ?, ?, ?)";
    public static final String GET_ID = "select max(id)+1 as id from cars";
    public static final String UPDATE_CAR = "update cars set number = ?, brand = ?, age = ? where id = ?";

    public CarServiceImpl(Connection connection, CarValidator validator) {
        this.connection = connection;
        this.validator = validator;
    }

    @Override
    public void save(Car car) {

        validator.validate(car, SAVE);

        String number = car.getNumber();
        String brand = car.getBrand().name();
        int age = car.getAge();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ID);
            int next_id = 0;

            if (resultSet.next()) {
                next_id = resultSet.getInt("id");
            }
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CAR);
            preparedStatement.setInt(1, next_id);
            preparedStatement.setString(2, number);
            preparedStatement.setString(3, brand);
            preparedStatement.setInt(4, age);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car get(Integer id) {
        Car car = null;
        if (id != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from cars where id = ?");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    car = createCar(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return car;
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cars");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cars.add(createCar(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public List<Car> getByBrand(Car.Brand brand) {
        List<Car> cars = new ArrayList<>();
        if (brand != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from cars where brand = ?");
                preparedStatement.setString(1, brand.name());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    cars.add(createCar(resultSet));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cars;
    }

    @Override
    public void delete(Integer id) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from cars where id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Car car) {

        validator.validate(car, TypeValid.UPDATE);

        Integer id = car.getId();
        String number = car.getNumber();
        String brand = car.getBrand().name();
        int age = car.getAge();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAR);
            preparedStatement.setInt(4, id);
            preparedStatement.setString(1, number);
            preparedStatement.setString(2, brand);
            preparedStatement.setInt(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Car createCar(ResultSet resultSet) throws SQLException {
        int dbID = resultSet.getInt("id");
        String number = resultSet.getString("number");
        String dbBrand = resultSet.getString("brand");
        int age = resultSet.getInt("age");
        return new Car(dbID, number, Car.Brand.valueOf(dbBrand), age);
    }
}
