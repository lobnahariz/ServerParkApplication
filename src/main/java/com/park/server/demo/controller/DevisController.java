package com.park.server.demo.controller;

import com.park.server.demo.model.DevisDocument;
import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.modelMapper.DevisDocumentModel;
import com.park.server.demo.modelMapper.EnteteDocumentModel;
import com.park.server.demo.repository.DevisRepository;
import com.park.server.demo.repository.EnteteDocumentRepository;
import com.park.server.demo.service.IEnteteDocumentService;
import com.park.server.demo.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/devis")
@CrossOrigin
public class DevisController {

   /* @Autowired
    private IEnteteDocumentService enteteDocumentService;*/

  // private EnteteDocumentRepository enteteDocumentRepository;
    private Mapper mapper;

    @Autowired
    private DevisRepository devisRepository;

    public DevisController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<DevisDocument> getAllDevis(){
        return  devisRepository.findAll();
    }

    @PostMapping
    public DevisDocument save(@RequestBody DevisDocumentModel devisDocumentModel,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        DevisDocument devisDocument = this.mapper.convertToDevisDocumentEntity(devisDocumentModel);

        this.devisRepository.save(devisDocument);

        return devisDocument;
    }

    @PutMapping
    public void updateDevis(@RequestBody DevisDocument devisDocument){
        devisRepository.save(devisDocument);
    }
    @DeleteMapping("/{id}")
    public void deleteDevis(@PathVariable Long id){
        devisRepository.deleteById(id);
    }

}
