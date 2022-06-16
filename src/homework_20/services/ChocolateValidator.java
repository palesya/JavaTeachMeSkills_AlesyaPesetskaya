package homework_20.services;

import homework_20.entity.TypeAction;
import homework_20.exception.ChocolateValidationException;

public interface ChocolateValidator<T> {

    void validate(T entity, TypeAction type) throws ChocolateValidationException;

}
