package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.Client;
import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.Produit;
import com.park.server.demo.modelMapper.ClientModel;
import com.park.server.demo.modelMapper.EnteteDocumentModel;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.EnteteDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin
public class ClientController {

   /* @Autowired
    private IEnteteDocumentService enteteDocumentService;*/

   @Autowired
   private ClientRepository clientRepository;
   private Mapper mapper;


    public ClientController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientRepository.findAll(); }

    @PostMapping
    public Client addClient(@RequestBody ClientModel client, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                throw new ValidationException();
            }
        Client clientN = this.mapper.convertToClientEntity(client);

            this.clientRepository.save(clientN);

            return clientN;

    }

    @PutMapping
    public void updateClient(@RequestBody Client client){
        clientRepository.save(client);
    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id)
    {System.out.println(id+"************************");
        clientRepository.deleteById(id);
    }

}
