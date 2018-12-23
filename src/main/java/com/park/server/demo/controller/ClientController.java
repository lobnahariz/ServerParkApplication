package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.Client;
import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.FactureDocument;
import com.park.server.demo.model.Produit;
import com.park.server.demo.modelMapper.ChartMapModel;
import com.park.server.demo.modelMapper.ClientModel;
import com.park.server.demo.modelMapper.EnteteDocumentModel;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.EnteteDocumentRepository;
import com.park.server.demo.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class ClientController {

   /* @Autowired
    private IEnteteDocumentService enteteDocumentService;*/

   @Autowired
   private ClientRepository clientRepository;
   private Mapper mapper;
   private float somme=0;

@Autowired
private FactureRepository factureRepository;
    public ClientController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<ClientModel> getClients(){

        return  this.mapper.convertAllClient();
      }

    @PostMapping
    public Client addClient(@RequestBody ClientModel client, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                throw new ValidationException();
            }
        Client clientN = this.mapper.convertToClientEntity(client);

            this.clientRepository.save(clientN);

            return clientN;

    }

    @GetMapping("/totalByClient")
    public List<ChartMapModel> getTotalVente(){

        List<Client> clients= clientRepository.findAll();
        List<FactureDocument> factureDocuments=factureRepository.findAll();
        somme=0;
        Map<String,Float> liste=new HashMap<String,Float>();

        clients.forEach(client->{
            factureDocuments.forEach( factureDocument -> {

                if(factureDocument.getPersonne().getLibelle().equals(client.getLibelle()))
                {
                    somme=somme+factureDocument.getDocumenttotalTTCReduction();
                }
            });
            System.out.println(client.getLibelle()+"  "+somme);
liste.put(client.getLibelle(),somme);
            somme=0;
        });

       return mapper.convertTochartModel(liste);
    }

    @GetMapping("/totalAPayeByClient")
    public List<ChartMapModel> getTotalApayeParClient(){

        List<Client> clients= clientRepository.findAll();
        List<FactureDocument> factureDocuments=factureRepository.findAll();
        somme=0;
        Map<String,Float> liste=new HashMap<String,Float>();

        for(int i=0;i<clients.size();i++){
            for(int j=0;j<factureDocuments.size();j++){

                if(factureDocuments.get(j).getPersonne().getLibelle().equals(clients.get(i).getLibelle()))
                {
                    float montant= factureDocuments.get(j).getDocumenttotalTTCReduction() - factureDocuments.get(j).getMontantPaye();
                    somme=somme+ montant;
                }
            };
            liste.put(clients.get(i).getLibelle(),somme);
            somme=0;
        };

        return mapper.convertTochartModel(liste);
    }
    @PutMapping
    public void updateClient(@RequestBody ClientModel client)
    {
System.out.println(client.getVille()+"**********");
        Client clientN = this.mapper.convertToClientEntity(client);

        this.clientRepository.saveAndFlush(clientN);



    }
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id)
    {
        clientRepository.deleteById(id);
    }

    @GetMapping("/getById/{id}")
    public Client getClientById(@PathVariable Long id){

        return clientRepository.findById(id).get();
    }
}
