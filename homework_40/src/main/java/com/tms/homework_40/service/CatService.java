package com.tms.homework_40.service;

import com.tms.homework_40.model.Cat;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CatService {

    List<Cat> getAll();
    Cat getById(Long id);
    void saveCat(Cat cat);
    void deleteById(Long id);
    List<Cat> getAllBySearch(Specification<Cat> specification);
}
