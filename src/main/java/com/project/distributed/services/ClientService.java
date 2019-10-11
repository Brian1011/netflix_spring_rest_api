package com.project.distributed.services;

import com.project.distributed.models.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findById(long id);

    Client createClient(Client client);

    Client update(Client client);
}
