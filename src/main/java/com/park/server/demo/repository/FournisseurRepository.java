package com.park.server.demo.repository;

import com.park.server.demo.model.Client;
import com.park.server.demo.model.Fournisseur;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface FournisseurRepository extends PersonneBaseRepo<Fournisseur> {

}
