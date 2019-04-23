package com.mj.mall.test.hsql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mj.mall.test.hsql")
@MapperScan("com.mj.mall.test.hsql")
public class HsqlApp {

    public static void main(String[] args) {
        SpringApplication.run(HsqlApp.class, args);
    }

}
