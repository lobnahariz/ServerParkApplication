package com.park.server.demo.repository;

import com.park.server.demo.model.EnteteDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnteteDocumentRepository extends JpaRepository<EnteteDocument,Long> {
}
