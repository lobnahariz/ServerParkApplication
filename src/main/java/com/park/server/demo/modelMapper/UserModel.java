package com.park.server.demo.modelMapper;

import java.util.Date;

public class UserModel {

    private Long id;


    private String username;
    private String password;
    private String valid;


    private String email;
private String testlogin;



    public Long getId() {
        return id;
    }

    public String getTestlogin() {
        return testlogin;
    }

    public void setTestlogin(String testlogin) {
        this.testlogin = testlogin;
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

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
