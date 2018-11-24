package com.park.server.demo.repository;

import com.park.server.demo.model.Client;

import javax.transaction.Transactional;

@Transactional
public interface ClientRepository extends PersonneBaseRepo<Client> {
}
