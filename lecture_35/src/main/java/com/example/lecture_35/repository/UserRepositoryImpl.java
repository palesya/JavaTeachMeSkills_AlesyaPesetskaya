package com.example.lecture_35.repository;

import com.example.lecture_35.dto.UserDTO;
import com.example.lecture_35.model.Address;
import com.example.lecture_35.model.Pet;
import com.example.lecture_35.model.Phone;
import com.example.lecture_35.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public User getById(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        UserDTO dto = new UserDTO();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void save(User user) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Pet> pets = user.getPets();
        pets.forEach(session::save);

        Phone phone = user.getPhone();
        session.save(phone);

        List<Address> address = user.getAddress();
        address.forEach(session::save);

        session.save(user);

        user.setPets(pets);
        user.setPhone(phone);
        user.setAddress(address);
        pets.forEach(add -> add.setUser(user));
        address.forEach(add -> add.setUser(List.of(user)));
        phone.setUser(user);
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
