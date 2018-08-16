package com.koin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.koin")
public class FinancialApp {

    public static void main(String[] args) {
        SpringApplication.run(FinancialApp.class, args);
    }

}
