package com.park.server.demo.service;



import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.Produit;

import java.util.List;

public interface IEnteteDocumentService {

    List<EnteteDocument> getAllEnteteDocuments();

    void addEnteteDocument(EnteteDocument enteteDocument);
    void updateEnteteDocument(EnteteDocument enteteDocument);
    void deleteEnteteDocument(Long id);
}
