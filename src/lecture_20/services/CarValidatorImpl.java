package lecture_20.services;

import lecture_20.entity.Car;
import lecture_20.entity.TypeValid;
import lecture_20.exception.CarValidationException;

import static lecture_20.entity.TypeValid.SAVE;

public class CarValidatorImpl implements CarValidator<Car> {

    @Override
    public void validate(Car car, TypeValid type) throws CarValidationException {

        if (car.getNumber() == null || car.getNumber().isEmpty()) {
            throw new CarValidationException("Number should be filled.");
        }

        if (car.getBrand() == null) {
            throw new CarValidationException("Brand is required.");
        }

        if (car.getAge() < 0) {
            car.setAge(0);
        }

        if (type == SAVE) {
            if (car.getId() != null) {
                throw new CarValidationException("Id should be null.");
            }
        } else {
            if (car.getId() == null) {
                throw new CarValidationException("Id can't be null for update.");
            }
        }
    }
}
