package com.park.server.demo.repository;

import com.park.server.demo.model.DevisDocument;

import javax.transaction.Transactional;

@Transactional
public interface DevisRepository extends EnteteDocumentBaseRepo<DevisDocument> {
}
