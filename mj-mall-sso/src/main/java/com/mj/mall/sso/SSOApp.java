package com.mj.mall.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
//@EnableRedisHttpSession
@EnableFeignClients(basePackages = "com.mj.mall.fegin")
@SpringBootApplication
public class SSOApp {

    public static void main(String[] args) {
        SpringApplication.run(SSOApp.class, args);
    }

}
