package com.park.server.demo.controller;

import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.service.IEnteteDocumentService;
import com.park.server.demo.service.ILineDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devis")
@CrossOrigin
public class DevisController {

    @Autowired
    private IEnteteDocumentService enteteDocumentService;


    @GetMapping
    public List<EnteteDocument> getAllDevis(){
        return  enteteDocumentService.getAllEnteteDocuments();
    }

    @PostMapping
    public void addDevis(@RequestBody EnteteDocument enteteDocument) {
        System.out.println(enteteDocument.getLinesDocument().size()+"**************");
     //   enteteDocumentService.addEnteteDocument(enteteDocument);
    }

    @PutMapping
    public void updateDevis(@RequestBody EnteteDocument enteteDocument){
        enteteDocumentService.updateEnteteDocument(enteteDocument);
    }
    @DeleteMapping("/{id}")
    public void deleteDevis(@PathVariable Long id){
        enteteDocumentService.deleteEnteteDocument(id);
    }


}
