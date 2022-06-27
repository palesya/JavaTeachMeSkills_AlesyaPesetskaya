package homework_20.services;

import homework_20.entity.TypeAction;
import homework_20.exception.ChocolateValidationException;

public interface ChocolateValidator<Chocolate> {

    void validate(Chocolate chocolate, TypeAction type) throws ChocolateValidationException;

}
