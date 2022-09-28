package com.factory;

import com.factory.basicService.PetService;
import com.factory.factoryService.CommonPetFactoryServiceImpl;
import com.factory.factoryService.TYPE;

public class MainFactory {

    public static void main(String[] args) {

        CommonPetFactoryServiceImpl petFactory = new CommonPetFactoryServiceImpl(TYPE.DOG);
        PetService petService = petFactory.getPetService();

    }

}
