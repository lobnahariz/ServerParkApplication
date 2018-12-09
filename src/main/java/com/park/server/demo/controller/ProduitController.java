package com.park.server.demo.controller;

import com.park.server.demo.model.Client;
import com.park.server.demo.model.FactureDocument;
import com.park.server.demo.model.LineDocument;
import com.park.server.demo.model.Produit;
import com.park.server.demo.modelMapper.ChartMapModel;
import com.park.server.demo.modelMapper.ChartWithDateMapModel;
import com.park.server.demo.repository.FactureRepository;
import com.park.server.demo.repository.ProduitRepository;
import com.park.server.demo.service.IProduitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
public class ProduitController {

    @Autowired
private ProduitRepository produitRepository;
    int somme =0;
    List<ChartWithDateMapModel> chartWithDateMapModels=new ArrayList<>();
    @Autowired
    private FactureRepository factureRepository;
    @GetMapping("/api/produit")
    public List<Produit> getProduits(){
         return  produitRepository.findAll();
    }


    @GetMapping("/api/produit/getByRef/{ref}")
    public Produit getProduit(@PathVariable String ref){
        return  produitRepository.getProduitByRef(ref);
    }
    @GetMapping("/api/produit/totalByProduit")
    public List<ChartWithDateMapModel> getTotalVenteParMoisPourArticle(){
        int year= new Date().getYear()+1900;

        List<Produit> produitList=produitRepository.findAll();
        List<ChartWithDateMapModel> chartWithDateMapModels =new ArrayList<>();
        produitList.forEach(prod -> {

            for(int i=1;i<13;i++){

                List<FactureDocument> factureJanvierDocuments = getFactureDocumentPerMonth(i, year);
                getChartWithDateByProduit(chartWithDateMapModels,factureJanvierDocuments,prod.getRef(),i);

            }
        });
        System.out.println(chartWithDateMapModels.size()+"    Ref :    ");

        return chartWithDateMapModels;
    }

    @PostMapping("/api/produit")
    public void addProduit(@RequestBody Produit produit) {

        produitRepository.save(produit); }

    @PutMapping("/api/produit")
    public void updateProduit(@RequestBody Produit produit){
        produitRepository.saveAndFlush(produit);
    }
    @DeleteMapping("/api/produit/{id}")
    public void deleteProduit(@PathVariable Long id){
        produitRepository.deleteById(id);
    }


    public static String theMonth(int month){
        String monthString;
        switch (month) {
            case 1:  monthString = "January";
                break;
            case 2:  monthString = "February";
                break;
            case 3:  monthString = "March";
                break;
            case 4:  monthString = "April";
                break;
            case 5:  monthString = "May";
                break;
            case 6:  monthString = "June";
                break;
            case 7:  monthString = "July";
                break;
            case 8:  monthString = "August";
                break;
            case 9:  monthString = "September";
                break;
            case 10: monthString = "October";
                break;
            case 11: monthString = "November";
                break;
            case 12: monthString = "December";
                break;
            default: monthString = "Invalid month";
                break;
        }
return  monthString;
    }

    public List<ChartWithDateMapModel> getChartWithDateByProduit(List<ChartWithDateMapModel> chartWithDateMapModel,List<FactureDocument> factureDocuments,String produit,int month){


        factureDocuments.forEach(factureDocument->{
            somme=0;
            factureDocument.getLinesDocument().forEach(lineDocument -> {
                if(lineDocument.getCode().equals(produit)){
                    somme = somme + 1;
                }
            });

            chartWithDateMapModel.add(new ChartWithDateMapModel(produit,somme,theMonth(month)));
        });
        return chartWithDateMapModels;
    }


   public List<FactureDocument> getFactureDocumentPerMonth(int month,int year){

       List<FactureDocument> factureDocumentList = factureRepository.findAll();
       List<FactureDocument> factureResult=new ArrayList<>();

       factureDocumentList.forEach(x->{

           if((x.getDateCreationAudit().getYear()+1900) == year && (x.getDateCreationAudit().getMonth()+1) == month ){
               factureResult.add(x);
           }
       });
return factureResult;
    }
}
