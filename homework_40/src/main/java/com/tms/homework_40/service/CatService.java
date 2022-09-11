package com.tms.homework_40.service;

import com.tms.homework_40.model.Cat;
import com.tms.homework_40.model.SearchRequest;

import java.util.List;

public interface CatService {

    void saveCat(Cat cat);
    void deleteById(Long id);
    List<Cat> getAllBySearch(SearchRequest request);
}
