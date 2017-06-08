package com.nobledocs.dndui.fifth.catalogs.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class DnduiFifthCatalogsServiceApplication /*extends SpringBootServletInitializer */{

    public static void main(String[] args) {
        SpringApplication.run(DnduiFifthCatalogsServiceApplication.class, args);
    }
    
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(DnduiFifthCatalogsServiceApplication.class);
//    }
    
}
