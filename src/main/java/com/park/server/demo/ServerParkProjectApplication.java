package com.park.server.demo;

import com.park.server.demo.model.*;
import com.park.server.demo.repository.ProduitRepository;
import com.park.server.demo.repository.TaskRepository;
import com.park.server.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
public class ServerParkProjectApplication implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
     private AccountService accountService;

    public static void main(String[] args) {
SpringApplication.run(ServerParkProjectApplication.class,args);
   }

    @Override
    public void run(String... args) throws Exception {
        accountService.saveUser(new AppUser(null,"admin","1234",null,null));
        accountService.saveUser(new AppUser(null,"user","1234",null,null));
accountService.saveRole(new AppRole(null,"ADMIN"));
        accountService.saveRole(new AppRole(null,"USER"));
        accountService.addRoleToUSer("admin","ADMIN");
        accountService.addRoleToUSer("admin","USER");
        accountService.addRoleToUSer("user","USER");


    }

    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
