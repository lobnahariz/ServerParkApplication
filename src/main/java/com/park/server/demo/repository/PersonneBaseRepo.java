package com.park.server.demo.repository;

import com.park.server.demo.model.EnteteDocument;
import com.park.server.demo.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonneBaseRepo<T extends Personne>
        extends JpaRepository<T, Long> {

}