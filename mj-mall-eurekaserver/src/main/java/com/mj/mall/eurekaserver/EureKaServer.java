package com.mj.mall.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurekaServer
public class EureKaServer {

    public static void main(String[] args) {
        SpringApplication.run(EureKaServer.class, args);
    }

}

