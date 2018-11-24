package com.park.server.demo.mapper;

import com.park.server.demo.model.*;
import com.park.server.demo.modelMapper.*;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.EnteteDocumentRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Mapper {

    EnteteDocumentRepository enteteDocumentRepository;
ClientRepository clientRepository;
    public Mapper(EnteteDocumentRepository enteteDocumentRepository,ClientRepository clientRepository) {
        this.enteteDocumentRepository = enteteDocumentRepository;
        this.clientRepository=clientRepository;
    }


    public DevisDocument convertToDevisDocumentEntity(DevisDocumentModel viewModel) {
        // Client client= clientRepository.findById(viewModel.getClientId()).get();
        DevisDocument entity = new DevisDocument(viewModel.getId(),viewModel.getRef(),viewModel.getDateCreation(),viewModel.getLieuCreation(),viewModel.getDelaiLivraisonSouhaite());

        return entity;
    }

    public BonLivraisonDocument convertToBonDeLivraisonDocumentEntity(BonDeLivraisonDocumentModel viewModel) {
        BonLivraisonDocument entity = new BonLivraisonDocument(viewModel.getId(),viewModel.getRef(),viewModel.getDateCreation(),viewModel.getLieuCreation(),viewModel.getAccuse_reception(),viewModel.getReceptionDate(),viewModel.getReceptionPersonne());

        return entity;
    }


    public Client convertToClientEntity(ClientModel viewModel) {
        Client entity = new Client(viewModel.getId(),viewModel.getLibelle(),viewModel.getNom(),viewModel.getPrenom(),viewModel.getNomSociete(),viewModel.getMail(),viewModel.getTelephoneFixe(),viewModel.getTelephonePortable(),viewModel.getRib(),viewModel.getAdresse());

        return entity;
    }


    public LineDocument convertToLineDocumentEntity(LineDocumentModel viewModel,Long idEntete) {
        EnteteDocument enteteDocument = enteteDocumentRepository.findById(idEntete).get();
        LineDocument entity = new LineDocument(viewModel.getId_line(), viewModel.getCode(),viewModel.getQte(),viewModel.getPuHT(),viewModel.getTva(),viewModel.getTotalHT(),viewModel.getTotalTTC(),enteteDocument);

        return entity;
    }
}
