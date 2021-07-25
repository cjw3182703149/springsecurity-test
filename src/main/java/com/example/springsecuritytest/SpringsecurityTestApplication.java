package com.example.springsecuritytest;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
public class SpringsecurityTestApplication {
    //HttpServletRequest
    //RequestFacade
    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityTestApplication.class, args);
    }

}
