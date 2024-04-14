package com.dokky.shop.config;

import com.dokky.shop.api.pos.DomainEventPublisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfig implements WebMvcConfigurer, CommandLineRunner {

    private final ApplicationContext context;

    public SpringConfig( ApplicationContext context ) {
        this.context = context;
    }


    @Override
    public void run( String... args ) throws Exception {
        DomainEventPublisher.init( context );
    }
}
