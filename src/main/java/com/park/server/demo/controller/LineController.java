package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.LineDocument;
import com.park.server.demo.modelMapper.LineDocumentModel;
import com.park.server.demo.repository.LineDocumentRepository;
import com.park.server.demo.service.IEnteteDocumentService;
import com.park.server.demo.service.ILineDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/line")
@CrossOrigin
public class LineController {

 /*   @Autowired
    private ILineDocumentService lineDocumentService;*/
private LineDocumentRepository lineDocumentRepository;
    private Mapper mapper;
    public LineController(LineDocumentRepository lineDocumentRepository,Mapper mapper) {
        this.lineDocumentRepository = lineDocumentRepository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<LineDocument> getAllLines(){
        return  lineDocumentRepository.findAll();
    }

    @PostMapping("/{idEntete}")
    public LineDocument addLineDocument(@PathVariable Long idEntete,@RequestBody LineDocumentModel lineDocumentModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        LineDocument lineDocument = this.mapper.convertToLineDocumentEntity(lineDocumentModel,idEntete);

        // save notebookEntity instance to db
        this.lineDocumentRepository.save(lineDocument);

        return lineDocument;
    }

    @PutMapping
    public void updateLineDocument(@RequestBody LineDocument lineDocument){
        lineDocumentRepository.save(lineDocument);
    }
    @DeleteMapping("/{id}")
    public void deleteLineDocument(@PathVariable Long id){
        lineDocumentRepository.deleteById(id);
    }

}
