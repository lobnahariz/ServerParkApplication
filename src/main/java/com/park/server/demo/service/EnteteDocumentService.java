package com.park.server.demo.service;

import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.Produit;
import com.park.server.demo.repository.EnteteDocumentRepository;
import com.park.server.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void addEnteteDocument(EnteteDocument enteteDocument) {
        enteteDocumentRepository.save(enteteDocument);
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
}
