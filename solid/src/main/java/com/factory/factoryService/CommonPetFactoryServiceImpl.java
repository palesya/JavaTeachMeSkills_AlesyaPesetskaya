package com.factory.factoryService;

import com.factory.basicService.CatServiceImpl;
import com.factory.basicService.DogServiceImpl;
import com.factory.basicService.PetService;

public class CommonPetFactoryServiceImpl implements PetFactoryService {

    TYPE type;

    public CommonPetFactoryServiceImpl(TYPE type) {
        this.type = type;
    }

    @Override
    public PetService getPetService() {
        if (type == TYPE.DOG) {
            return new DogServiceImpl("dog", "no", "black");
        } else
            return new CatServiceImpl("cat", "no", 10);
    }
}
