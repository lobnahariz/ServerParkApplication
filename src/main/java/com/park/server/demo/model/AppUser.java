package com.park.server.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private String valid;
    private String testlogin;

    @ManyToMany(fetch=FetchType.EAGER)
private Collection<AppRole> roles = new ArrayList<>();

    public AppUser(String email, String username, String password, String valid, Collection<AppRole> roles,String testlogin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.valid = valid;
        this.roles = roles;
        this.testlogin=testlogin;
    }

    public String getTestlogin() {
        return testlogin;
    }

    public void setTestlogin(String testlogin) {
        this.testlogin = testlogin;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
