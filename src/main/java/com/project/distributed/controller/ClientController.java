package com.project.distributed.controller;

import com.project.distributed.models.Client;
import com.project.distributed.services.ClientService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "clients")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    //get
    @GetMapping
    public List<Client> findAll(){
        return clientService.findAll();
    }

    //get by id
    @GetMapping
    Client findById(@PathVariable long id){
        return clientService.findById(id);
    }

    // create client
    @PostMapping
    Client createClient(
            @Validated(Client.Create.class)
            @RequestBody Client client
    )
    {
        return clientService.createClient(client);
    }

    // update client
    @PatchMapping
    public Client updateClient(
            @Validated(Client.Update.class)
            @RequestBody Client client
    )
    {
        return clientService.update(client);
    }

}
