package homework_20.services;

import homework_20.entity.Chocolate;
import homework_20.entity.TypeAction;
import homework_20.exception.ChocolateValidationException;

import static homework_20.entity.TypeAction.SAVE;

public class ChocolateValidatorImpl implements ChocolateValidator<Chocolate> {

    @Override
    public void validate(Chocolate chocolate, TypeAction type) throws ChocolateValidationException {

        if (chocolate.getName() == null || chocolate.getName().isEmpty()) {
            throw new ChocolateValidationException("Name should be filled.");
        }

        if (chocolate.getBrand() == null) {
            throw new ChocolateValidationException("Brand is required.");
        }

        if (chocolate.getWeight() < 0) {
            System.out.println("Weight should be greater than 0. \nWeight is generated as 50 gr.");
            chocolate.setWeight(50);
        }

        if (type == SAVE) {
            if (chocolate.getId() != null) {
                throw new ChocolateValidationException("Id should be null while saving. \nIt is generated automatically.");
            }
        } else {
            if (chocolate.getId() == null) {
                throw new ChocolateValidationException("Id can't be null while updating.");
            }
        }
    }
}
