package com.park.server.demo.repository;

import com.park.server.demo.model.BonLivraisonDocument;
import com.park.server.demo.model.FactureDocument;

import javax.transaction.Transactional;

@Transactional
public interface FactureRepository extends EnteteDocumentBaseRepo<FactureDocument> {
}
