package com.tms.homework_40.service;

import com.tms.homework_40.model.Cat;
import com.tms.homework_40.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class StartupService {

    @Autowired
    private CatRepository repository;

    @PostConstruct
    public void init(){
        Cat cat1 = new Cat("Murka","metis",3);
        Cat cat2 = new Cat("Molly","british",5);
        Cat cat3 = new Cat("Lapa","seam",10);

        Cat[] cats = {cat1,cat2,cat3};
        repository.saveAll(Arrays.asList(cats));

        System.out.println("aa");
    }

}