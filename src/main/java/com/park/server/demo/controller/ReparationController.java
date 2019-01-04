package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.DevisDocument;
import com.park.server.demo.model.ReparationDocument;
import com.park.server.demo.modelMapper.DevisDocumentModel;
import com.park.server.demo.modelMapper.ReparationModel;
import com.park.server.demo.repository.ClientRepository;
import com.park.server.demo.repository.DevisRepository;
import com.park.server.demo.repository.FournisseurRepository;
import com.park.server.demo.repository.ReparationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reparation")
public class ReparationController {

    private Mapper mapper;
private int compteur=0;
    private int compteurYesterday=0;
private float gainToday=0;
    private float gainYesterday=0;

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

    @Autowired
    private ReparationRepository reparationRepository;

    public ReparationController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<ReparationDocument> getAllReparations(){
        return  reparationRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public ReparationModel getReparationById(@PathVariable Long id){

        ReparationDocument reparationDocument = reparationRepository.findById(id).get();


        return  this.mapper.convertToReparationDocumentModel(reparationDocument);
    }


    @PostMapping
    public ReparationDocument save(@RequestBody ReparationModel reparationModel,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        ReparationDocument reparationDocument = this.mapper.convertToReparationDocumentEntity(reparationModel);

        this.reparationRepository.save(reparationDocument);



        return reparationDocument;
    }

    @PutMapping
    public void updateReparation(@RequestBody ReparationModel reparationModel, BindingResult bindingResult)
    {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        ReparationDocument reparationDocument = this.mapper.convertToReparationDocumentEntity(reparationModel);

        this.reparationRepository.saveAndFlush(reparationDocument);

    }
    @DeleteMapping("/{id}")
    public void deleteReparation(@PathVariable Long id){
        reparationRepository.deleteById(id);
    }

    @GetMapping("/getTotalTodayReparation")
public int getTotalTodayReparation(){
        List<ReparationDocument> reparationDocuments=reparationRepository.findAll();
        Date date=new Date();
        compteur=0;
        reparationDocuments.forEach(reparationDocument1 -> {
            if( (date.getMonth()+1 == reparationDocument1.getDateCreationAudit().getMonth()+1)&&(reparationDocument1.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(reparationDocument1.getDateCreationAudit().getDate() == date.getDate()))
            {
                System.out.println(yesterday()+"*****"+yesterday().getYear()+"*****************"+yesterday().getDate()+"*****************"+yesterday().getMonth()+"*****************");

                this.compteur=compteur+1;
            }
        });
        return compteur;
 }
    @GetMapping("/getTotalYesterdayReperation")
 public int getTotalYesterdayReperation(){
     List<ReparationDocument> reparationDocuments=reparationRepository.findAll();
     compteurYesterday=0;
     reparationDocuments.forEach(reparationDocument1 -> {
         if( (yesterday().getMonth()+1 == reparationDocument1.getDateCreationAudit().getMonth()+1)&&(reparationDocument1.getDateCreationAudit().getYear()+1900 == yesterday().getYear()+1900)&&(reparationDocument1.getDateCreationAudit().getDate() == yesterday().getDate()))
         {

             this.compteurYesterday=compteurYesterday+1;
         }
     });
     return compteurYesterday;

 }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    @GetMapping("/getGainTodayReparation")
    public float getGainTodayReparation(){
        List<ReparationDocument> reparationDocuments=reparationRepository.findAll();
        Date date=new Date();
        gainToday=0;
        reparationDocuments.forEach(reparationDocument1 -> {
            if( (date.getMonth()+1 == reparationDocument1.getDateCreationAudit().getMonth()+1)&&(reparationDocument1.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(reparationDocument1.getDateCreationAudit().getDate() == date.getDate()))
            {

                this.gainToday=gainToday+reparationDocument1.getDocumenttotalTTCReduction();
            }
        });
        return gainToday;
    }


    @GetMapping("/getGainYesterdayReparation")
    public float getGainYesterdayReparation(){
        List<ReparationDocument> reparationDocuments=reparationRepository.findAll();
        Date date=new Date();
        gainYesterday=0;
        reparationDocuments.forEach(reparationDocument1 -> {
            if( (yesterday().getMonth()+1 == reparationDocument1.getDateCreationAudit().getMonth()+1)&&(reparationDocument1.getDateCreationAudit().getYear()+1900 == yesterday().getYear()+1900)&&(reparationDocument1.getDateCreationAudit().getDate() == yesterday().getDate()))
            {

                this.gainYesterday=gainYesterday+reparationDocument1.getDocumenttotalTTCReduction();
            }
        });
        return gainYesterday;
    }

    @GetMapping("/getNombreReparationEncours")
    public int getNombreReparationEncours() {
       return reparationRepository.getNombreReparationEncours();

    }

    @GetMapping("/getNombreReparationEnAttente")
    public int getNombreReparationEnAttente() {
        return reparationRepository.getNombreReparationEnAttente();

    }
    @GetMapping("/getNombreReparationNouvelle")
    public int getNombreReparationNouvelle() {
        return reparationRepository.getNombreReparationNouvelle();

    }
    @GetMapping("/getTotalReparationFinis")
    public List<Integer> getTotalReparationFinis(){
List<Integer> list=new ArrayList<>();
        List<ReparationDocument> reparationDocuments= reparationRepository.getReparationDocumentTermine();

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

        Date date=new Date();

        reparationDocuments.forEach(reparationDocument -> {
String month=reparationDocument.getDateCreationAudit().getMonth()+1+"";


if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("1")))
{
    totalJanvier=totalJanvier+reparationDocument.getDocumenttotalTTCReduction();
}
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("2")))
            {
                totalFev=totalFev+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("3")))
            {
                totalMars=totalMars+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("4")))
            {
                totalAvril=totalAvril+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("5")))
            {
                totalMai=totalMai+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("6")))
            {
                totalJuin=totalJuin+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("7")))
            {
                totalJuillet=totalJuillet+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("8")))
            {
                totalAout=totalAout+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("9")))
            {
                totalSept=totalSept+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("10")))
            {
                totalOct=totalOct+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("11")))
            {
                totalNov=totalNov+reparationDocument.getDocumenttotalTTCReduction();
            }
            if((reparationDocument.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("12")))
            {
                totalDec=totalDec+reparationDocument.getDocumenttotalTTCReduction();

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
}
