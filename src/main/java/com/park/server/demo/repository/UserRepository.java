package com.park.server.demo.repository;

import com.park.server.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {

    public AppUser findByUsername(String username);

}
