package com.park.server.demo.modelMapper;

import java.util.Date;

public class UserModel {

    private Long id;


    private String username;
    private String password;
    private String valid;


    private String email;
private String usernametest;
    public Long getId() {
        return id;
    }

    public String getUsernametest() {
        return usernametest;
    }

    public void setUsernametest(String usernametest) {
        this.usernametest = usernametest;
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
