package com.mj.mall.member.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan({"com.mj.mall.member","com.mj.mall.common","com.mj.mall.sso.interceptor"})
@MapperScan("com.mj.mall.member.mapper")
public class MemberApp {

    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class, args);
    }

}
