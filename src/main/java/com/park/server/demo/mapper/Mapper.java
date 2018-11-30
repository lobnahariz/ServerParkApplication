package com.park.server.demo.mapper;

import com.park.server.demo.model.*;
import com.park.server.demo.modelMapper.*;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.EnteteDocumentRepository;
import com.park.server.demo.repository.FactureRepository;
import com.park.server.demo.repository.FournisseurRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    EnteteDocumentRepository enteteDocumentRepository;
ClientRepository clientRepository;
FournisseurRepository fournisseurRepository;
FactureRepository factureRepository;
    public Mapper(FactureRepository factureRepository,EnteteDocumentRepository enteteDocumentRepository,ClientRepository clientRepository,FournisseurRepository fournisseurRepository) {
        this.enteteDocumentRepository = enteteDocumentRepository;
        this.clientRepository=clientRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.fournisseurRepository =fournisseurRepository;
    }
    List<BonDeLivraisonDocumentModel> liste=new ArrayList<BonDeLivraisonDocumentModel>();
    List<FactureDocumentModel> listeFacture=new ArrayList<FactureDocumentModel>();


    public DevisDocument convertToDevisDocumentEntity(DevisDocumentModel viewModel) {
        // Client client= clientRepository.findById(viewModel.getClientId()).get();
        Personne personne;
        DevisDocument entity;
        if(viewModel.getAchat()!= null){
            if( viewModel.getAchat()){
                personne= fournisseurRepository.findById(viewModel.getPersonId()).get();
            }else{
                personne= clientRepository.findById(viewModel.getPersonId()).get();
            }
             entity = new DevisDocument(viewModel.getId(),
                     viewModel.getRef(),
                     viewModel.getDateCreation(),
                     viewModel.getLieuCreation(),
                     viewModel.getAchat(),
                     personne,
                     viewModel.getDocumenttotalHT(),
                     viewModel.getDocumenttotalTVA(),
                     viewModel.getDocumenttotalReduction(),
                     viewModel.getDocumenttotalTTC(),
                     viewModel.getDocumenttotalTTCReduction(),
                     viewModel.getDelaiLivraisonSouhaite()
             );

        }else{
            entity = new DevisDocument(viewModel.getId(),
                    viewModel.getRef(),
                    viewModel.getDateCreation(),
                    viewModel.getLieuCreation(),
                    viewModel.getAchat(),
                    null,
                    viewModel.getDocumenttotalHT(),
                    viewModel.getDocumenttotalTVA(),
                    viewModel.getDocumenttotalReduction(),
                    viewModel.getDocumenttotalTTC(),
                    viewModel.getDocumenttotalTTCReduction(),
                    viewModel.getDelaiLivraisonSouhaite()
            );
        }

        return entity;
    }


    public List<BonDeLivraisonDocumentModel> convertToBonDeLivraisonDocumentModel(List<BonLivraisonDocument> bonLivraisonDocument){
        bonLivraisonDocument.forEach( x ->{
                BonDeLivraisonDocumentModel model = new BonDeLivraisonDocumentModel(x.getId(),
                x.getRef(),
                x.getDateCreation(),
                x.getLieuCreation(),
                x.getLinesDocument().size(),
                x.getAchat(),
                x.getPersonne().getId(),
                x.getAccuse_reception(),
                x.getReceptionDate(),
                x.getReceptionPersonne(),
                x.getDocumenttotalHT(),
                x.getDocumenttotalTVA(),
                x.getDocumenttotalReduction(),
                x.getDocumenttotalTTC(),
                x.getDocumenttotalTTCReduction());
                this.liste.add(model);
        });

        return liste;
    }
    public BonDeLivraisonDocumentModel convertToBonLivraisonDocumentModel(BonLivraisonDocument bonLivraisonDocument){


        BonDeLivraisonDocumentModel model = new BonDeLivraisonDocumentModel(bonLivraisonDocument.getId(),
        bonLivraisonDocument.getRef(),
                bonLivraisonDocument.getDateCreation(),
                bonLivraisonDocument.getLieuCreation(),
                bonLivraisonDocument.getLinesDocument().size(),
                bonLivraisonDocument.getAchat(),
                bonLivraisonDocument.getPersonne().getId(),
                bonLivraisonDocument.getAccuse_reception(),
                bonLivraisonDocument.getReceptionDate(),
                bonLivraisonDocument.getReceptionPersonne(),
                bonLivraisonDocument.getDocumenttotalHT(),
                bonLivraisonDocument.getDocumenttotalTVA(),
                bonLivraisonDocument.getDocumenttotalReduction(),
                bonLivraisonDocument.getDocumenttotalTTC(),
                bonLivraisonDocument.getDocumenttotalTTCReduction());

        return model;
    }

    public DevisDocumentModel convertToDevisDocumentModel(DevisDocument devisDocument){


            DevisDocumentModel model = new DevisDocumentModel(devisDocument.getId(),
                    devisDocument.getRef(),
                    devisDocument.getDateCreation(),
                    devisDocument.getLieuCreation(),
                    devisDocument.getLinesDocument().size(),
                    devisDocument.getPersonne().getId(),
                    devisDocument.getDelaiLivraisonSouhaite(),
                    devisDocument.getAchat(),
                    devisDocument.getDocumenttotalHT(),
                    devisDocument.getDocumenttotalTVA(),
                    devisDocument.getDocumenttotalReduction(),
                    devisDocument.getDocumenttotalTTC(),
                    devisDocument.getDocumenttotalTTCReduction());


   return model;
    }


    public BonLivraisonDocument convertToBonDeLivraisonDocumentEntity(BonDeLivraisonDocumentModel viewModel) {

        Personne personne;
        BonLivraisonDocument entity;
        if(viewModel.getAchat()!= null){
            if( viewModel.getAchat()){
                personne= fournisseurRepository.findById(viewModel.getPersonId()).get();
            }else{
                personne= clientRepository.findById(viewModel.getPersonId()).get();
            }
         entity = new BonLivraisonDocument(viewModel.getId(),
                 viewModel.getRef(),
                 viewModel.getDateCreation(),
                 viewModel.getLieuCreation(),
                 viewModel.getAchat(),
                 personne,
                 viewModel.getDocumenttotalHT(),
                 viewModel.getDocumenttotalTVA(),
                 viewModel.getDocumenttotalReduction(),
                 viewModel.getDocumenttotalTTC(),
                 viewModel.getDocumenttotalTTCReduction(),
                 viewModel.getAccuse_reception(),
                 viewModel.getReceptionDate(),
                 viewModel.getReceptionPersonne()
                 );


        }else{
            entity = new BonLivraisonDocument(viewModel.getId(),
                    viewModel.getRef(),
                    viewModel.getDateCreation(),
                    viewModel.getLieuCreation(),
                    viewModel.getAchat(),
                    null,
                    viewModel.getDocumenttotalHT(),
                    viewModel.getDocumenttotalTVA(),
                    viewModel.getDocumenttotalReduction(),
                    viewModel.getDocumenttotalTTC(),
                    viewModel.getDocumenttotalTTCReduction(),
                    viewModel.getAccuse_reception(),
                    viewModel.getReceptionDate(),
                    viewModel.getReceptionPersonne()
            );
        }

        return entity;
    }


    public Client convertToClientEntity(ClientModel viewModel) {
        Client entity = new Client(viewModel.getId(),viewModel.getLibelle(),viewModel.getNom(),viewModel.getPrenom(),viewModel.getNomSociete(),viewModel.getMail(),viewModel.getTelephoneFixe(),viewModel.getTelephonePortable(),viewModel.getRib(),viewModel.getAdresse());

        return entity;
    }

    public Avoir convertToAvoirEntity(AvoirModel viewModel) {

        FactureDocument factureDocument = factureRepository.findById(viewModel.getId_avoir()).get();

        Avoir entity = new Avoir(viewModel.getId_avoir(),viewModel.getQuantite(),viewModel.getDescription(),factureDocument);
        return entity;
    }

    public LineDocument convertToLineDocumentEntity(LineDocumentModel viewModel,Long idEntete) {
        EnteteDocument enteteDocument = enteteDocumentRepository.findById(idEntete).get();
        LineDocument entity = new LineDocument(viewModel.getId_line(), viewModel.getCode(),viewModel.getQte(),viewModel.getPuHT(),viewModel.getTva(),viewModel.getTotalHT(),viewModel.getTotalTTC(),enteteDocument,viewModel.getReduction());

        return entity;
    }


    ////////////////////Facture
    public List<FactureDocumentModel> convertToFactureDocumentModel(List<FactureDocument> factureDocuments){
        factureDocuments.forEach( x ->{
            FactureDocumentModel model = new FactureDocumentModel(x.getId(),
                    x.getRef(),
                    x.getDateCreation(),
                    x.getLieuCreation(),
                    x.getLinesDocument().size(),
                    x.getPersonne().getId(),
                    x.getEtat(),
                    x.getMontantPaye(),
                    x.getModeReglement(),
                    x.getDateLimiteReglement(),
                    x.getDetails(),
                    x.getAchat(),
                    x.getDocumenttotalHT(),
                    x.getDocumenttotalTVA(),
                    x.getDocumenttotalReduction(),
                    x.getDocumenttotalTTC(),
                    x.getDocumenttotalTTCReduction());

            this.listeFacture.add(model);
        });

        return listeFacture;
    }




    public FactureDocument convertToFactureDocumentEntity(FactureDocumentModel viewModel) {

        Personne personne;
        FactureDocument entity;
        if(viewModel.getAchat()!= null){
            if( viewModel.getAchat()){
                personne= fournisseurRepository.findById(viewModel.getPersonId()).get();
            }else{
                personne= clientRepository.findById(viewModel.getPersonId()).get();
            }
            entity = new FactureDocument( viewModel.getId(),
                    viewModel.getRef(),
                    viewModel.getDateCreation(),
                    viewModel.getLieuCreation(),
                    viewModel.getAchat(),
                    personne,
viewModel.getDocumenttotalHT(),
                    viewModel.getDocumenttotalTVA(),
                    viewModel.getDocumenttotalReduction(),
                    viewModel.getDocumenttotalTTC(),
                    viewModel.getDocumenttotalTTCReduction(),
                    viewModel.getEtat(),
                    viewModel.getMontantPaye(),
                    viewModel.getModeReglement(),
                    viewModel.getDateLimiteReglement(),
                    viewModel.getDetails()
                    );
        }else{
            entity = new FactureDocument( viewModel.getId(),
                    viewModel.getRef(),
                    viewModel.getDateCreation(),
                    viewModel.getLieuCreation(),
                    viewModel.getAchat(),
                    null,
                    viewModel.getDocumenttotalHT(),
                    viewModel.getDocumenttotalTVA(),
                    viewModel.getDocumenttotalReduction(),
                    viewModel.getDocumenttotalTTC(),
                    viewModel.getDocumenttotalTTCReduction(),
                    viewModel.getEtat(),
                    viewModel.getMontantPaye(),
                    viewModel.getModeReglement(),
                    viewModel.getDateLimiteReglement(),
                    viewModel.getDetails()
            );

        }

        return entity;
    }

}
