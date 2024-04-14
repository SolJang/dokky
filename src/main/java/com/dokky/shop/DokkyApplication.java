package com.dokky.shop;

import com.dokky.shop.api.pos.DomainEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class DokkyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DokkyApplication.class, args);
    }
}


