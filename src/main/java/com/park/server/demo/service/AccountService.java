package com.park.server.demo.service;

import com.park.server.demo.model.AppRole;
import com.park.server.demo.model.AppUser;

public interface AccountService {

public AppUser saveUser(AppUser user);
public AppRole saveRole(AppRole role);
public void addRoleToUSer(String username,String rolename);
public AppUser findUserByUserName(String username);

}
