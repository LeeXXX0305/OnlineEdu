package com.onlineEdu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.onlineEdu.edu","com.onlineEdu.common"})
public class CenterApplication {
    public static void main(String[] args){
        SpringApplication.run(CenterApplication.class, args);
    }
}
