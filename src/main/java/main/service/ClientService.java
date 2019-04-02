package main.service;

import main.model.Client;

public interface ClientService {
    Client getById(Long id);

    void save(Client customer);

}
