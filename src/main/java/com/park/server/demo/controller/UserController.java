package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.AppUser;
import com.park.server.demo.model.Produit;
import com.park.server.demo.modelMapper.ProduitModel;
import com.park.server.demo.modelMapper.UserModel;
import com.park.server.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {
    private Mapper mapper;
    @Autowired
    UserRepository userRepository;

    public UserController(Mapper mapper) {
        this.mapper = mapper;
    }

    @RequestMapping("/api/user")
    public Principal user(Principal user){
        return user;
    }
    @GetMapping("/register/user/verifExistance/{mail}/{login}")
    public int verifExistance(@PathVariable String mail,@PathVariable String login){
        int resultat=0;
        AppUser appUser=userRepository.findByEmail(mail);
        if(appUser!=null) resultat=1;
        appUser=userRepository.findByUsername(login);
        if(appUser!=null) resultat=1;
        return resultat;
    }
    @GetMapping("/api/user")
    public List<UserModel> getAllUser(){
        List<UserModel> liste= mapper.convertAllUser();
        liste.forEach(list->{
            System.out.println(list.getTestlogin());
        });
        return liste;
    }

    @PutMapping("/api/user")
    public void updateUtilisateur(@RequestBody UserModel userModel){
        AppUser appUser;
        if(userModel.getValid().equals("oui")) {
             appUser = this.mapper.convertToUserEntity(userModel);
        }else{
             appUser = this.mapper.convertToUserEntityFalse(userModel);

        }
        this.userRepository.saveAndFlush(appUser);
    }
    @DeleteMapping("/api/user/{id}")
    public void deleteUtilisateur(@PathVariable Long id){
        userRepository.deleteById(id);
    }


}
