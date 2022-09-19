package com.tms.homework_45.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tms.homework_45.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User getByName(String name);

}
