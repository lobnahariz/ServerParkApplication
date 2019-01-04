package com.park.server.demo.repository;

import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.LineDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LineDocumentRepository extends JpaRepository<LineDocument, Long> {
List<LineDocument> findAllByEnteteDocument(EnteteDocument enteteDocument);

public List<LineDocument> findLineDocumentsByCode(String code);

}
