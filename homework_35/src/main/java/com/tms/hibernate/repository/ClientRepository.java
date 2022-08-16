package com.tms.hibernate.repository;

import com.tms.hibernate.model.Client;

public interface ClientRepository {

    Client getClientById(int id);
    void save (Client client);

}
