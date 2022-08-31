package com.tms.hibernate.service;

import com.tms.hibernate.model.Client;

public interface ClientService {

    Client getClientById(int id);
    void save (Client client);

}
