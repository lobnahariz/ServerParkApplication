package com.park.server.demo.web;

import com.park.server.demo.model.AppUser;
import com.park.server.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

     @Autowired
    private AccountService accountService;

      @PostMapping("/register")
      public AppUser register(@RequestBody RegisterForm userForm)
      {
          if(!userForm.getPassword().equals(userForm.getRepassword())) throw new RuntimeException("you must confirm your password");
          AppUser user= accountService.findUserByUserName(userForm.getUsername());

          if(user!=null) throw new RuntimeException("this user already exist");
          AppUser  appUser = new AppUser();
          appUser.setUsername(userForm.getUsername());
          appUser.setPassword(userForm.getPassword());
           accountService.saveUser(appUser);
           accountService.addRoleToUSer(userForm.getUsername(),"USER");
           return appUser;
      }
}
