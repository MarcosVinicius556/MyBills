package com.dev.marcos.mybills.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dev.marcos.mybills.entities.Bills;
import com.dev.marcos.mybills.entities.User;
import com.dev.marcos.mybills.repositories.BillsRepository;
import com.dev.marcos.mybills.repositories.UserRepository;

@Configuration
public class InitialCommits implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BillsRepository billsRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Marcos Vincius Angeli Costa", "(49) 99826-6688", "marcos@dev", "$2a$12$UlMPeGQjkblO..4vE3u.suZCnz58XIFz.o6PHW35PvwavA9YICvk6");
        repository.save(u1);

        User u2 = new User("Ellen Santos Machado", "(49) 98840-1516", "ellen@psi", "$2a$12$UlMPeGQjkblO..4vE3u.suZCnz58XIFz.o6PHW35PvwavA9YICvk6");
        repository.save(u2);

        Bills bills_1 = new Bills("Café da tarde", new BigDecimal(35.0), LocalDateTime.now().toInstant(ZoneOffset.of("GMT-03:00")), 1, u1);
        billsRepository.save(bills_1);
    }
    
}
