package com.park.server.demo.mapper;

import com.park.server.demo.model.*;
import com.park.server.demo.modelMapper.*;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.EnteteDocumentRepository;
import com.park.server.demo.repository.FactureRepository;
import com.park.server.demo.repository.FournisseurRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

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
            if( viewModel.getAchat().equals("Achat")){
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
                     round(viewModel.getDocumenttotalHT(),3),
                     round(viewModel.getDocumenttotalTVA(),3),
                     round(viewModel.getDocumenttotalReduction(),3),
                     round(viewModel.getDocumenttotalTTC(),3),
                     round(viewModel.getDocumenttotalTTCReduction(),3),
                     viewModel.getDelaiLivraisonSouhaite(),
                     viewModel.getCreatedBy(),
                     viewModel.getModifiedBy(),
                     viewModel.getDateCreationAudit()
             );

        }else{
            entity = new DevisDocument(viewModel.getId(),
                    viewModel.getRef(),
                    viewModel.getDateCreation(),
                    viewModel.getLieuCreation(),
                    viewModel.getAchat(),
                    null,
                    round(viewModel.getDocumenttotalHT(),3),
                    round(viewModel.getDocumenttotalTVA(),3),
                    round(viewModel.getDocumenttotalReduction(),3),
                    round(viewModel.getDocumenttotalTTC(),3),
                    round(viewModel.getDocumenttotalTTCReduction(),3),
                    viewModel.getDelaiLivraisonSouhaite(),
                    viewModel.getCreatedBy(),
                    viewModel.getModifiedBy(),
                    viewModel.getDateCreationAudit()
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
                x.getDocumenttotalTTCReduction(),
                        x.getCreatedBy(),
                        x.getModifiedBy(),
                        x.getDateCreationAudit()
                        );
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
                bonLivraisonDocument.getDocumenttotalTTCReduction(),
                bonLivraisonDocument.getCreatedBy(),
                bonLivraisonDocument.getModifiedBy(),
                bonLivraisonDocument.getDateCreationAudit()
                );

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
                    devisDocument.getDocumenttotalTTCReduction(),
                    devisDocument.getCreatedBy(),
                    devisDocument.getModifiedBy(),
                    devisDocument.getDateCreationAudit());


   return model;
    }
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public BonLivraisonDocument convertToBonDeLivraisonDocumentEntity(BonDeLivraisonDocumentModel viewModel) {

        Personne personne;
        BonLivraisonDocument entity;
        if(viewModel.getAchat()!= null){
            if( viewModel.getAchat().equals("Achat")){
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
                 round(viewModel.getDocumenttotalHT(),3),
                 round(viewModel.getDocumenttotalTVA(),3),
                 round(viewModel.getDocumenttotalReduction(),3),
                 round(viewModel.getDocumenttotalTTC(),3),
                 round(viewModel.getDocumenttotalTTCReduction(),3),
                 viewModel.getAccuse_reception(),
                 viewModel.getReceptionDate(),
                 viewModel.getReceptionPersonne(),
                 viewModel.getCreatedBy(),
                 viewModel.getModifiedBy(),
                 viewModel.getDateCreationAudit()
                 );


        }else{
            entity = new BonLivraisonDocument(viewModel.getId(),
                    viewModel.getRef(),
                    viewModel.getDateCreation(),
                    viewModel.getLieuCreation(),
                    viewModel.getAchat(),
                    null,
                    round(viewModel.getDocumenttotalHT(),3),
                    round(viewModel.getDocumenttotalTVA(),3),
                    round(viewModel.getDocumenttotalReduction(),3),
                    round(viewModel.getDocumenttotalTTC(),3),
                    round(viewModel.getDocumenttotalTTCReduction(),3),
                    viewModel.getAccuse_reception(),
                    viewModel.getReceptionDate(),
                    viewModel.getReceptionPersonne(),
                    viewModel.getCreatedBy(),
                    viewModel.getModifiedBy(),
                    viewModel.getDateCreationAudit()

            );
        }

        return entity;
    }


    public Client convertToClientEntity(ClientModel viewModel) {
       // DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Client entity = new Client(viewModel.getId(),viewModel.getLibelle(),viewModel.getNom(),viewModel.getPrenom(),viewModel.getNomSociete(),viewModel.getMail(),viewModel.getTelephoneFixe(),viewModel.getTelephonePortable(),viewModel.getRib(),viewModel.getAdresse(),viewModel.getCreatedBy(),viewModel.getModifiedBy(),viewModel.getDateCreation(),viewModel.getVille());

        return entity;
    }
public List<ChartMapModel> convertTochartModel(Map<String,Float> liste){
        List<ChartMapModel> listeModel=new ArrayList<>();
        liste.forEach((x,y)->{
            ChartMapModel chartMapModel=new ChartMapModel();
            chartMapModel.setNom(x);
            chartMapModel.setNombre(y);
            listeModel.add(chartMapModel);
        });
        return listeModel;
}

   /* public Avoir convertToAvoirEntity(AvoirModel viewModel) {

        Personne personne;
        Avoir entity;
        if(viewModel.getAchat()!= null){
            if( viewModel.getAchat()){
                personne= fournisseurRepository.findById(viewModel.getPersonId()).get();
            }else{
                personne= clientRepository.findById(viewModel.getPersonId()).get();
            }
            entity = new Avoir( viewModel.getId(),
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
            entity = new Avoir( viewModel.getId(),
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
*/

    public LineDocument convertToLineDocumentEntity(LineDocumentModel viewModel,Long idEntete) {
        EnteteDocument enteteDocument = enteteDocumentRepository.findById(idEntete).get();
        LineDocument entity = new LineDocument(viewModel.getId_line(),
                viewModel.getCode(),
                viewModel.getQte(),
                viewModel.getPuHT(),
                viewModel.getTva(),
                viewModel.getTotalHT(),
                viewModel.getTotalTTC(),
                enteteDocument,
                viewModel.getReduction(),
                viewModel.getCreatedBy(),
                viewModel.getModifiedBy(),
                viewModel.getDateCreationAudit()
        );

        return entity;
    }


    ////////////////////Facture
    public List<FactureDocumentModel> convertToFactureDocumentModel(List<FactureDocument> factureDocuments){
      this.listeFacture =new ArrayList<>();
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
                    x.getDocumenttotalTTCReduction(),
                    x.getCreatedBy(),
                    x.getModifiedBy(),
                    x.getDateCreationAudit(),
                    x.getModifierStock()
            );

            this.listeFacture.add(model);
        });

        return listeFacture;
    }

    public FactureDocumentModel convertToFactureDocumentByIdModel(FactureDocument factureDocuments){

            FactureDocumentModel model = new FactureDocumentModel(factureDocuments.getId(),
                    factureDocuments.getRef(),
                    factureDocuments.getDateCreation(),
                    factureDocuments.getLieuCreation(),
                    factureDocuments.getLinesDocument().size(),
                    factureDocuments.getPersonne().getId(),
                    factureDocuments.getEtat(),
                    factureDocuments.getMontantPaye(),
                    factureDocuments.getModeReglement(),
                    factureDocuments.getDateLimiteReglement(),
                    factureDocuments.getDetails(),
                    factureDocuments.getAchat(),
                    factureDocuments.getDocumenttotalHT(),
                    factureDocuments.getDocumenttotalTVA(),
                    factureDocuments.getDocumenttotalReduction(),
                    factureDocuments.getDocumenttotalTTC(),
                    factureDocuments.getDocumenttotalTTCReduction(),
                    factureDocuments.getCreatedBy(),
                    factureDocuments.getModifiedBy(),
                    factureDocuments.getDateCreationAudit(),
                    factureDocuments.getModifierStock()
            );


        return model;
    }


    public FactureDocument convertToFactureDocumentEntity(FactureDocumentModel viewModel) {

        Personne personne;
        FactureDocument entity;
        if(viewModel.getAchat()!= null){
            if( viewModel.getAchat().equals("Achat")){
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
                    round(viewModel.getDocumenttotalHT(),3),
                    round(viewModel.getDocumenttotalTVA(),3),
                    round(viewModel.getDocumenttotalReduction(),3),
                    round(viewModel.getDocumenttotalTTC(),3),
                    round(viewModel.getDocumenttotalTTCReduction(),3),
                    viewModel.getEtat(),
                    viewModel.getMontantPaye(),
                    viewModel.getModeReglement(),
                    viewModel.getDateLimiteReglement(),
                    viewModel.getDetails(),
                    viewModel.getCreatedBy(),
                    viewModel.getModifiedBy(),
                    viewModel.getDateCreationAudit(),
                    viewModel.getModifierStock()
            );
        }else{
            entity = new FactureDocument( viewModel.getId(),
                    viewModel.getRef(),
                    viewModel.getDateCreation(),
                    viewModel.getLieuCreation(),
                    viewModel.getAchat(),
                    null,
                    round(viewModel.getDocumenttotalHT(),3),
                    round(viewModel.getDocumenttotalTVA(),3),
                    round(viewModel.getDocumenttotalReduction(),3),
                    round(viewModel.getDocumenttotalTTC(),3),
                    round(viewModel.getDocumenttotalTTCReduction(),3),
                    viewModel.getEtat(),
                    viewModel.getMontantPaye(),
                    viewModel.getModeReglement(),
                    viewModel.getDateLimiteReglement(),
                    viewModel.getDetails(),
                    viewModel.getCreatedBy(),
                    viewModel.getModifiedBy(),
                    viewModel.getDateCreationAudit(),
                    viewModel.getModifierStock()

            );

        }

        return entity;
    }

}
