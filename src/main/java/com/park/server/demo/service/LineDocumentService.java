package com.park.server.demo.service;

import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.LineDocument;
import com.park.server.demo.repository.LineDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class LineDocumentService implements ILineDocumentService {

    @Autowired
    private LineDocumentRepository lineDocumentRepository;

    @Override
    public List<LineDocument> getLineDocuments() {
        return lineDocumentRepository.findAll();
    }

    @Override
    public void addLineDocument(LineDocument lineDocument) {
        lineDocumentRepository.save(lineDocument);
    }

    @Override
    public void updateLineDocument(LineDocument lineDocument) {
        lineDocumentRepository.save(lineDocument);
    }

    @Override
    public void deleteLineDocument(Long id) {
        LineDocument lineDocument = new LineDocument();
        lineDocument.setId_line(id);
        lineDocumentRepository.delete(lineDocument);
    }
}
