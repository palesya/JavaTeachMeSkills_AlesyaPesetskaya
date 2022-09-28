package com.factory.factoryService;

import com.factory.basicService.DogServiceImpl;
import com.factory.basicService.PetService;

public class DogPetFactoryServiceImpl implements PetFactoryService {
    @Override
    public PetService getPetService() {
        return new DogServiceImpl("dog", "no","black");
    }
}
