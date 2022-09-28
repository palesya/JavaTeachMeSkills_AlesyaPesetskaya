package com.factory;

import com.factory.basicService.PetService;
import com.factory.factoryService.PetFactoryService;

public class CommonService {

    public void process(PetFactoryService factoryService){
        PetService petService = factoryService.getPetService();
    }

}
