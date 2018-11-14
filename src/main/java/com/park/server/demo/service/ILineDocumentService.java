package com.park.server.demo.service;

import com.park.server.demo.model.LineDocument;

import java.util.List;

public interface ILineDocumentService {

    List<LineDocument> getLineDocuments();

    void addLineDocument(LineDocument lineDocument);
    void updateLineDocument(LineDocument lineDocument);
    void deleteLineDocument(Long id);
}
