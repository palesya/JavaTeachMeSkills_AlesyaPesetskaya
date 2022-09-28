package com.tms.repository;

import com.tms.model.User;

public interface UserRepository {

    void save(User user);
    void delete(User user);
    User get(Long id);



}
