package com.park.server.demo.service;



import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.LineDocument;
import com.park.server.demo.model.Produit;

import java.util.Collection;
import java.util.List;

public interface IEnteteDocumentService {

    List<EnteteDocument> getAllEnteteDocuments();

    EnteteDocument addEnteteDocument(EnteteDocument enteteDocument);
    void updateEnteteDocument(EnteteDocument enteteDocument);
    void deleteEnteteDocument(Long id);
    public void addLindToEntete(EnteteDocument enteteDocument, Collection<LineDocument> lineDocument);
    public EnteteDocument getEnteteByRef(String ref);
}
