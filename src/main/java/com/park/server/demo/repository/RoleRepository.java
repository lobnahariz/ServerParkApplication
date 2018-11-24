package com.park.server.demo.repository;

import com.park.server.demo.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface RoleRepository extends JpaRepository<AppRole,Long> {

public AppRole findByRoleName(String roleName);


}
