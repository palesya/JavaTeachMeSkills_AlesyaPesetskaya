package com.tms.homework_40.repository;

import com.tms.homework_40.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {

    Cat getById(Long id);

    @Query("select c from Cat c")
    List<Cat> getAll();

}
