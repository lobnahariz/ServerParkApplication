package com.park.server.demo.repository;

import com.park.server.demo.model.LineDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineDocumentRepository extends JpaRepository<LineDocument,Long> {


}
