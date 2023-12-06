package com.example.monakom_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MunakomCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(MunakomCloudApplication.class, args);
    }

}
