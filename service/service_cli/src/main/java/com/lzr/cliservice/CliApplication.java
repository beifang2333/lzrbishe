package com.lzr.cliservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lzr"})
@MapperScan(value = "com.lzr.cliservice.mapper")
public class CliApplication {
    public static void main(String[] args) {
        SpringApplication.run(CliApplication.class,args);
    }
}
