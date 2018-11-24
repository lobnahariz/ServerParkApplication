package com.park.server.demo.repository;

import com.park.server.demo.model.EnteteDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EnteteDocumentBaseRepo <T extends EnteteDocument>
        extends JpaRepository<T, Long> {

}