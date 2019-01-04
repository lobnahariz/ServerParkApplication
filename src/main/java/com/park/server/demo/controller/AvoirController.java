package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.Avoir;
import com.park.server.demo.model.Client;
import com.park.server.demo.model.FactureDocument;
import com.park.server.demo.modelMapper.AvoirModel;
import com.park.server.demo.modelMapper.ClientModel;
import com.park.server.demo.modelMapper.FactureDocumentModel;
import com.park.server.demo.repository.AvoirRepository;
import com.park.server.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/avoir")
public class AvoirController {

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
   private AvoirRepository avoirRepository;
   private Mapper mapper;


    public AvoirController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<Avoir> getAvoirs(){
        return avoirRepository.findAll(); }

    @PostMapping
    public Avoir addAvoir(@RequestBody AvoirModel avoirModel, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                throw new ValidationException();
            }
      Avoir avoir = this.mapper.convertToAvoirEntity(avoirModel);

            this.avoirRepository.save(avoir);
return avoir;
    }
    @GetMapping("/getById/{id}")
    public AvoirModel getAvoirById(@PathVariable Long id){

        Avoir avoirDocument = avoirRepository.findById(id).get();


        return  this.mapper.convertToAvoirDocumentByIdModel(avoirDocument);
    }
    @PutMapping
    public void updateAvoir(@RequestBody Avoir avoir){
        avoirRepository.save(avoir);
    }
    @DeleteMapping("/{id}")
    public void deleteAvoir(@PathVariable Long id)
    {
        avoirRepository.deleteById(id);
    }

    @GetMapping("/getAllAvoirAchat")
    public List<Integer> getAllAvoirAchat(){

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

        List<Avoir> avoirList =avoirRepository.getAllAchatAvoir();


        avoirList.forEach(avoirAchat -> {

            String month=avoirAchat.getDateCreationAudit().getMonth()+1+"";

            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("1")))
            {
                totalJanvier=totalJanvier+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("2")))
            {
                totalFev=totalFev+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("3")))
            {
                totalMars=totalMars+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("4")))
            {
                totalAvril=totalAvril+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("5")))
            {
                totalMai=totalMai+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("6")))
            {
                totalJuin=totalJuin+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("7")))
            {
                totalJuillet=totalJuillet+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("8")))
            {
                totalAout=totalAout+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("9")))
            {
                totalSept=totalSept+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("10")))
            {
                totalOct=totalOct+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("11")))
            {
                totalNov=totalNov+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("12")))
            {
                totalDec=totalDec+avoirAchat.getDocumenttotalTTCReduction();

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


    @GetMapping("/getAllAvoirVente")
    public List<Integer> getAllAvoirVente(){

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

        List<Avoir> avoirList =avoirRepository.getAllVenteAvoir();


        avoirList.forEach(avoirAchat -> {

            String month=avoirAchat.getDateCreationAudit().getMonth()+1+"";

            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("1")))
            {
                totalJanvier=totalJanvier+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("2")))
            {
                totalFev=totalFev+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("3")))
            {
                totalMars=totalMars+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("4")))
            {
                totalAvril=totalAvril+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("5")))
            {
                totalMai=totalMai+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("6")))
            {
                totalJuin=totalJuin+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("7")))
            {
                totalJuillet=totalJuillet+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("8")))
            {
                totalAout=totalAout+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("9")))
            {
                totalSept=totalSept+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("10")))
            {
                totalOct=totalOct+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("11")))
            {
                totalNov=totalNov+avoirAchat.getDocumenttotalTTCReduction();
            }
            if((avoirAchat.getDateCreationAudit().getYear()+1900 == date.getYear()+1900)&&(month.equals("12")))
            {
                totalDec=totalDec+avoirAchat.getDocumenttotalTTCReduction();

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
