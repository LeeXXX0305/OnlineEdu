package com.onlineEdu.sysuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.onlineEdu.sysuser","com.onlineEdu.common"})
@EnableEurekaClient
public class CenterApplication {
    public static void main(String[] args){
        SpringApplication.run(CenterApplication.class, args);
    }
}
