package com.project.distributed.services;

import com.project.distributed.NotFoundException;
import com.project.distributed.models.Client;
import com.project.distributed.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(long id) {
        return clientRepository.findById(id).orElseThrow(()
        ->new NotFoundException("No client with the id: "+id));
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        // look for the object
        Client found = findById(client.getId());

        // update the found client
        found.setName(client.getName());
        found.setNationalId(client.getNationalId());
        return clientRepository.save(found);
    }

    @Override
    public String deleteClient(long id) {
        String message = "";
        // look for the object
        Client found = findById(id);

        // check if client has a movie
        if(found.getSuggestedMovies().isEmpty()){
            message = "Client "+found.getName()+" records have been erased";
            clientRepository.deleteById(id);
        }else{
            message = "Client "+found.getName()+" has " + found.getSuggestedMovies().size()+" suggested movies";
        }

        return message;
    }

}
