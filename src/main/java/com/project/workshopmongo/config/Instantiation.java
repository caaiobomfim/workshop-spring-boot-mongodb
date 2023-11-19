package com.project.workshopmongo.config;

import com.project.workshopmongo.domain.User;
import com.project.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User user1 = new User(null, "Maria", "maria@mail.com");
        User user2 = new User(null, "Davi", "davi@mail.com");
        User user3 = new User(null, "Lucas", "lucas@mail.com");
        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
