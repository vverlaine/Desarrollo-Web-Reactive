package com.example.DesarrolloWebReactive;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.bind.annotation.RestController;

@EnableR2dbcRepositories
@SpringBootApplication
@EnableEurekaClient
@RestController
public class DesarrolloWebReactiveApplication implements GreetingController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(DesarrolloWebReactiveApplication.class, args);
    }

    @Override
    public String greeting() {
        return String.format(
                "Microservicio:  '%s'!", eurekaClient.getApplication(appName).getName());
    }


}
