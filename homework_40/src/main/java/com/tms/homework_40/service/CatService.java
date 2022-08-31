package com.tms.homework_40.service;

import com.tms.homework_40.model.Cat;

import java.util.List;

public interface CatService {

    List<Cat> getAll();
    Cat getById(Long id);
    void saveCat(Cat cat);
    void deleteById(Long id);
}
