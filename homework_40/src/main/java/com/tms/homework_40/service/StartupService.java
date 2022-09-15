package com.tms.homework_40.service;

import com.tms.homework_40.model.Cat;
import com.tms.homework_40.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StartupService {

    @Autowired
    private CatRepository repository;

    @PostConstruct
    public void init() {
        Cat cat1 = new Cat("Murka", "metis", 3);
        Cat cat2 = new Cat("Molly", "british", 5);
        Cat cat3 = new Cat("Lapa", "seam", 10);

        List<Cat> cats = List.of(cat1, cat2, cat3);
        for (Cat cat : cats) {
            int numberOfMatches = repository.findByName(cat.getName()).size();
            if (numberOfMatches == 0) {
                repository.save(cat);
            }
        }
    }


}
