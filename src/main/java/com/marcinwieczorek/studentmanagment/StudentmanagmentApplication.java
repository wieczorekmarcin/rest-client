package com.marcinwieczorek.studentmanagment;

import com.marcinwieczorek.studentmanagment.repositories.UserRepository;
import com.marcinwieczorek.studentmanagment.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
public class StudentmanagmentApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(StudentmanagmentApplication.class, args);
    }

    @Override
    public void run(String...args) throws Exception{

        userRepository.save(new User("one", "one", 21972));
        userRepository.save(new User("two", "two", 15478));
        userRepository.save(new User("three", "three", 65879));

    }
}
