package com.mindly.crypto;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@Configuration
@SpringBootApplication
public class PortfolioManagementApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PortfolioManagementApplication.class, args);

    }

}
