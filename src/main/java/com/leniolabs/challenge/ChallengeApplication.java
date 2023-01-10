package com.leniolabs.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.leniolabs.challenge.calculator.factory.AccounTypeAnnotationBeanNameGenerator;

@SpringBootApplication
@ComponentScan(nameGenerator = AccounTypeAnnotationBeanNameGenerator.class)
public class ChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeApplication.class, args);
    }

}
