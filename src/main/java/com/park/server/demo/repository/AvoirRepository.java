package com.park.server.demo.repository;

import com.park.server.demo.model.Avoir;
import com.park.server.demo.model.DevisDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AvoirRepository extends EnteteDocumentBaseRepo<Avoir> {
}
