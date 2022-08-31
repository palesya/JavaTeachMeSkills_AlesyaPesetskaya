package com.tms.homework_40.service;

import com.tms.homework_40.model.Cat;
import com.tms.homework_40.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    CatRepository repository;

    @Override
    public List<Cat> getAll() {
        return repository.getAll();
    }

    @Override
    public Cat getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public void saveCat(Cat cat) {
        repository.save(cat);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
