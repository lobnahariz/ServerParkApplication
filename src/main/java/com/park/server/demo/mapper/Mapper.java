package com.park.server.demo.mapper;

import com.park.server.demo.model.*;
import com.park.server.demo.modelMapper.*;
import com.park.server.demo.repository.*;
import org.springframework.stereotype.Component;

import javax.swing.text.Utilities;
import java.math.BigDecimal;
import java.util.*;

@Component
public class Mapper {
ProduitRepository produitRepository;
    EnteteDocumentRepository enteteDocumentRepository;
ClientRepository clientRepository;
FournisseurRepository fournisseurRepository;
CategorieClientRepository categorieClientRepository;
    CategorieFournisseurRepository categorieFournisseurRepository;
CategorieProduitRepository categorieProduitRepository;
FactureRepository factureRepository;
ReclamationRepository reclamationRepository;
UserRepository userRepository;
    public Mapper(UserRepository userRepository,ReclamationRepository reclamationRepository, ProduitRepository produitRepository,CategorieProduitRepository categorieProduitRepository,CategorieFournisseurRepository categorieFournisseurRepository,CategorieClientRepository categorieClientRepository,  FactureRepository factureRepository,EnteteDocumentRepository enteteDocumentRepository,ClientRepository clientRepository,FournisseurRepository fournisseurRepository) {
        this.enteteDocumentRepository = enteteDocumentRepository;
        this.clientRepository=clientRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.fournisseurRepository =fournisseurRepository;
        this.categorieClientRepository=categorieClientRepository;
        this.categorieFournisseurRepository=categorieFournisseurRepository;
        this.categorieProduitRepository=categorieProduitRepository;
        this.userRepository=userRepository;
        this.produitRepository=produitRepository;
        this.reclamationRepository =reclamationRepository;
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
    public ReparationDocument convertToReparationDocumentEntity(ReparationModel viewModel) {
        // Client client= clientRepository.findById(viewModel.getClientId()).get();
        Personne personne;
        ReparationDocument entity;
        personne= clientRepository.findById(viewModel.getPersonId()).get();
        entity = new ReparationDocument(viewModel.getId(),
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
                viewModel.getCreatedBy(),
                viewModel.getModifiedBy(),
                viewModel.getDateCreationAudit(),
                viewModel.getDelaiRreparationSouhaite(),
                viewModel.getEstAccessoire(),
                viewModel.getTypePanne(),
                viewModel.getNbHeureTravaille(),
                viewModel.getEtat(),
                viewModel.getAccessoire(),
                viewModel.getDescription()
        );


        return entity;
    }

    public ReparationModel convertToReparationDocumentModel(ReparationDocument reparationDocument){

        ReparationModel model = new ReparationModel(reparationDocument.getId(),
                reparationDocument.getRef(),
                reparationDocument.getDateCreation(),
                reparationDocument.getLieuCreation(),
                reparationDocument.getLinesDocument().size(),
                reparationDocument.getPersonne().getId(),
                reparationDocument.getAchat(),
                reparationDocument.getDescription(),
                reparationDocument.getDocumenttotalHT(),
                reparationDocument.getDocumenttotalTVA(),
                reparationDocument.getDocumenttotalReduction(),
                reparationDocument.getDocumenttotalTTC(),
                reparationDocument.getDocumenttotalTTCReduction(),
                reparationDocument.getCreatedBy(),
                reparationDocument.getModifiedBy(),
                reparationDocument.getDateCreationAudit(),
                reparationDocument.getDelaiRreparationSouhaite(),
                reparationDocument.getEtat(),
                reparationDocument.getTypePanne(),
                reparationDocument.getNbHeureTravaille(),
                reparationDocument.getEstAccessoire(),
                reparationDocument.getAccessoire()
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


    public List<FournisseurModel> convertAllFournisseur(){

        List<Fournisseur> fournisseurs=fournisseurRepository.findAll();

        List<FournisseurModel> fournisseurModels=new ArrayList<>();

        fournisseurs.forEach( client -> {

            FournisseurModel clientModel=new FournisseurModel();

            clientModel.setId(client.getId());
            clientModel.setLibelle(client.getLibelle());
            clientModel.setNom(client.getNom());
            clientModel.setVille(client.getVille());
            clientModel.setAdresse(client.getAdresse());
            clientModel.setPrenom(client.getPrenom());
            clientModel.setNomSociete(client.getNomSociete());
            clientModel.setMail(client.getMail());
            clientModel.setTelephonePortable(client.getTelephonePortable());
            clientModel.setTelephoneFixe(client.getTelephoneFixe());
            clientModel.setRib(client.getRib());
            clientModel.setAdresse(client.getAdresse());
            clientModel.setCreatedBy(client.getCreatedBy());
            clientModel.setDateCreation(client.getDateCreation());
            clientModel.setModifiedBy(client.getModifiedBy());
            clientModel.setDerniereDateModif(client.getDerniereDateModif());
            clientModel.setCategorieCode(client.getCategorieFournisseur().getNom());
            fournisseurModels.add(clientModel);
        });
        return fournisseurModels;
    }
    public List<ProduitModel> convertAllProduit(){

        List<Produit> produits=produitRepository.findAll();

        List<ProduitModel> produitModels=new ArrayList<>();

        produits.forEach( produit -> {

            ProduitModel produitModel=new ProduitModel();
produitModel.setId(produit.getId());

            produitModel.setRef(produit.getRef());
            produitModel.setQuantite(produit.getQuantite());
            produitModel.setPrixUnitaire(produit.getPrixUnitaire());
            produitModel.setCreatedBy(produit.getCreatedBy());
            produitModel.setModifiedBy(produit.getModifiedBy());
            produitModel.setDateCreation(produit.getDateCreationAudit());
            if(produit.getCategorieProduit()== null){
                produitModel.setCategorieCode(null);
            }else{
                produitModel.setCategorieCode(produit.getCategorieProduit().getNom());
            }
            produitModel.setDerniereDateModif(produit.getDerniereDateModif());
            produitModel.setAvc(produit.getAvc());
            produitModel.setMargeUnitaire(produit.getMargeUnitaire());
            produitModel.setMarque(produit.getMarque());
            produitModels.add(produitModel);
        });
        return produitModels;
    }
    public List<ClientModel> convertAllClient(){

        List<Client> clients=clientRepository.findAll();

        List<ClientModel> clientModels=new ArrayList<>();

        clients.forEach( client -> {

            ClientModel clientModel=new ClientModel();

            clientModel.setId(client.getId());
            clientModel.setLibelle(client.getLibelle());
            clientModel.setNom(client.getNom());
clientModel.setVille(client.getVille());
            clientModel.setAdresse(client.getAdresse());
            clientModel.setPrenom(client.getPrenom());
            clientModel.setNomSociete(client.getNomSociete());
            clientModel.setMail(client.getMail());
            clientModel.setTelephonePortable(client.getTelephonePortable());
            clientModel.setTelephoneFixe(client.getTelephoneFixe());
            clientModel.setRib(client.getRib());
            clientModel.setAdresse(client.getAdresse());
clientModel.setCreatedBy(client.getCreatedBy());
clientModel.setDateCreation(client.getDateCreation());
clientModel.setModifiedBy(client.getModifiedBy());
clientModel.setDerniereDateModif(client.getDerniereDateModif());
            clientModel.setCategorieCode(client.getCategorieClient().getNom());
clientModels.add(clientModel);
        });
return clientModels;
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
    public Fournisseur convertToFournisseurEntity(FournisseurModel viewModel) {
        // DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        CategorieFournisseur categorieFournisseur=categorieFournisseurRepository.getCategorieFournisseurByNom(viewModel.getCategorieCode());
        Fournisseur entity = new Fournisseur(viewModel.getId(),viewModel.getLibelle(),viewModel.getNom(),viewModel.getPrenom(),viewModel.getNomSociete(),viewModel.getMail(),viewModel.getTelephoneFixe(),viewModel.getTelephonePortable(),viewModel.getRib(),viewModel.getAdresse(),viewModel.getCreatedBy(),viewModel.getModifiedBy(),viewModel.getDateCreation(),viewModel.getVille(),categorieFournisseur,viewModel.getDerniereDateModif());

        return entity;
    }

    public Produit convertToProduitEntity(ProduitModel viewModel) {
        // DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        CategorieProduit categorieProduit=categorieProduitRepository.getCategorieProduitByNom(viewModel.getCategorieCode());
        Produit entity = new Produit();
entity.setId(viewModel.getId());
        entity.setRef(viewModel.getRef());
        entity.setQuantite(viewModel.getQuantite());
        entity.setPrixUnitaire(viewModel.getPrixUnitaire());
        entity.setDateCreationAudit(viewModel.getDateCreation());
        entity.setCreatedBy(viewModel.getCreatedBy());
        entity.setDerniereDateModif(viewModel.getDerniereDateModif());
        entity.setModifiedBy(viewModel.getModifiedBy());
        entity.setCategorieProduit(categorieProduit);
        entity.setAvc(viewModel.getAvc());
        entity.setMargeUnitaire(viewModel.getMargeUnitaire());
        entity.setMarque(viewModel.getMarque());
        return entity;
    }

    public Client convertToClientEntity(ClientModel viewModel) {
       // DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        CategorieClient categorieClient=categorieClientRepository.getCategorieClientByNom(viewModel.getCategorieCode());
        Client entity = new Client(viewModel.getId(),viewModel.getLibelle(),viewModel.getNom(),viewModel.getPrenom(),viewModel.getNomSociete(),viewModel.getMail(),viewModel.getTelephoneFixe(),viewModel.getTelephonePortable(),viewModel.getRib(),viewModel.getAdresse(),viewModel.getCreatedBy(),viewModel.getModifiedBy(),viewModel.getDateCreation(),viewModel.getVille(),categorieClient,viewModel.getDerniereDateModif());

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
                    x.getModifierStock(),
                    x.getDerniereDateModif()
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
                    factureDocuments.getModifierStock(),
                    factureDocuments.getDerniereDateModif()
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
//////////////////////////////////////////////////////////////

    public List<ReclamationModel> convertAllReclamation(){

        List<Reclamation> reclamations=reclamationRepository.getAllNotValid();

        List<ReclamationModel> reclamationModels=new ArrayList<>();

        reclamations.forEach( reclamation -> {

            ReclamationModel reclamationModel=new ReclamationModel();
            reclamationModel.setId(reclamation.getId());

            reclamationModel.setDescription(reclamation.getDescription());
            reclamationModel.setTitre(reclamation.getTitre());
            reclamationModel.setValide(reclamation.getValide());
            reclamationModel.setDateCreationAudit(reclamation.getDateCreationAudit());
reclamationModel.setDerniereDateModif(reclamation.getDerniereDateModif());
reclamationModel.setCreatedBy(reclamation.getCreatedBy());
reclamationModel.setModifiedBy(reclamation.getModifiedBy());
            reclamationModels.add(reclamationModel);
        });
        return reclamationModels;
    }


    public Reclamation convertToReclamationEntity(ReclamationModel viewModel) {
        Reclamation entity = new Reclamation();
        entity.setId(viewModel.getId());
        entity.setDescription(viewModel.getDescription());
        entity.setTitre(viewModel.getTitre());
        entity.setValide(viewModel.getValide());

        entity.setDateCreationAudit(viewModel.getDateCreationAudit());
        entity.setCreatedBy(viewModel.getCreatedBy());
        entity.setDerniereDateModif(viewModel.getDerniereDateModif());
        entity.setModifiedBy(viewModel.getModifiedBy());
        return entity;
    }

    ////////////////////////////////////:User
    public List<UserModel> convertAllUser(){

        List<AppUser> users=userRepository.findAll();

        List<UserModel> userModels=new ArrayList<>();

        users.forEach( user -> {

            UserModel userModel=new UserModel();
            userModel.setId(user.getId());
userModel.setUsernametest(user.getUsername());
            userModel.setEmail(user.getEmail());
            userModel.setPassword(user.getPassword());
            userModel.setUsername(user.getUsername());
userModel.setValid(user.getValid());
            userModels.add(userModel);
        });
        return userModels;
    }


    public AppUser convertToUserEntity(UserModel userModel) {

        AppUser entity = new AppUser();
        entity.setId(userModel.getId());
        entity.setUsername(userModel.getUsername());
        entity.setPassword(userModel.getPassword());
        entity.setValid(userModel.getValid());
        entity.setUsernametest(userModel.getUsername());
        return entity;
    }
}
