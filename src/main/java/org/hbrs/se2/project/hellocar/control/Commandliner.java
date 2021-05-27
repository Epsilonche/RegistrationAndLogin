
/*
package org.hbrs.se2.project.hellocar.control;

import org.hbrs.se2.project.hellocar.dtos.impl.UserDTO;
import org.hbrs.se2.project.hellocar.repository.MeineUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Commandliner {

    private static final Logger log = LoggerFactory.getLogger(Commandliner.class);

    public static void main(String[] args) {
        SpringApplication.run(Commandliner.class);
    }

    @Bean
    public CommandLineRunner demo(MeineUserRepository repository) {
        return (args) -> {
            // save a few customers
            User newUser = new User();
            newUser.setUsername("Oth");
            newUser.setPassword("Lol12");
            repository.save(new User());


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

        };
    }
}

*/