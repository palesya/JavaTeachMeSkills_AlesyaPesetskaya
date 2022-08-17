package com.tms.hibernate.repository;

import com.tms.hibernate.model.Car;
import com.tms.hibernate.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public Client getClientById(int id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Client clientFromDB = session.get(Client.class, id);
        System.out.println(clientFromDB.getCars());
        transaction.commit();
        session.close();
        return clientFromDB;
    }

    @Override
    public void save(Client client) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Car> cars=client.getCars();
        session.save(client);
        client.setCars(cars);
        cars.forEach(add->add.setClient(client));
        cars.forEach(session::saveOrUpdate);
        transaction.commit();
        session.close();
    }
}
