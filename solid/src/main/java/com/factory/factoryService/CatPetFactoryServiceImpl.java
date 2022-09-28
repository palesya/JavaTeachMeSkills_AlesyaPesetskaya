package com.factory.factoryService;

import com.factory.basicService.CatServiceImpl;
import com.factory.basicService.PetService;

public class CatPetFactoryServiceImpl implements PetFactoryService {
    @Override
    public PetService getPetService() {
        return new CatServiceImpl("cat", "no",10);
    }
}
