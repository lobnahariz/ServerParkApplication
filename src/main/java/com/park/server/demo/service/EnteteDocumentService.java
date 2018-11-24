package com.park.server.demo.service;

import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.LineDocument;
import com.park.server.demo.model.Produit;
import com.park.server.demo.repository.EnteteDocumentRepository;
import com.park.server.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
/*
@Service
@Primary
public class EnteteDocumentService implements  IEnteteDocumentService {

    @Autowired
private EnteteDocumentRepository enteteDocumentRepository;

    @Override
    public List<EnteteDocument> getAllEnteteDocuments() {
        return enteteDocumentRepository.findAll();
    }

    @Override
    public EnteteDocument addEnteteDocument(EnteteDocument enteteDocument) {
     return  enteteDocumentRepository.save(enteteDocument);

    }

    @Override
    public void updateEnteteDocument(EnteteDocument enteteDocument) {
        enteteDocumentRepository.save(enteteDocument);
    }

   @Override
    public void deleteEnteteDocument(Long id) {
EnteteDocument enteteDocument = new EnteteDocument();
enteteDocument.setId(id);
enteteDocumentRepository.delete(enteteDocument);

    }

    @Override
    public void addLindToEntete(EnteteDocument enteteDocument, List<LineDocument> lineDocument) {
        enteteDocument.setLinesDocument(lineDocument);
        enteteDocumentRepository.save(enteteDocument);
    }

    @Override
    public EnteteDocument getEnteteByRef(String ref) {
        return enteteDocumentRepository.findByRef(ref);
    }
}
*/