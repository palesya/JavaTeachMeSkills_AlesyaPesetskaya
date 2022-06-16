package lecture_20.services;

import lecture_20.entity.Car;

import java.util.List;

public interface CarService {

    void save(Car car);

    Car get(Integer id);

    List<Car> getAll();

    List<Car> getByBrand(Car.Brand brand);

    void delete(Integer id);

    void update(Car car);

}
