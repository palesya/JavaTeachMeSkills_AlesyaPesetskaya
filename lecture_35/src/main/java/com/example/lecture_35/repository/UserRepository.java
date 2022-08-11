package com.example.lecture_35.repository;

import com.example.lecture_35.model.User;

public interface UserRepository {

    User getById(int id);
    void save (User user);
    void updateName(Integer id, String newName);
}
