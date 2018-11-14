package com.park.server.demo;

import com.park.server.demo.model.Produit;
import com.park.server.demo.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerParkProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
SpringApplication.run(ServerParkProjectApplication.class,args);
   }

    @Override
    public void run(String... args) throws Exception {

    }
}
