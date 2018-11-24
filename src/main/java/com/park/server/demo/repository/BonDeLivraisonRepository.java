package com.park.server.demo.repository;

import com.park.server.demo.model.BonLivraisonDocument;
import com.park.server.demo.model.DevisDocument;

import javax.transaction.Transactional;

@Transactional
public interface BonDeLivraisonRepository extends EnteteDocumentBaseRepo<BonLivraisonDocument> {
}
