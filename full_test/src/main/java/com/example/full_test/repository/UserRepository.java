package com.example.full_test.repository;

import com.example.full_test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User getByLogin(String login);

}
