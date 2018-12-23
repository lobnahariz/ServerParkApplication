package com.park.server.demo.repository;

import com.park.server.demo.model.ReparationDocument;

import javax.transaction.Transactional;

@Transactional
public interface ReparationRepository extends EnteteDocumentBaseRepo<ReparationDocument> {
}
