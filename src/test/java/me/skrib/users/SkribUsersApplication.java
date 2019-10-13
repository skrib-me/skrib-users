package me.skrib.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ActiveProfiles("test")
public class SkribUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkribUsersApplication.class, args);
    }

}
