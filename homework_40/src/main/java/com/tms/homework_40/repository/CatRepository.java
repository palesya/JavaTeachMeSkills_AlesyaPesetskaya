package com.tms.homework_40.repository;

import com.tms.homework_40.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CatRepository extends JpaRepository<Cat, Long>, JpaSpecificationExecutor<Cat> {

}
