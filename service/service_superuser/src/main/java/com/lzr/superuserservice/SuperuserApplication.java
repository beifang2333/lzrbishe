package com.lzr.superuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lzr"})
public class SuperuserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SuperuserApplication.class,args);
    }
}
