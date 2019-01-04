package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.LineDocument;
import com.park.server.demo.modelMapper.LineDocumentModel;
import com.park.server.demo.repository.EnteteDocumentRepository;
import com.park.server.demo.repository.LineDocumentRepository;
import com.park.server.demo.service.IEnteteDocumentService;
import com.park.server.demo.service.ILineDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.*;

@RestController
@RequestMapping("/api/line")
public class LineController {

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

 /*   @Autowired
    private ILineDocumentService lineDocumentService;*/
       private LineDocumentRepository lineDocumentRepository;
       private EnteteDocumentRepository enteteDocumentRepository;
    private Mapper mapper;
    public LineController(LineDocumentRepository lineDocumentRepository,Mapper mapper,EnteteDocumentRepository enteteDocumentRepository) {
        this.lineDocumentRepository = lineDocumentRepository;
        this.mapper = mapper;
        this.enteteDocumentRepository = enteteDocumentRepository;
    }

    @GetMapping
    public List<LineDocument> getAllLines(){
        return  lineDocumentRepository.findAll();
    }
    @GetMapping("/byEntete/{enteteId}")
    public List<LineDocument> getAllLines(@PathVariable Long enteteId){
        List<LineDocument> lineDocuments =new ArrayList<>();

        EnteteDocument enteteDocument = enteteDocumentRepository.findById(enteteId).get();

        if (enteteDocument != null) {
            lineDocuments = this.lineDocumentRepository.findAllByEnteteDocument(enteteDocument);
        }
        return  lineDocuments;
    }
    @PostMapping("/{idEntete}")
    public LineDocument addLineDocument(@PathVariable Long idEntete,@RequestBody LineDocumentModel lineDocumentModel,
                                        BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        LineDocument lineDocument = this.mapper.convertToLineDocumentEntity(lineDocumentModel,idEntete);

        this.lineDocumentRepository.save(lineDocument);

        return lineDocument;
    }

    @PutMapping
    public LineDocument updateLineDocument(@PathVariable Long idEntete ,@RequestBody LineDocumentModel lineDocumentModel,
        BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                throw new ValidationException();
            }
            LineDocument lineDocument =  this.mapper.convertToLineDocumentEntity(lineDocumentModel,idEntete);

            this.lineDocumentRepository.saveAndFlush(lineDocument);
        return lineDocument;

        }
    @DeleteMapping("/{id}")
    public void deleteLineDocument(@PathVariable Long id){
        lineDocumentRepository.deleteById(id);
    }

    @GetMapping("/getTotalByProduitByAchat/{code}")
    public List<Integer> getTotalByProduitByAchat(@PathVariable String code){

        List<LineDocument> lineDocuments = lineDocumentRepository.findLineDocumentsByCode(code);
        List<Integer> valueProduit=new ArrayList<>();
        Date date=new Date();

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

        lineDocuments.forEach(lineDocument -> {

            if( lineDocument.getEnteteDocument().getAchat().equals("Achat")) {


                String month = lineDocument.getDateCreationAudit().getMonth() + 1 + "";


                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("1"))) {
                    totalJanvier = totalJanvier + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("2"))) {
                    totalFev = totalFev + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("3"))) {
                    totalMars = totalMars + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("4"))) {
                    totalAvril = totalAvril + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("5"))) {
                    totalMai = totalMai + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("6"))) {
                    totalJuin = totalJuin + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("7"))) {
                    totalJuillet = totalJuillet + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("8"))) {
                    totalAout = totalAout + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("9"))) {
                    totalSept = totalSept + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("10"))) {
                    totalOct = totalOct + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("11"))) {
                    totalNov = totalNov + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("12"))) {
                    totalDec = totalDec + lineDocument.getTotalTTC();

                }

            }

        });
        valueProduit.add(Math.round(totalJanvier));
        valueProduit.add(Math.round(totalFev));
        valueProduit.add(Math.round(totalMars));
        valueProduit.add(Math.round(totalAvril));
        valueProduit.add(Math.round(totalMai));
        valueProduit.add(Math.round(totalJuin));
        valueProduit.add(Math.round(totalJuillet));
        valueProduit.add(Math.round(totalAout));
        valueProduit.add(Math.round(totalSept));
        valueProduit.add(Math.round(totalOct));
        valueProduit.add(Math.round(totalNov));
        valueProduit.add(Math.round(totalDec));
        return valueProduit;
    }



    @GetMapping("/getTotalByProduitByVente/{code}")
    public List<Integer> getTotalByProduitByVente(@PathVariable String code){

        List<LineDocument> lineDocuments = lineDocumentRepository.findLineDocumentsByCode(code);
        List<Integer> valueProduit=new ArrayList<>();
        Date date=new Date();

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

        lineDocuments.forEach(lineDocument -> {

            if( lineDocument.getEnteteDocument().getAchat().equals("Vente")) {


                String month = lineDocument.getDateCreationAudit().getMonth() + 1 + "";


                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("1"))) {
                    totalJanvier = totalJanvier + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("2"))) {
                    totalFev = totalFev + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("3"))) {
                    totalMars = totalMars + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("4"))) {
                    totalAvril = totalAvril + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("5"))) {
                    totalMai = totalMai + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("6"))) {
                    totalJuin = totalJuin + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("7"))) {
                    totalJuillet = totalJuillet + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("8"))) {
                    totalAout = totalAout + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("9"))) {
                    totalSept = totalSept + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("10"))) {
                    totalOct = totalOct + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("11"))) {
                    totalNov = totalNov + lineDocument.getTotalTTC();
                }
                if ((lineDocument.getDateCreationAudit().getYear() + 1900 == date.getYear() + 1900) && (month.equals("12"))) {
                    totalDec = totalDec + lineDocument.getTotalTTC();

                }

            }

        });
        valueProduit.add(Math.round(totalJanvier));
        valueProduit.add(Math.round(totalFev));
        valueProduit.add(Math.round(totalMars));
        valueProduit.add(Math.round(totalAvril));
        valueProduit.add(Math.round(totalMai));
        valueProduit.add(Math.round(totalJuin));
        valueProduit.add(Math.round(totalJuillet));
        valueProduit.add(Math.round(totalAout));
        valueProduit.add(Math.round(totalSept));
        valueProduit.add(Math.round(totalOct));
        valueProduit.add(Math.round(totalNov));
        valueProduit.add(Math.round(totalDec));
        return valueProduit;
    }
}
