package main.service;

import lombok.extern.slf4j.Slf4j;
import main.model.Client;
import main.model.Customer;
import main.repository.ClientRepository;
import main.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client getById(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

}
