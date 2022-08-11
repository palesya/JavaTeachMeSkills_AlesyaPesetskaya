package com.example.lecture_35.repository;

import com.example.lecture_35.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public User getById(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        return user;
    }

    @Override
    public void save(User user) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateName(Integer id, String newName) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        User userFromDB = session.get(User.class, id);
        userFromDB.setLogin(newName);
        session.update(userFromDB);
        transaction.commit();
        session.close();
    }
}
