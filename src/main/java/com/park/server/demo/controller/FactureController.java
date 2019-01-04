package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.BonLivraisonDocument;
import com.park.server.demo.model.Client;
import com.park.server.demo.model.FactureDocument;
import com.park.server.demo.model.Fournisseur;
import com.park.server.demo.modelMapper.BonDeLivraisonDocumentModel;
import com.park.server.demo.modelMapper.FactureDocumentModel;
import com.park.server.demo.repository.BonDeLivraisonRepository;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.FactureRepository;
import com.park.server.demo.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.ValidationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/facture")
public class FactureController {
   private int i=1;

private float total=0;
    private Mapper mapper;
private Map<String,Float> listefournisseur=new HashMap<String,Float>();

    private Map<String,Float> listefournisseurNonPaye=new HashMap<String,Float>();


    private float totalJanvier;
    private float totalFev;
    private float totalMars;
    private float totalAvril;
    private float totalMai;
    private float totalJuin;
    private float totalJuillet;
    private float totalAout;
    private float totalSept;
    private float totalOct;
    private float totalNov;
    private float totalDec;


    private float totalLundi;
    private float totalMardi;
    private float totalMercredi;
    private float totalJeudi;
    private float totalVendredi;
    private float totalSamedi;
    private float totalDimanche;

    private float yearAvantAvantAvantAvantAvantAvantAvant;
    private float yearAvantAvantAvantAvantAvantAvant;
    private float yearAvantAvantAvantAvantAvant;
    private float yearAvantAvantAvantAvant;
    private float yearAvantAvantAvant;
    private float yearAvantAvant;
    private float yearCourant;



    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;
    public FactureController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<FactureDocumentModel> getAllBonFacture(){
        List<FactureDocument> factureDocuments = factureRepository.findAll();

        return  this.mapper.convertToFactureDocumentModel(factureDocuments);
    }
    @GetMapping("/NotPayed")
    public List<FactureDocumentModel> getAllBonFactureNonPaye(){
        List<FactureDocument> factureDocuments = factureRepository.getAllFactureNonPaye();

        return  this.mapper.convertToFactureDocumentModel(factureDocuments);
    }

    @GetMapping("/NotAllFactureWithNoStockUpdate")
    public List<FactureDocumentModel> getFactureWithNoStockUpdate(){
        List<FactureDocument> factureDocuments = factureRepository.getFactureWithNoStockUpdate();

        return  this.mapper.convertToFactureDocumentModel(factureDocuments);
    }
    @GetMapping("/getByRef/{ref}")
    public FactureDocumentModel getFactureById(@PathVariable String ref){

        FactureDocument factureDocument = factureRepository.getFactureDocumentByRef(ref);


        return  this.mapper.convertToFactureDocumentByIdModel(factureDocument);
    }
    @GetMapping("/getById/{id}")
    public FactureDocumentModel getFactureById(@PathVariable Long id){

        FactureDocument factureDocument = factureRepository.findById(id).get();


        return  this.mapper.convertToFactureDocumentByIdModel(factureDocument);
    }
    @PostMapping
    public FactureDocument save(@RequestBody FactureDocumentModel factureDocumentModel,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        FactureDocument factureDocument = this.mapper.convertToFactureDocumentEntity(factureDocumentModel);

        this.factureRepository.save(factureDocument);

        return factureDocument;
    }

    @PutMapping
    public void updateFacture(@RequestBody FactureDocumentModel factureDocumentModel,
    BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        FactureDocument factureDocument = this.mapper.convertToFactureDocumentEntity(factureDocumentModel);

        this.factureRepository.saveAndFlush(factureDocument);

    }
    @DeleteMapping("/{id}")
    public void deleteFacture(@PathVariable Long id){
        factureRepository.deleteById(id);
    }


    public Map<String,Float> getTotalVenteByFournisseur(){
        listefournisseur=new HashMap<String,Float>();
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        fournisseurs.forEach(fournisseur -> {

            List<FactureDocument> factureDocuments=factureRepository.getFactureDocumentByPersonne(fournisseur.getId());
            total=0;
            factureDocuments.forEach( factureDocument -> {
                total=total+factureDocument.getDocumenttotalTTCReduction();
                System.out.println(total+"***********");

            });
listefournisseur.put(fournisseur.getLibelle(),total);

        });

        ValueComparator comparateur = new ValueComparator(listefournisseur);
        TreeMap<String,Float> mapTriee = new TreeMap<String,Float>(comparateur);

        mapTriee.putAll(listefournisseur);
        return mapTriee;
    }

    @GetMapping("/getTopFournisseur")
    public List<String> getTopFournisseur(){
        Map<String,Float> getTotal=getTotalVenteByFournisseur();
        List<String> list=new ArrayList<>();
        i=1;
        getTotal.forEach((k, v) -> {
            if(i<=3){
                list.add(k);
                i++;
            }
        });
return list;
    }

    @GetMapping("/getTopValue")
    public List<String> getTopValue(){
        Map<String,Float> getTotal=getTotalVenteByFournisseur();
        List<String> list=new ArrayList<>();
        i=1;
        getTotal.forEach((k, v) -> {
            if(i<=3){
                list.add(Math.round(v)+"");
                i++;
            }
        });
        return list;
    }

    class ValueComparator implements Comparator<String> {
        Map<String, Float> base;

        public ValueComparator(Map<String, Float> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }




    @GetMapping("/getValueNotPayed")
    public List<String> getValueNotPayed(){
        Map<String,Float> getTotal=getTotalFactureAchatNotPayeByFournisseur();
        List<String> list=new ArrayList<>();
        getTotal.forEach((k, v) -> {
                list.add(Math.round(v)+"");
        });
        return list;
    }

    @GetMapping("/getFournisseurNotPayed")
    public List<String> getFournisseurNotPayed(){
        Map<String,Float> getTotal=getTotalFactureAchatNotPayeByFournisseur();
        List<String> list=new ArrayList<>();
        getTotal.forEach((k, v) -> {
            list.add(k);
        });
        return list;
    }

    public Map<String,Float> getTotalFactureAchatNotPayeByFournisseur(){
        listefournisseur=new HashMap<String,Float>();
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        fournisseurs.forEach(fournisseur -> {

            List<FactureDocument> factureDocuments=factureRepository.getAllAchatFactureNonPaye(fournisseur.getId());
            total=0;
            factureDocuments.forEach( factureDocument -> {
                float diff= factureDocument.getDocumenttotalTTCReduction()-factureDocument.getMontantPaye();
                total=total+diff;
            });
            listefournisseur.put(fournisseur.getLibelle(),total);

        });

        return listefournisseur;
    }

    @GetMapping("/getTotalRemiseAchat")
    public List<Integer> getTotalRemiseAchat(){

        totalJanvier=0;
        totalFev=0;
        totalMars=0;
        totalAvril=0;
        totalMai=0;
        totalJuin=0;
        totalJuillet=0;
        totalAout=0;
        totalSept=0;
        totalOct=0;
        totalNov=0;
        totalDec=0;
        List<Integer> list=new ArrayList<>();
        Date date=new Date();

        List<FactureDocument> factureDocuments = factureRepository.getAllAchatFacture();

        factureDocuments.forEach(factureDocument -> {

            String month=factureDocument.getDateCreationAudit().getMonth()+1+"";

            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("1")))
            {
                totalJanvier=totalJanvier+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("2")))
            {
                totalFev=totalFev+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("3")))
            {
                totalMars=totalMars+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("4")))
            {
                totalAvril=totalAvril+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("5")))
            {
                totalMai=totalMai+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("6")))
            {
                totalJuin=totalJuin+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("7")))
            {
                totalJuillet=totalJuillet+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("8")))
            {
                totalAout=totalAout+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("9")))
            {
                totalSept=totalSept+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("10")))
            {
                totalOct=totalOct+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("11")))
            {
                totalNov=totalNov+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("12")))
            {
                totalDec=totalDec+factureDocument.getDocumenttotalTTCReduction();

            }

        });

        list.add(Math.round(totalJanvier));
        list.add(Math.round(totalFev));
        list.add(Math.round(totalMars));
        list.add(Math.round(totalAvril));
        list.add(Math.round(totalMai));
        list.add(Math.round(totalJuin));
        list.add(Math.round(totalJuillet));
        list.add(Math.round(totalAout));
        list.add(Math.round(totalSept));
        list.add(Math.round(totalOct));
        list.add(Math.round(totalNov));
        list.add(Math.round(totalDec));

        return list;
    }


    @GetMapping("/getTotalRemiseVente")
    public List<Integer> getTotalRemiseVente(){

        totalJanvier=0;
        totalFev=0;
        totalMars=0;
        totalAvril=0;
        totalMai=0;
        totalJuin=0;
        totalJuillet=0;
        totalAout=0;
        totalSept=0;
        totalOct=0;
        totalNov=0;
        totalDec=0;
        List<Integer> list=new ArrayList<>();
        Date date=new Date();

        List<FactureDocument> factureDocuments = factureRepository.getAllVenteFacture();

        factureDocuments.forEach(factureDocument -> {

            String month=factureDocument.getDateCreationAudit().getMonth()+1+"";

            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("1")))
            {
                totalJanvier=totalJanvier+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("2")))
            {
                totalFev=totalFev+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("3")))
            {
                totalMars=totalMars+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("4")))
            {
                totalAvril=totalAvril+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("5")))
            {
                totalMai=totalMai+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("6")))
            {
                totalJuin=totalJuin+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("7")))
            {
                totalJuillet=totalJuillet+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("8")))
            {
                totalAout=totalAout+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("9")))
            {
                totalSept=totalSept+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("10")))
            {
                totalOct=totalOct+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("11")))
            {
                totalNov=totalNov+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("12")))
            {
                totalDec=totalDec+factureDocument.getDocumenttotalTTCReduction();

            }

        });

        list.add(Math.round(totalJanvier));
        list.add(Math.round(totalFev));
        list.add(Math.round(totalMars));
        list.add(Math.round(totalAvril));
        list.add(Math.round(totalMai));
        list.add(Math.round(totalJuin));
        list.add(Math.round(totalJuillet));
        list.add(Math.round(totalAout));
        list.add(Math.round(totalSept));
        list.add(Math.round(totalOct));
        list.add(Math.round(totalNov));
        list.add(Math.round(totalDec));

        return list;
    }




    public Map<String,Float> getTotalVenteByClient(){
        listefournisseur=new HashMap<String,Float>();
        List<Client> clients = clientRepository.findAll();
        clients.forEach(client -> {

            List<FactureDocument> factureDocuments=factureRepository.getFactureDocumentByPersonne(client.getId());
            total=0;
            factureDocuments.forEach( factureDocument -> {
                total=total+factureDocument.getDocumenttotalTTCReduction();

            });
            listefournisseur.put(client.getLibelle(),total);

        });

        ValueComparator comparateur = new ValueComparator(listefournisseur);
        TreeMap<String,Float> mapTriee = new TreeMap<String,Float>(comparateur);

        mapTriee.putAll(listefournisseur);
        return mapTriee;
    }

    @GetMapping("/getTotalAchatFactureNonPayeParMois")
    public List<Integer> getTotalAchatFactureNonPayeParMois(){


        totalJanvier=0;
        totalFev=0;
        totalMars=0;
        totalAvril=0;
        totalMai=0;
        totalJuin=0;
        totalJuillet=0;
        totalAout=0;
        totalSept=0;
        totalOct=0;
        totalNov=0;
        totalDec=0;
        List<Integer> list=new ArrayList<>();
        Date date=new Date();

        List<FactureDocument> factureDocuments = factureRepository.getAllAchatFactureNonPayeParMois();

        factureDocuments.forEach(factureDocument -> {

            String month=factureDocument.getDateCreationAudit().getMonth()+1+"";

            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("1")))
            {
                totalJanvier=totalJanvier+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("2")))
            {
                totalFev=totalFev+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("3")))
            {
                totalMars=totalMars+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("4")))
            {
                totalAvril=totalAvril+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("5")))
            {
                totalMai=totalMai+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("6")))
            {
                totalJuin=totalJuin+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("7")))
            {
                totalJuillet=totalJuillet+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("8")))
            {
                totalAout=totalAout+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("9")))
            {
                totalSept=totalSept+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("10")))
            {
                totalOct=totalOct+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("11")))
            {
                totalNov=totalNov+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("12")))
            {
                totalDec=totalDec+factureDocument.getDocumenttotalTTCReduction();

            }

        });

        list.add(Math.round(totalJanvier));
        list.add(Math.round(totalFev));
        list.add(Math.round(totalMars));
        list.add(Math.round(totalAvril));
        list.add(Math.round(totalMai));
        list.add(Math.round(totalJuin));
        list.add(Math.round(totalJuillet));
        list.add(Math.round(totalAout));
        list.add(Math.round(totalSept));
        list.add(Math.round(totalOct));
        list.add(Math.round(totalNov));
        list.add(Math.round(totalDec));

        return list;

    }


    @GetMapping("/getTotalAchatFacturePayeParMois")
    public List<Integer> getTotalAchatFacturePayeParMois(){


        totalJanvier=0;
        totalFev=0;
        totalMars=0;
        totalAvril=0;
        totalMai=0;
        totalJuin=0;
        totalJuillet=0;
        totalAout=0;
        totalSept=0;
        totalOct=0;
        totalNov=0;
        totalDec=0;
        List<Integer> list=new ArrayList<>();
        Date date=new Date();

        List<FactureDocument> factureDocuments = factureRepository.getAllAchatFacturePayeParMois();

        factureDocuments.forEach(factureDocument -> {

            String month=factureDocument.getDateCreationAudit().getMonth()+1+"";

            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("1")))
            {
                totalJanvier=totalJanvier+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("2")))
            {
                totalFev=totalFev+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("3")))
            {
                totalMars=totalMars+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("4")))
            {
                totalAvril=totalAvril+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("5")))
            {
                totalMai=totalMai+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("6")))
            {
                totalJuin=totalJuin+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("7")))
            {
                totalJuillet=totalJuillet+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("8")))
            {
                totalAout=totalAout+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("9")))
            {
                totalSept=totalSept+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("10")))
            {
                totalOct=totalOct+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("11")))
            {
                totalNov=totalNov+factureDocument.getDocumenttotalTTCReduction();
            }
            if((factureDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("12")))
            {
                totalDec=totalDec+factureDocument.getDocumenttotalTTCReduction();

            }

        });

        list.add(Math.round(totalJanvier));
        list.add(Math.round(totalFev));
        list.add(Math.round(totalMars));
        list.add(Math.round(totalAvril));
        list.add(Math.round(totalMai));
        list.add(Math.round(totalJuin));
        list.add(Math.round(totalJuillet));
        list.add(Math.round(totalAout));
        list.add(Math.round(totalSept));
        list.add(Math.round(totalOct));
        list.add(Math.round(totalNov));
        list.add(Math.round(totalDec));

        return list;

    }


    @GetMapping("/getTotalAchatFacturePayeEtNonPayeParMois")
    public List<Integer> getTotalAchatFacturePayeEtNonPayeParMois(){


        List<Integer> list=new ArrayList<>();

        List<Integer> getTotalPaye = getTotalAchatFacturePayeParMois();
        List<Integer> getTotalNonPaye = getTotalAchatFactureNonPayeParMois();



        for(int i=0;i<getTotalPaye.size();i++){

            list.add(getTotalPaye.get(i)+getTotalNonPaye.get(i));

        }

        return list;

    }














    @GetMapping("/getTotalAchatPayeParSemaine")
    public List<Integer> getTotalAchatPayeParSemaine(){


        totalLundi=0;
        totalMardi=0;
        totalMercredi=0;
        totalJeudi=0;
        totalVendredi=0;
        totalSamedi=0;
        totalDimanche=0;

        List<Integer> list=new ArrayList<>();

        List<FactureDocument> factureDocuments = factureRepository.getAllAchatFacturePayeParMois();

        factureDocuments.forEach(factureDocument -> {

            String month=factureDocument.getDateCreationAudit().getMonth()+1+"";
            String year=factureDocument.getDateCreationAudit().getYear()+1900+"";
            String day=factureDocument.getDateCreationAudit().getDay()+"";




// First convert to Date. This is one of the many ways.
            String dateString = String.format("%d-%d-%d", year, month, day);
            Date datex = null;
            try {
                datex = new SimpleDateFormat("yyyy-M-d").parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

// Then get the day of week from the Date based on specific locale.
            String dayOfWeek = new SimpleDateFormat("EEEE", Locale.FRANCE).format(datex);

           if(dayOfWeek.equals("lundi")){
               this.totalLundi = totalLundi +factureDocument.getDocumenttotalTTCReduction();
           }
            if(dayOfWeek.equals("mardi")){
                this.totalMardi = totalMardi +factureDocument.getDocumenttotalTTCReduction();

            }
            if(dayOfWeek.equals("mercredi")){
                this.totalMercredi = totalMercredi +factureDocument.getDocumenttotalTTCReduction();

            }
            if(dayOfWeek.equals("jeudi")){
                this.totalJeudi = totalJeudi +factureDocument.getDocumenttotalTTCReduction();
            }
            if(dayOfWeek.equals("vendredi")){
                this.totalVendredi = totalVendredi +factureDocument.getDocumenttotalTTCReduction();

            }
            if(dayOfWeek.equals("samedi")){
                this.totalSamedi = totalSamedi +factureDocument.getDocumenttotalTTCReduction();

            }
            if(dayOfWeek.equals("dimanche")){
                this.totalDimanche = totalDimanche +factureDocument.getDocumenttotalTTCReduction();

            }

        });

       list.add(Math.round(totalLundi));
        list.add(Math.round(totalMardi));
        list.add(Math.round(totalMercredi));
        list.add(Math.round(totalJeudi));
        list.add(Math.round(totalVendredi));
        list.add(Math.round(totalSamedi));
        list.add(Math.round(totalDimanche));


        return list;

    }

    @GetMapping("/getTotalAchatNonPayeParSemaine")
    public List<Integer> getTotalAchatNonPayeParSemaine(){


        totalLundi=0;
        totalMardi=0;
        totalMercredi=0;
        totalJeudi=0;
        totalVendredi=0;
        totalSamedi=0;
        totalDimanche=0;

        List<Integer> list=new ArrayList<>();

        List<FactureDocument> factureDocuments = factureRepository.getAllAchatFactureNonPayeParMois();

        factureDocuments.forEach(factureDocument -> {

            int month=(factureDocument.getDateCreationAudit().getMonth()+1);
            int year=(factureDocument.getDateCreationAudit().getYear()+1900);
            int day=factureDocument.getDateCreationAudit().getDay();



// First convert to Date. This is one of the many ways.
            String dateString = String.format("%d-%d-%d", year, month, day);
            Date datex = null;
            try {
                datex = new SimpleDateFormat("yyyy-M-d").parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

// Then get the day of week from the Date based on specific locale.
            String dayOfWeek = new SimpleDateFormat("EEEE", Locale.FRANCE).format(datex);

            if(dayOfWeek.equals("lundi")){
                this.totalLundi = totalLundi +factureDocument.getDocumenttotalTTCReduction();
            }
            if(dayOfWeek.equals("mardi")){
                this.totalMardi = totalMardi +factureDocument.getDocumenttotalTTCReduction();

            }
            if(dayOfWeek.equals("mercredi")){
                this.totalMercredi = totalMercredi +factureDocument.getDocumenttotalTTCReduction();

            }
            if(dayOfWeek.equals("jeudi")){
                this.totalJeudi = totalJeudi +factureDocument.getDocumenttotalTTCReduction();
            }
            if(dayOfWeek.equals("vendredi")){
                this.totalVendredi = totalVendredi +factureDocument.getDocumenttotalTTCReduction();

            }
            if(dayOfWeek.equals("samedi")){
                this.totalSamedi = totalSamedi +factureDocument.getDocumenttotalTTCReduction();

            }
            if(dayOfWeek.equals("dimanche")){
                this.totalDimanche = totalDimanche +factureDocument.getDocumenttotalTTCReduction();

            }

        });

        list.add(Math.round(totalLundi));
        list.add(Math.round(totalMardi));
        list.add(Math.round(totalMercredi));
        list.add(Math.round(totalJeudi));
        list.add(Math.round(totalVendredi));
        list.add(Math.round(totalSamedi));
        list.add(Math.round(totalDimanche));


        return list;

    }


    @GetMapping("/getTotalAchatFacturePayeEtNonPayeParSemaine")
    public List<Integer> getTotalAchatFacturePayeEtNonPayeParSemaine(){


        List<Integer> list=new ArrayList<>();

        List<Integer> getTotalPaye = getTotalAchatPayeParSemaine();
        List<Integer> getTotalNonPaye = getTotalAchatNonPayeParSemaine();



        for(int i=0;i<getTotalPaye.size();i++){

            list.add(getTotalPaye.get(i)+getTotalNonPaye.get(i));

        }

        return list;

    }




    @GetMapping("/getTotalAchatNonPayeParAnnee")
    public List<Integer> getTotalAchatNonPayeParAnnee(){


        yearAvantAvantAvantAvantAvantAvantAvant=0;
        yearAvantAvantAvantAvantAvantAvant=0;
        yearAvantAvantAvantAvantAvant=0;
        yearAvantAvantAvantAvant=0;
        yearAvantAvantAvant=0;
        yearAvantAvant=0;
        yearCourant=0;

        List<Integer> list=new ArrayList<>();
Date date =new Date();
        List<FactureDocument> factureDocuments = factureRepository.getAllAchatFactureNonPayeParMois();

        factureDocuments.forEach(factureDocument -> {

            int year=(factureDocument.getDateCreationAudit().getYear()+1900);


            if(year == date.getYear()+1900){
                this.yearCourant = yearCourant +factureDocument.getDocumenttotalTTCReduction();
            }
            if(year == ((date.getYear()+1900)-1)){
                this.yearAvantAvant = yearAvantAvant +factureDocument.getDocumenttotalTTCReduction();

            }
            if(year == ((date.getYear()+1900)-2)){
                this.yearAvantAvantAvant = yearAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();
            }
            if(year == ((date.getYear()+1900)-3)){
                this.yearAvantAvantAvantAvant = yearAvantAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();
            }
            if(year == ((date.getYear()+1900)-4)){
                this.yearAvantAvantAvantAvantAvant = yearAvantAvantAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();

            }
            if(year == ((date.getYear()+1900)-5)){
                this.yearAvantAvantAvantAvantAvantAvant = yearAvantAvantAvantAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();

            }
            if(year == ((date.getYear()+1900)-6)){
                this.yearAvantAvantAvantAvantAvantAvantAvant = yearAvantAvantAvantAvantAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();
            }

        });

        list.add(Math.round(yearAvantAvantAvantAvantAvantAvantAvant));
        list.add(Math.round(yearAvantAvantAvantAvantAvantAvant));
        list.add(Math.round(yearAvantAvantAvantAvantAvant));
        list.add(Math.round(yearAvantAvantAvantAvant));
        list.add(Math.round(yearAvantAvantAvant));
        list.add(Math.round(yearAvantAvant));


        list.add(Math.round(yearCourant));


        return list;

    }


    @GetMapping("/getTotalAchatPayeParAnnee")
    public List<Integer> getTotalAchatPayeParAnnee(){


        yearAvantAvantAvantAvantAvantAvantAvant=0;
        yearAvantAvantAvantAvantAvantAvant=0;
        yearAvantAvantAvantAvantAvant=0;
        yearAvantAvantAvantAvant=0;
        yearAvantAvantAvant=0;
        yearAvantAvant=0;
        yearCourant=0;

        List<Integer> list=new ArrayList<>();
        Date date =new Date();
        List<FactureDocument> factureDocuments = factureRepository.getAllAchatFacturePayeParMois();

        factureDocuments.forEach(factureDocument -> {

            int year=(factureDocument.getDateCreationAudit().getYear()+1900);


            if(year == date.getYear()+1900){
                this.yearCourant = yearCourant +factureDocument.getDocumenttotalTTCReduction();
            }
            if(year == ((date.getYear()+1900)-1)){
                this.yearAvantAvant = yearAvantAvant +factureDocument.getDocumenttotalTTCReduction();

            }
            if(year == ((date.getYear()+1900)-2)){
                this.yearAvantAvantAvant = yearAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();
            }
            if(year == ((date.getYear()+1900)-3)){
                this.yearAvantAvantAvantAvant = yearAvantAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();
            }
            if(year == ((date.getYear()+1900)-4)){
                this.yearAvantAvantAvantAvantAvant = yearAvantAvantAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();

            }
            if(year == ((date.getYear()+1900)-5)){
                this.yearAvantAvantAvantAvantAvantAvant = yearAvantAvantAvantAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();

            }
            if(year == ((date.getYear()+1900)-6)){
                this.yearAvantAvantAvantAvantAvantAvantAvant = yearAvantAvantAvantAvantAvantAvantAvant +factureDocument.getDocumenttotalTTCReduction();
            }

        });

        list.add(Math.round(yearAvantAvantAvantAvantAvantAvantAvant));
        list.add(Math.round(yearAvantAvantAvantAvantAvantAvant));
        list.add(Math.round(yearAvantAvantAvantAvantAvant));
        list.add(Math.round(yearAvantAvantAvantAvant));
        list.add(Math.round(yearAvantAvantAvant));
        list.add(Math.round(yearAvantAvant));


        list.add(Math.round(yearCourant));


        return list;

    }

    @GetMapping("/getTotalAchatFacturePayeEtNonPayeParAnnee")
    public List<Integer> getTotalAchatFacturePayeEtNonPayeParAnnee(){


        List<Integer> list=new ArrayList<>();

        List<Integer> getTotalPaye = getTotalAchatPayeParAnnee();
        List<Integer> getTotalNonPaye = getTotalAchatNonPayeParAnnee();



        for(int i=0;i<getTotalPaye.size();i++){

            list.add(getTotalPaye.get(i)+getTotalNonPaye.get(i));

        }

        return list;

    }

    @GetMapping("/getYears")
    public List<Integer> getYears(){



        List<Integer> list=new ArrayList<>();
        Date date =new Date();

        list.add((date.getYear()+1900)-6);
        list.add((date.getYear()+1900)-5);
        list.add((date.getYear()+1900)-4);
        list.add((date.getYear()+1900)-3);
        list.add((date.getYear()+1900)-2);
        list.add((date.getYear()+1900)-1);

        list.add(date.getYear()+1900);


        return list;

    }
}
