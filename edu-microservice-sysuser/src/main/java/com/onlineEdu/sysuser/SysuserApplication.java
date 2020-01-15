package com.onlineEdu.sysuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SysuserApplication {
    public static void main(String[] args){
        SpringApplication.run(SysuserApplication.class, args);
    }
}
