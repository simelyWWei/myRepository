package com.myexample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HelloworldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloworldApplication.class, args);
    }
}
