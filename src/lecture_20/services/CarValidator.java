package lecture_20.services;

import lecture_20.entity.TypeValid;
import lecture_20.exception.CarValidationException;

public interface CarValidator<T> {

    void validate(T entity, TypeValid type) throws CarValidationException;

}
