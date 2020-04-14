package com.nikolay.stanchev.deVRealm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.nikolay.stanchev", "com.nikolay.stanchev.deVRealm.configuration"})
public class DeVRealmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeVRealmApplication.class, args);
    }
}
