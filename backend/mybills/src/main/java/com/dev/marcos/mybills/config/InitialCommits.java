package com.dev.marcos.mybills.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dev.marcos.mybills.entities.User;
import com.dev.marcos.mybills.repositories.UserRepository;

@Configuration
public class InitialCommits implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Marcos Vincius Angeli Costa", "(49) 99826-6688", "marcos@dev", "$2a$12$UlMPeGQjkblO..4vE3u.suZCnz58XIFz.o6PHW35PvwavA9YICvk6");
        repository.save(u1);
    }
    
}
