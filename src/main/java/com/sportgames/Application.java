package com.sportgames;

import com.sportgames.config.AddSportsToBase;
import com.sportgames.config.TestData;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(
        basePackageClasses = {Application.class, Jsr310JpaConverters.class}
)
@EnableJpaRepositories
@SpringBootApplication
@ComponentScan("com.sportgames")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//
//    @Bean(initMethod = "initSports")
//    public AddSportsToBase initAddSportsToBase(){
//        return new AddSportsToBase();
//    }
//
//    @Bean(initMethod = "initData")
//    public TestData initTestData(){
//        return new TestData();
//    }

}