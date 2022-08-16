package com.tms.hibernate.service;

import com.tms.hibernate.model.Client;
import com.tms.hibernate.repository.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepositoryImpl repository;

    @Override
    public Client getClientById(int id) {
        return repository.getClientById(id);
    }

    @Override
    public void save(Client client) {
        repository.save(client);
    }
}
