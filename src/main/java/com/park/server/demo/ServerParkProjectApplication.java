package com.park.server.demo;

import com.park.server.demo.model.*;
import com.park.server.demo.repository.RoleRepository;
import com.park.server.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaAuditing
public class ServerParkProjectApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
     private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public static void main(String[] args) {
SpringApplication.run(ServerParkProjectApplication.class,args);
   }

    public void addRoleToUSer(String username, String roleName) {
        AppRole role=roleRepository.findByRoleName(roleName);
        AppUser user=userRepository.findByUsername(username);
        user.getRoles().add(role);
        userRepository.saveAndFlush(user);
    }
    @Override
    public void run(String... args) throws Exception {
        String hashPW=bCryptPasswordEncoder.encode("1234");
        userRepository.save(new AppUser(null,"admin",hashPW,"oui",null,"admin"));
        userRepository.save(new AppUser(null,"lobna",hashPW,"oui",null,"lobna"));
        roleRepository.save(new AppRole(null,"ADMIN"));
        roleRepository.save(new AppRole(null,"USER"));
        addRoleToUSer("admin","ADMIN");
       addRoleToUSer("admin","USER");
        addRoleToUSer("lobna","USER");
    }

    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
